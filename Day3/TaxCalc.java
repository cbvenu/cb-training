import java.util.*;
import java.lang.*;
import java.math.BigDecimal;
class Employee
{
 private static Scanner sc=new Scanner(System.in);
  String name,gender;
  BigDecimal salary,tax,tax_amount,limit,taxable;
  public void set()
  {
  System.out.println("Enter name,gender and salary");
  name=sc.next();
  gender=sc.next();
  String s=sc.next();
  salary=new BigDecimal(s);
 setInfo();
  }
  public void get()
  {
  System.out.print(name+"\t"+gender+"\t"+salary+"\t"+taxable+"\t"+tax_amount+"\n");
  }
 
   public void setInfo()
   {
    if(gender.equals("male")||gender.equals("Male"))
    {
    tax=new BigDecimal(12.5);
   limit=new BigDecimal(200000);
    }
   else
   {
   tax=new BigDecimal(10);
   limit=new BigDecimal(180000);
   }
} 
}
class TaxIn
{
 public static void calcu(Employee e)
 {
  BigDecimal div=new BigDecimal(100);
  div=e.tax.divide(div);
 e.taxable=e.salary.subtract(e.limit);
  if(e.taxable.intValue()>0)
   e.tax_amount=div.multiply(e.taxable);
 else
   e.tax_amount=new BigDecimal(0);
}
}

public class TaxCalc
{
 public static void main(String[] args)
 {
      Employee[] e=new Employee[2];
     e[0]=new Employee();
    e[1]=new Employee();
    e[0].set();
   e[1].set();
   TaxIn.calcu(e[0]);
  TaxIn.calcu(e[1]);
  e[0].get();
  }
}





 
