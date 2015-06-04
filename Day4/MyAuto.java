import java.util.*;
import java.lang.*;

class Car
{
   int speed;
   double regularPrice;
   String color;
  Car(int speed,double price,String color)
  {
   this.speed=speed;
   this.regularPrice=price;
   this.color=new String(color);
  }
   double getScalePrice()
  {
   return regularPrice;
  }
}

class Truck extends Car
{
   int weight;
 Truck(int i)
{
super(50,1000,"Blue");
weight=i;
}
 
 double getScalePrice()
  {
    if (weight>2000)
    regularPrice=regularPrice-(regularPrice/10);
    else
    regularPrice=regularPrice-(regularPrice/5);
   return regularPrice;
  }
}

class Ford extends Car
{
  int year,manufactureDiscount;
  
 Ford(int y,int m)
 {
 super(60,20000,"Green");
  year=y;
  manufactureDiscount=m;
 }
 double getScalePrice()
 {
  regularPrice=regularPrice-manufactureDiscount;
 return regularPrice;
 }
}
class Sedan extends Car
{
  int length;
 Sedan (int l)
 {
 super(80,200000,"red");
 length=l;
 }
 double getScalePrice()
 {
//System.out.println("Actual Price :" +super.getScalePrice());
//String res=super.getScalePrice().toString();
 if(length>20)
  regularPrice=regularPrice-(regularPrice/20);
 else
  regularPrice=regularPrice-(regularPrice/10);
return regularPrice;
 }
}

public class MyAuto
{
 public static void main(String[] args)
  {
   Sedan s=new Sedan(21);
  System.out.println("Sedan Car \nSpeed: "+s.speed+"\nColor : "+s.color+"\nPrice : "+s.getScalePrice());

System.out.println("Ford Class");

 Ford f=new Ford(2002,1000);
 Ford f1=new Ford(2010,2000);
  System.out.println("Car 1 \nSpeed: "+f.speed+"\nColor : "+f.color+"\nYear : "+f.year+"\nPrice : "+f.getScalePrice());
  System.out.println("Car2 \nSpeed: "+f1.speed+"\nColor : "+f1.color+"\nYear : "+f1.year+"\nPrice : "+f1.getScalePrice());

}
}

