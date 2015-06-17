import java.util.*;

class  ListSample
{
  public static void main(String[] args)
  {
    ArrayList a=new ArrayList();
   a.add(1);
   a.add(2);
   a.add(2,"Venu");
   for(int i=0;i<a.size();i++)
   {
   System.out.println(a.get(i));
   }
  System.out.println(a.contains("Venu"));
}
}

 
