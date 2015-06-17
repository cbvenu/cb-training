import java.util.*;

class Sample
{
  public static void main(String[] args)
  {
  ArrayList<String> a=new ArrayList(3);
  a[0].add("Venu");
  a[1].add("VG");
  a[2].add("four");
   Map<String, List<Person>> out=a.collect(Collectors.groupingBy(String::String.length()));
}
}
