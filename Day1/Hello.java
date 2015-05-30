
import java.util.Scanner;

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
public class Hello {
    public static void main(String[] args)
    {
        System.out.println("Hello Venugopal");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter X and Y");
        int x=sc.nextInt();
        int y=sc.nextInt();
        int z=x+y;
        System.out.println("Addition :"+z);
        if(z<0)
            System.out.println("The sum is Negative");
        else if(z>0)
            System.out.println("The Sum is Positive");
        else
            System.out.println("The Sum is Zero");
    }
}
