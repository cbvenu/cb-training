import java.util.*;
import java.lang.*;
class Desc
{
  String name;
  static int count=0; 
  boolean isMammal,isRep;
  public boolean get()
  {
  System.out.println("Enter Animal Name");
  Scanner sc=new Scanner(System.in);
  name=sc.next();
  System.out.println("Enter type of Animal. MAmmal/Reptile");
  String o=sc.next();
 if(o.equals("Mammal")||o.equals("mammal"))
  {
   isMammal=true;
   isRep=false;
   count++;
   return true;
  }
  else if(o.equals("Reptile")||o.equals("reptile"))
 {
 isMammal=false;
 isRep=true;
 count++;
 return true;
 }
else 
{
System.out.println("Wrong Data. system exit");
return false;
}
}

public void disp()
{
System.out.print("Name: "+ name+"\nType:");
if(isMammal)
System.out.println("Mammal");
else
System.out.println("Reptile");
}
}
public class Animal extends Desc
{
public static void main(String[] args)
{
    Desc[] a =new Desc[10];
    int i=-1;
   do
   {
    ++i;
    a[i]=new Desc();
   }
   while(a[i].get());
   a[0].disp();
}
} 
