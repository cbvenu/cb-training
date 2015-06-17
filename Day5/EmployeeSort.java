import java.util.*;

class Employee
{
  String name;
  int age;
  long salary;
Scanner sc=new Scanner(System.in);
Employee(String n,int a,long s)
{
name=new String(n);
age=a;
salary=s;
}
public void set()
{
System.out.println("Enter Employee name,age and salary");
name=new String(sc.next());
age=sc.nextInt();
salary=sc.nextLong();
}
public String getName()
{
return name;
}
public void show()
{
System.out.println(name+"\t"+age+"\t"+salary);
}
}

/* class NameComparing implements Comparator<Employee>
{

 public int compare(Employee o1,Employee o2)
    {
   String name1=o1.getName();
   String name2=o2.getName();
     return name1.compareTo(name2);
}
}*/

public class EmployeeSort
{
  public static void main(String[] args)
  {
    Employee[] emp = new Employee[4];
 emp[0] = new Employee("Mikey", 25, 10000);
 emp[1] = new Employee( "Arun", 29, 20000);
 emp[2] = new Employee( "Lisa", 35, 5000);
 emp[3] = new Employee( "Pankaj", 32, 50000);

Comparator<Employee> NameCompare=new Comparator<Employee>()
{
 public int compare(Employee o1, Employee o2)
  {
   return o2.getName().compareTo(o1.getName());
  }
};

Comparator<Employee> AgeCompare = new Comparator<Employee>()
{
  public int compare(Employee o1,Employee o2)
  {
   return o1.age-o2.age;
  }
};
Comparator<Employee> SalaryCompare=new Comparator<Employee>()
{
 public int compare (Employee o1,Employee o2)
 {
  return (int) (o1.salary-o2.salary);
 }
};

System.out.println("Enter the option \n 1.Sort By name\n2.Sort By Age\n3.Sort By Salary");
Scanner sc=new Scanner(System.in);
 int ch=sc.nextInt();
 switch(ch)
 {
  case 1:
      Arrays.sort(emp,NameCompare);
      break;
  case 2:
     Arrays.sort(emp,AgeCompare);
     break;
  case 3:
     Arrays.sort(emp,SalaryCompare);
     break;
  default:
    System.out.println("Wrong Choice");
   }


System.out.println("After Sorting :");
 for(int i=0;i<emp.length;i++) 
  {
  emp[i].show();
  }

}
}
