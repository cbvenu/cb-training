/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.migrate;

import com.chargebee.app.InitializerServlet;
import com.chargebee.app.config.EntityType;
import com.chargebee.app.models.Comment;
import com.chargebee.app.models.Invoice;
import com.chargebee.app.models.NewInvoice;
import com.chargebee.app.models.Site;
import static com.chargebee.app.models.Tables.qinvoices;
import static com.chargebee.app.models.Tables.qnew_invoices;
import static com.chargebee.app.models.Tables.qsites;
import com.chargebee.app.models.base.InvoiceBase;
import com.chargebee.framework.jooq.SqlUtils;
import com.chargebee.framework.metamodel.DeleteFlagConfig;
import com.chargebee.framework.metamodel.SegmentConfig;
import com.chargebee.persistence.TxUtil;
import java.util.concurrent.Callable;
import org.jooq.Record;

/**
 *
 * @author cb-venu
 */
public class UnvoidInvoiceDBOperation {

    private static String addedBy;
    private static String invoiceNumber;
    private static Long invoiceID;
    private static String domain;
    private static String comment;
    private static NewInvoice newInvRecForVoidedInv = null;

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            System.out.println(String.format("Usage %s:<site_domain> <invoice_number> <comment_email_id> <comment_text>", UnvoidInvoiceDBOperation.class.getCanonicalName()));
            return;
        }
        domain = args[0];
        invoiceNumber = args[1];
        addedBy = args[2];
        comment = args[3];

        InitializerServlet.initStandAlone();
        Site s = fetchSite(domain);

        TxUtil.getInst().requiresNew(() -> {
            SegmentConfig.invokeInNewSegment(s, () -> {
                unvoidExecute();
                return null;
            });
            return null;
        });
    }

    private static void unvoidExecute() throws Exception {
        Invoice inv = fetchInvoice(invoiceNumber);
        if (inv == null || !inv.status_e().in(Invoice.Status.VOIDED)) {
            System.out.println("Given invoice is not valid to do this opreation. Please check. Process Terminated.");
            return;
        }
        invoiceID = inv.id();
        fetchNewInvoiceRecForVoidedInv();  // first invoice case
        inv.status(InvoiceBase.Status.PAYMENT_DUE).dbUpdate();  // changing the invoice status of the voided invoice to payment due
        if (newInvRecForVoidedInv != null) {
            NewInvoice presentFirstInvoice = fetchFirstInvoiceForCustomer(inv.customerId(), inv.recurring());
            if (presentFirstInvoice != null) {
                presentFirstInvoice.dbDelete();
            }
            newInvRecForVoidedInv.deleted(null).dbInsertOrUpdate();
        }
        Comment.addUserComment(EntityType.invoice, invoiceID, addedBy, comment);
    }

    private static void fetchNewInvoiceRecForVoidedInv() throws Exception {
        Callable c = (Callable) () -> {
            newInvRecForVoidedInv = qnew_invoices.invoice_id.dbFetchOne(invoiceID);
            return null;
        };
        DeleteFlagConfig.wrapInvokeWithoutDeletedFilter(c).call();
    }

    private static NewInvoice fetchFirstInvoiceForCustomer(Long customerId, boolean isRecurringInv) throws Exception {
        Record rec = SqlUtils.Sql().select(qnew_invoices.ALL).from(qnew_invoices)
                .join(qinvoices).on(qnew_invoices.invoice_id.equal(qinvoices.id))
                .where(qinvoices.customer_id.equal(customerId)).and(qinvoices.recurring.equal(isRecurringInv)).fetchOne();
        return rec != null ? qnew_invoices.create(rec) : null;
    }

    private static Invoice fetchInvoice(String invoiceNumber) throws Exception {
        return qinvoices.number.dbFetchOne(invoiceNumber);
    }

    private static Site fetchSite(String siteDomain) throws Exception {
        return SegmentConfig.invokeWithoutSegment(() -> {
            return qsites.domain.dbFetchOne(siteDomain);
        });
    }
}
