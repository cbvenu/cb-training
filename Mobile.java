import java.util.*;

public class Mobile
{
interface vg
{
 public void remaining();
public void nameSet(String n );
}

 private int rc;
 Random r=new Random();
  private String name=new String();
public void func(String s)
{
 class Sample implements vg
 {
public void nameSet(String n)
{
name=n;
}
public void  remaining()
{
rc=r.nextInt(100);
System.out.println("Name :"+name+" \tRemaining :" +rc);
}
}

vg Sam =new Sample();
Sam.nameSet(s);
Sam.remaining();
}
public static void main(String [] args)
{
Mobile n=new Mobile();
n.func("TATA");
n.func("BSNL");
n.func("AIRTEL");

 }
}
