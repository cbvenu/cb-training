import java.util.*;
 interface venu
{
public void disp();
}

class Sample implements venu
{
public void mem()
{
System.out.println("My Personal Method");
}

public void disp()
{
System.out.println("Implemented Successfully");
}
public static void main (String[] args)
{
 Sample n=new Sample();
  n.disp();
 n.mem();
  int a=10;
  System.out.println(sizeof(a));

}
} 
