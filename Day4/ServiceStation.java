import java.util.*;

class Person 
{
  String name;
  int age;
  String addr;
 }

class Employee extends Person
{
List<Customer> clist=new ArrayList();
int empid;
static int count=0;
public void setEmp(String n,int a, String ad)
{
name=new String(n);
age=a;
addr=new String(ad);
empid=count+1;
count++;
}
public void display()
{
System.out.println(name+"\t"+empid+"\t"+age+"\t"+addr);
}
public void linkCustomer(Customer ob)
{
clist.add(ob);
}
}

class Customer extends Person
{
List<Vehicle> vlist=new ArrayList();
int assign;
int cid;
static int c_count=1;
public void setCustomer(String n,int a,String ad)
{
name=new String(n);
age=a;
addr=new String(ad);
cid=c_count;
c_count++;
}

public void setVehicle(Vehicle v)
{
vlist.add(v);
}
public void printVehicle()
{
for(int i=0;i<vlist.size();i++)
{
Vehicle p=vlist.get(i);
System.out.println(p.type+"---"+p.brand+"---"+p.charge);
}
}
public void empAssigned(int id)
{
assign=id;
}

public void disp()
{
System.out.println("Name : " + name);
System.out.println("ASiigned Id:"+assign);
}

}


class Service
{

List<Employee> elist=new ArrayList();
String name,address,contact;
final int car=100;
final int bike=50;
final int bus=200;
Service()
{
name=new String("VG");
address=new String("Chennai-96");
contact=new String("vgcars@gmail.com");
}
public void  addEmp(Employee e)
{
elist.add(e);
}
public int charging(String c)
{
if (c.equalsIgnoreCase("car"))
{
return car;
}
else if(c.equalsIgnoreCase("bike"))
return bike;
else
{
System.out.println("NOT IN a list");
return 0;
}
}
public void display()
{
System.out.println(name +" Service Station ");
System.out.println("-----------------------------");
System.out.println(address+"\t"+contact);
System.out.println("-----------------------------");
System.out.println("Service Charges ");
System.out.println("Car: "+car+"\nBike: "+bike+"\nBus: "+bus);
System.out.println("Employee Details");
System.out.println("-----------------------------");
for(int i=0;i<elist.size();i++)
{
Employee p=elist.get(i);
p.display();
}
}
}
class Vehicle
{

String brand,color,type;
int charge;
Vehicle(String ty,String b,String c )
{
type=new String(ty);
brand=new String(b);
color=new String(c);
}
public void setCharge(int c)
{
charge=c;
}
}

class Invoice
{

public void  printing(Customer c)
{
 System.out.println(c.name);
c.printVehicle();
}
}
public class ServiceStation
{
public static void main(String[] args)
{
   Employee[]  e=new Employee[2];
  e[0]=new Employee();
  e[1]=new Employee();
   e[0].setEmp("Employee1",25,"Chennai");
   e[1].setEmp("Employee2",34,"Salem");
  
  Customer c=new Customer();
  c.setCustomer("Venu",20,"Madurai");
  e[0].linkCustomer(c);
  c.empAssigned(0);
 Vehicle ve=new Vehicle("car","BMW","Black");
 Service s=new Service();
 s.addEmp(e[0]);
 s.addEmp(e[1]);
e[0].display();
 System.out.println("1.Service Station Details \n 2.Add Customer\n 3.Add Employee");
 int ch;
 Scanner sc=new Scanner(System.in);
 ch=sc.nextInt();
 switch(ch)
 {
   case 1:
         s.display();
 	 break;
   case 2:
         System.out.println("1.New Customer /n 2.Working Employee");
         int x;
         x=sc.nextInt();
         if(x==1)
         {
          Customer temp=new Customer();
          temp.setCustomer("VVV",20,"bangalore");
          
         }
}

// ve.setCharge(s.charging(ve.type));
// c.setVehicle(ve);
// Invoice i=new Invoice();
 // i.printing(c);
//c.disp();
}
}


  



