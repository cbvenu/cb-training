import java.util.*;
import java.lang.*;
class Person
{
 String name,address;
 String[] phone=new String[3];
  static int count=0;
 Person(String[] n)
 {
 name=new String(n[0]);
 address=new String(n[1]);
 phone[0]=new String(n[2]);
 phone[1]=new String(n[3]);
 phone[2]=new String(n[4]);
 count++;
 } 

public void display()
{
 System.out.println("\nName : "+name);
 System.out.println("Address :"+address);
 System.out.println("Phone Numbers");
 System.out.println("Home "+phone[1]+"\nMobile:"+phone[0]+"\nWork:"+phone[2]);
}

public boolean namecheck(CharSequence s)
{
 /* if(name.contains(s))
  return true;
  else return false;*/
 return name.contains(s);
}
public boolean numcheck(CharSequence s)
{
 if(phone[0].contains(s) || phone[1].contains(s) || phone[2].contains(s))
 return true;
 else 
 return false;
}
}
class PhoneDirect
{
public static void main(String[] args)
 {
  String[][] input=new String[3][5];
  input[0][0]=new String("Venu");
  input[0][1]=new String("Chennai");
  input[0][2]=new String("8122370690");
  input[0][3]=new String("1234561214");
  input[0][4]=new String("1231212431");
  
  input[1][0]=new String("Venugopal");
  input[1][1]=new String("Salem");
  input[1][2]=new String("88888888");
  input[1][3]=new String("77777777");
  input[1][4]=new String("66666666");
  
  input[2][0]=new String("gopal");
  input[2][1]=new String("Salem");
  input[2][2]=new String("3333333");
  input[2][3]=new String("2222222");
  input[2][4]=new String("1111111");

  Person p1 =new Person(input[0]);
   Person p2=new Person(input[1]);
  Person p3=new Person(input[2]); 
CharSequence s="Ven";
CharSequence b="8122370690";
  if(p1.namecheck(s))
   p1.display();

  if(p2.namecheck(s))
   p2.display();

  if(p3.namecheck(s))
   p3.display();
  if(p1.numcheck(b))
   p1.display();
  
}
}
