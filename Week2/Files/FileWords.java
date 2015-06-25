import java.util.*;
import java.io.*;

class FileWords
{

public static void  doMap(Map<String,Integer> a, String s)
{
if(a.containsKey(s))
  a.put(s,a.get(s)+1);
else
 a.put(s,1);
}

 public static void main(String[] ar) throws Exception
 {
  FileReader fr=null;
 BufferedReader br=null;
PrintWriter output= new PrintWriter("/home/cb-venugopal/cb-training/target.txt");
Map<String,Integer> m=new TreeMap<String,Integer>();
  try{
    fr=new FileReader("/home/cb-venugopal/cb-training/one.txt");
    br=new BufferedReader(fr);
String data;
   while((data=br.readLine()) != null)
  {
 // System.out.println(data);
  String[] words=data.split(" ");
  for(int i=0;i<words.length;i++)
   doMap(m,words[i]);
 }

for(Map.Entry ent : m.entrySet())
{
System.out.println(ent.getKey()+":"+ent.getValue());
output.println(ent.getKey()+":"+ent.getValue());
}

}
finally
{
fr.close();
br.close();
output.close();
}
}
}
