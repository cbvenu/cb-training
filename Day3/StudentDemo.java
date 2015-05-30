import java.util.*;
import java.lang.*;

class Subject
{
 private static Scanner sc=new Scanner(System.in);
  String s1,s2,s3;
  float m1,m2,m3;
 public void set()
{
 System.out.println("Enter the Subject1 name and corresponding mark");
 s1=sc.next();
 m1=sc.nextFloat();
 System.out.println("Enter the Subject2 name and corresponding mark");
 s2=sc.next();
 m2=sc.nextFloat();
System.out.println("Enter the Subject3 name and corresponding mark");
 s3=sc.next();
 m3=sc.nextFloat();
}
public void get()
{
System.out.println(s1+" : "+m1+"\n"+s2+" : "+m2+"\n"+s3+" : "+m3);
}
}
class Student 
{
  private static Scanner r=new Scanner(System.in);
  int stdid;
  String name;
  boolean gender;
  Subject sub;
  public void set()
  {
System.out.println("EnterID , Name , Gender"); 
 stdid=r.nextInt();
  name=r.next();
  gender=r.nextBoolean();
  sub=new Subject();
  sub.set();
  }
  public void get()
  {
  System.out.println("-----------------------------------------------------------");
  System.out.print("RegID:"+stdid+"  Name: "+name+"\t Gender:" );
  if(gender)
  System.out.println("Male");
  else
  System.out.println("Female");
  System.out.println("-----------------------------------------------------------");
  }
}

class Result
{

 static void generateResult(Student ref)
 {
  ref.get();
  ref.sub.get();
  float total=ref.sub.m1+ref.sub.m2+ref.sub.m3;
  System.out.println("Total : "+total+"\t Average: " +(total/3));
  System.out.println("----------------------------------------------------------");
}
}

public class StudentDemo
{
public static void main(String[] args)
{
 Student vg=new Student();
vg.set();
 Result.generateResult(vg);
}
}

