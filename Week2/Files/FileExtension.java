import java.util.*;
import java.io.*;


class FileExtension
{
static int count=0;
public static void check(Map<String,Integer> a,String s)
{
if(a.containsKey(s))
{
a.put(s,a.get(s)+1);
}
else
a.put(s,1);
}
public static File[] filesRet(String s)
{
File p=new File(s);
File[] a=p.listFiles();
return a;
}

public static void recursive(Map<String,Integer> m,String s)
{
String temp;
File[] a=filesRet(s);
 for(int i=0; i<a.length;i++)
 {
  if(a[i].isFile() && !a[i].isHidden())
  {
  temp=(a[i].getName());
  temp=temp.substring(temp.lastIndexOf(".")+1);
  check(m,temp);
 }
 else if(a[i].isDirectory() && !a[i].isHidden())
 {
  recursive(m,a[i].getAbsolutePath());
}
}
}

 
public static void main(String[] args)
{

 Map<String,Integer> m=new TreeMap<String,Integer>();
String sam="/home/cb-venugopal/cb-training";
recursive(m,sam);
for(Map.Entry ent: m.entrySet())
System.out.println(ent.getKey()+"-"+ent.getValue());
}
}
