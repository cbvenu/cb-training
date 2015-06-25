import java.util.*;
import java.io.*;
import org.apache.commons.csv.*;
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
 System.out.println("Home: "+phone[1]+"\nMobile:"+phone[0]+"\nWork:"+phone[2]);
}

public boolean namecheck(String s)
{
 /* if(name.contains(s))
  return true;
  else return false;*/
 return name.contains(s);
}
public boolean numCheck(String s)
{
 if(phone[0].contains(s) || phone[1].contains(s) || phone[2].contains(s))
 return true;
 else 
 return false;
}
}
class PhoneCSV
{
public static void main(String[] args) throws Exception
 {

List <Person> list=new ArrayList<Person>();
Reader r=new FileReader("/home/cb-venugopal/cb-training/Week2/Files/phone_input.csv");
CSVParser parser=new CSVParser(r,CSVFormat.EXCEL.withHeader());

for(CSVRecord record: parser)
{
  String[] a=new String[record.size()];
  for(int i=0;i<record.size();i++)
  a[i]=new String(record.get(i));
 Person temp=new Person(a);
 list.add(temp);
 System.out.println(record.get("Name")+"\t"+record.get("Address"));
}

//list.get(0).display();
parser.close();



String ns="ven";
String num="8122370690";
System.out.println("Names starting with ven");
for(int i=0;i<list.size();i++)
{
if(list.get(i).namecheck(ns))
 list.get(i).display();
}

System.out.println("Number 8122370690 is owned BY");
for(int i=0;i<list.size();i++)
if(list.get(i).numCheck(num))
list.get(i).display();

}
}
