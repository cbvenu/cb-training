
import java.util.*;
  class BaseClass
{
  public int a;
  private int b;
  static int c;
  int d;
 final int e;
 static
{
 c=1;
}
protected String name="Venu";
public void set()
{
c=110;
}
BaseClass()
{

a=10;
b=11;
e=0;
d=12;
}
}

 class Derived extends BaseClass
{

Derived()
{
super();
}
  public void disp()
  {
  System.out.println(a+"---"+e+"---"+c+name+"---"+d);
 }
}

class Derived2 extends Derived
{

Derived2()
{
super();
}
 
public void display()
{
System.out.println("In Derived Class Level 1");
disp();
System.out.println("In Level 2 \n"+a+"==="+e+"==="+c+name+"==="+d);
}
}

public class MultiLevel
{
 public static void main(String[] args)
{

  Derived2 d=new Derived2 ();
  d.display();
}
}
