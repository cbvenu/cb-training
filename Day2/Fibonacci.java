import java.util.*;

class Fibonacci 
{

public static void main(String[] args)
{
  int a=-1,b=1,c=0,n;
  Scanner sc= new Scanner (System.in);
  System.out.println("Enter the Limit");
  n=sc.nextInt();
  for(int i=1;i<=n;i++)
  {
   c=a+b;
   a=b;
   b=c;
   System.out.println(c);
  }
}
}
