import java.util.*;
import java.lang.*;
class Maps2 
{
public static int check(ArrayList<String> a,String s)
{
int i=0,count=0;
for(i=0;i<a.size();i++)
{
// System.out.println("IN check :"+a.get(i)+s);
 if(a.get(i).startsWith(s)) 
{ 
// System.out.println(a.get(i));
 count++;
}
}
return count;
}
public static ArrayList<String> getWordList(ArrayList<String> ab,String s)
{
  int i=0;
  ArrayList<String> sendToMap=new ArrayList<String>();
  for(;i<ab.size();i++)
  {
    if((ab.get(i).startsWith(s)))
   {
  sendToMap.add(ab.get(i));  
  ab.remove(i);
    i--;
    }
}
 return sendToMap;
}
public static void main(String[] args)
{
  ArrayList<String> a=new ArrayList();
  a.add(new String("Venu"));
  a.add(new String("Venus"));
  a.add(new String("Gopal"));
  a.add(new String("Venkat"));
  a.add(new String("Venugoal"));
 a.add(new String("Java"));
 a.add(new String("Jamuna"));
 a.add(new String("JavaProgram"));
System.out.println("Given List:");
for(int k=0;k<a.size();k++)
System.out.println(a.get(k));
System.out.println("\nAfter Mapping\n");
Map<String,ArrayList> m=new TreeMap<String,ArrayList>();
/*Comparator<String> strcomp=new Comparator<String>()
{
 public int compare(String a,String b){ return a.compareTo(b);}};*/
int i,j,k,len=0;
String temp=a.get(0);
len=temp.length();
while(a.size()!=0)
{
String sample=new String(a.get(0));
int c=0,count=0;
if(sample.length()>2)
{
  sample=sample.substring(0,3);
   c=check(a,sample);
//System.out.println(c); 
 if(c>1)
    {
     count=c;
     len=sample.length();
    temp=sample;
    m.put(temp,getWordList(a,temp));
    }
else
a.remove(0);
}
else
a.remove(0);
}
for(Map.Entry ent: m.entrySet())
System.out.println(ent.getKey()+"-->>"+ent.getValue());
}
}
