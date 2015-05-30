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
public class Power {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter X and Y");
        int x=sc.nextInt();
        int y=sc.nextInt();
        int i,temp;
        temp=x;
        for(i=1;;i++)
        {
            if(temp<=y)
                 temp=x*temp;
            else           
                break;
        }
        System.out.println("Output --->> "+ i);
    }
}