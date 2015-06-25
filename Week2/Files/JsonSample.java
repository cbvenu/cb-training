import java.util.*; 
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;

class Person
{
  String dob,ID,name;
 // List<String> std;
 
}

class Student extends Person
{
 String std;;
 Map m=new HashMap();
 Student (JSONObject student)
 {
 this.name=student.get("Name").toString();
 this.ID=student.get("ID").toString();
 this.dob=student.get("Date Of Joining").toString();
 this.std=student.get("Std").toString();
 JSONArray arr=(JSONArray) student.get("Marks");
 Iterator it=arr.iterator();
 while(it.hasNext())
 {
 JSONObject temp=(JSONObject)it.next();
 m.put(temp.get("Subject"),temp.get("Mark"));
 }
 }

public void show()
{
System.out.println("----------------------------\nStudent Details\n----------------------------");
System.out.println("Name :        \t"+name+"\nDate Of Joining:"+dob+"\nID :\t\t"+ID+"\n Marks Score in Subjects\n "+m);
}
}

class Teacher extends Person
{
int salary;
List<Object> classes=new ArrayList<Object>();

 Teacher (JSONObject teacher)
 {
 this.name=teacher.get("Name").toString();
 this.ID=teacher.get("ID").toString();
 this.dob=teacher.get("Date Of Joining").toString();
 this.salary=Integer.parseInt(teacher.get("Salary").toString());
 JSONArray arr=(JSONArray) teacher.get("Classes Taking Care Of");
 Iterator it=arr.iterator();
 while(it.hasNext())
 {
// JSONObject temp=(JSONObject)it.next();
 classes.add(it.next()); 
}
 }

public void show()
{

System.out.println("----------------------------\nTeacher Details\n----------------------------");
System.out.println("Name :      \t"+name+"\nDate Of Joining:"+dob+"\nID :\t\t"+ID+"\nSalary :  \t"+salary+"\nClasses Taking Care OF\n "+classes);

}
}



class JsonSample
{
 public static void main(String[] args) throws Exception
 {
 
  JSONParser par=new JSONParser();
 JSONObject n=(JSONObject)par.parse(new FileReader("/home/cb-venugopal/cb-training/Week2/Files/sample.json"));
 Map<String,Integer> marks=new HashMap<String,Integer>();

// JSONObject o=obj.getJSONObject("Student");
 JSONObject student=(JSONObject)n.get("Student");
 JSONObject teacher=(JSONObject)n.get("Teacher");


//for(int i=0;i<arr.length();i++)
//{
//}
 Student obj1=new Student(student);
 Teacher ob2=new Teacher(teacher);
obj1.show(); 
System.out.println("\n\n");
ob2.show();
}
}
