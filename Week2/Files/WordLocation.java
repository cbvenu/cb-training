import java.util.*;
import java.io.*;

 class WordLocation
{
  public static String func(String[] words,String s)
  {
   String out=new String();
   int l=0;
     for(int i=0;i<words.length;i++)
     {
      if(words[i].equals(s))
      out=out+l+",";
      l=l+words[i].length()+1;
     }
if(!out.equals(""))
{
out= out.substring(0,out.length()-1);
 return out;
}
else
return null;
}
  public static void main(String[] args) throws Exception
  {
   FileReader fr=null;
   BufferedReader br=null;
   PrintWriter  output=new PrintWriter("/home/cb-venugopal/cb-training/locate.txt");
   try
   {
   br=new BufferedReader(new FileReader("/home/cb-venugopal/cb-training/source.txt"));
  String search=new String("venu");
  String data;
 int line=0;
String r=new String();
  while((data=br.readLine())!=null)
  {
  line++;
  r=""+line+"-";   
  int location=0;
 String temp=func(data.split(" "),search);
 if(temp!=null)
 {
 r=r+temp;
 System.out.println(r);
  output.println(r);
}
}
}
finally
{
br.close();
output.close();
}
}
}
