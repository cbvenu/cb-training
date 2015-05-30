import java.util.*;
import java.math.BigDecimal;
public class InterestCalc {
    public static void main(String[] args)
    {
      BigDecimal n=new BigDecimal(5);
      BigDecimal r=new BigDecimal(10);
      BigDecimal p=new BigDecimal(1000);
     BigDecimal op;
    BigDecimal div=new BigDecimal(100);
    op= r.multiply(p).multiply(n);
    System.out.println("<< --  Simple Interest  -- >>\n Interset: "+op.divide(div)+"\n Total Amount:"+op.divide(div).add(p));
      BigDecimal one=new BigDecimal(1);
     op=one.add(r.divide(div));
     op=op.pow(5);
     op=p.multiply(op);
  System.out.println("<< -- Compound Interest  -- >> \n Output :"+op);

}
}
