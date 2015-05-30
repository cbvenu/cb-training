
import java.util.*;
public class Pyramid {
    public static void main(String[] args)
    {
        System.out.println("Enter Limit :");
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        int i,j;
        System.out.println("-------------------------");
        for( i=1;i<=n;i++)
        {
            for( j=n;j>i;j--)
            System.out.print(" ");
            
            for(j=1;j<=i;j++)
                 System.out.print(j);
            if(i>1)
            {
            for(j=i-1;j>=1;j--)
                System.out.print(j);
            } 
            System.out.println();
        }
     System.out.println("--------------------------");
    }
}
