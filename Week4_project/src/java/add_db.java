/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cb-venugopal
 */
public class add_db extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String JDBC_DRIVER="com.mysql.jdbc.Driver";  
      String DB_URL="jdbc:mysql://localhost/login";
        
      //  Database credentials
        String USER = "root";
      String PASS = "";

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            /* TODO output your page here. You may use following sample code. */
             Class.forName("com.mysql.jdbc.Driver");
         // Open a connection
         Connection conn = (Connection)DriverManager.getConnection(DB_URL,USER,PASS);
        String last=request.getParameter("last_name");
        String address=request.getParameter("address");
        String email=request.getParameter("emails");
         // Execute SQL query
       
         Statement stmt = (Statement)conn.createStatement();
         String sql;
         sql="update users set last_name=\""+last+
                 "\", address=\""+address+"\" where email like \""+email+"\";";
        // out.println(sql);
         //out.println(sql);
         int  ms = stmt.executeUpdate(sql);
         
        if(ms==0)
         {
             out.println("failed ");
             
         }
         else
         {
            out.println("Success");
           // getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
         }
         
    }
catch(Exception e)
{
    System.out.println(e);
}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    }
}
