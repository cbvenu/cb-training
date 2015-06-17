import java.util.*;

interface Iterator
{
public int fact(int n);
}
class Factorial 
{
 static int lowerlimit,upperlimit;
 
  Factorial(int i,int j)
 {
  lowerlimit=i;
  upperlimit=j;
 }

class Inner implements Iterator
{
 
  public int fact(int n)
  {
  int f=1;
  while(n>0)
  {
    f=f*n;
    n--;
   }
//System.out.println(f);
  return f;
 }
}

Inner iterator()
{
 Inner a=new Inner();
return a;
}
    
public String  toString()
{
String output=new String();
Inner object=iterator();
output=output+object.fact(lowerlimit);
for(int i=lowerlimit+1;i<=upperlimit;i++)
{
output=output+","+(object.fact(i));
}
return output;
}


public static void main(String[] args)
{
 System.out.println("Enter Lower and Upper Limits");
 Scanner sc=new Scanner(System.in);
 int i=sc.nextInt();
 int j=sc.nextInt();
  Factorial f=new Factorial(i,j);
System.out.println(f.toString());
}
}
