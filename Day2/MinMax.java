import java.util.*;

public class MinMax
{
public static void function(int[] a,int n)
{
   int min,max;
   min=max=a[0];
   for(int i=1;i<n;i++)
   {
     if(a[i]<min)
     min=a[i];
    else if(a[i]>max)
    max=a[i];
}

System.out.println("MINIMUM--> "+ min+"\nMAXIMUM--> " + max);
}

 public static void main(String[] args)
 {
  int[] a;
  int n,i;
  System.out.println("Enter Number of elements");
  Scanner sc=new Scanner(System.in);
  n=sc.nextInt();
  a=new int[n];
  System.out.println("Enter "+n+" Integers");
  for(i=0;i<n;i++)
  a[i]=sc.nextInt();
  function(a,n);
}
}
