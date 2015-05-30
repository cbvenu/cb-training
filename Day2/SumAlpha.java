/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cb-venugopal
 */
import java.util.*;
import java.lang.*;
public class SumAlpha {
    public static void main(String[] args)
    {
        String s=new String();
        Scanner sc=new Scanner(System.in);
        s=sc.next();
        char[] a=new char[s.length()];
        a=s.toCharArray();
        int sum=0;
        for(int i=0;i<s.length();i++)
            sum=sum+(int)a[i];
        if(sum%2==0)
            System.out.println("Sum is EVEN");
        else
            System.out.println("Sum is ODD");
    }
}
