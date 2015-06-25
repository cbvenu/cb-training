import java.util.*;
import java.io.*;
class FileMove
{
  
 private static boolean filecheck(File[] a, String s)
 {
   int i;
  boolean flag=false;
  for(i=0;i<a.length;i++)
  {
    if(s.equals(a[i].getName()))
    {  
     flag=true;
 //    break;
break;
    }
 }
return flag;
}
    
public static void main(String [] args)
{

String old="/home/cb-venugopal/cb-training/Move1";
String n="/home/cb-venugopal/cb-training/Move2";

File p=new File(old);
File r=new File(n);

File[] current=p.listFiles();
File[] next=r.listFiles();
int i=0;

String tempName=new String();
for(i=0;i<current.length;i++)
{
if(current[i].isFile())
{
int count=0;
String temp=current[i].getName();
tempName=current[i].getName().substring(0,current[i].getName().lastIndexOf("."));
System.out.println(next.length);
while(filecheck(next,temp))
    {
     count++;
    if(tempName.lastIndexOf("-")>0)
     tempName=tempName.substring(0,tempName.lastIndexOf("-"))+"-"+count;
     else
     tempName=tempName+"-"+count;
     temp=tempName+"."+temp.substring(temp.lastIndexOf(".")+1);
     }
   current[i].renameTo(new File("/home/cb-venugopal/cb-training/Move2/"+temp));
}
}
}
}
      
