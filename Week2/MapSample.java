import java.util.*;

class MapSample
{


 public static void main(String [] args)
 {
 HashMap<Integer,ArrayList> m=new HashMap<Integer, ArrayList>();
 int i,j;
  Scanner sc=new Scanner(System.in);
  ArrayList<String> str=new ArrayList();
  for( i=0;i<5;i++)
  {
 String s=new String();
  s=sc.next();
  str.add(s);;
  }
System.out.println("After \n");
ArrayList<String> copy=(ArrayList) str.clone();
i=0;

while(copy.size()!=0)
 {
  int len;
 len=copy.get(i).length();
  ArrayList<String> temp=new ArrayList();
  temp.add(copy.get(i));
  for(j=1;j<copy.size();j++)
  {
  String one=copy.get(i).toString();
  String two=copy.get(j).toString();
   if(one.length() == two.length())
   {
     temp.add(copy.get(j));
     copy.remove(j);
    j--;
    }
  }
 copy.remove(i);
m.put(len,temp);
}

for(Map.Entry ent : m.entrySet())
System.out.println(ent.getKey()+"--->>>"+ent.getValue());
}
}
