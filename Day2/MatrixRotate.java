/*
 cb-venugopal
 */
import java.util.*;
public class MatrixRotate {
    
   static void display(int[][] a,int r, int c)
    {
     for(int i=0;i<r;i++)
    {
        for(int j=0;j<c;j++)
                System.out.print(a[i][j]+ " ");
    System.out.println();
    }
    }
   
    static int[][] left(int a[][],int r,int c)
    {
        int i,j,temp=r-1;
        int[][] b=new int[r][c];
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
                b[i][j]=a[j][temp];
        temp--;
        }
        return b;
        
    }
    
    static int[][] right(int a[][],int r,int c)
    {
        int i,j,temp=c-1,k;
        int[][] b=new int[r][c];
        for(i=0;i<r;i++)
        {   temp=c-1;
            for(j=0;j<c;j++)
            {
                b[i][j]=a[temp][i];
                temp--;
            }
        }
        return b;
        
    }
    
    public static void main(String[] args)
    {
        System.out.println("Enter row and column");
        Scanner sc=new Scanner(System.in);
        int i,j,r,c;
       
        r=sc.nextInt();
        c=sc.nextInt();
         int[][] a=new int[r][c]; 
         int[][] b=new int[r][c];
        for(i=0;i<r;i++)
            for(j=0;j<c;j++)
               a[i][j]=sc.nextInt();
        int ch;
        System.out.println("Enter the choice \n 1.Left\n 2.Right");
        ch=sc.nextInt();
        System.out.println("-----Input------");
        display(a,r,c);
        System.out.println("\n-----Output-----");
        switch(ch)
        {
            case 1:
                b=left(a,r,c);
                display(b,r,c);
                break;
            case 2:
                b=right(a,r,c);
                display(b,r,c);
                break;
            default:
                 System.out.println("Wrong Option");
                
        }
   
    
    
    
    }
}
