
import java.util.*;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.apache.commons.csv.*;

class JSONCSV
{

public static void fetching(JSONArray a,CSVParser p)
{
CSVPrinter pri = new CSVPrinter(new  FileWriter(new File("/home/cb-venugopal/cb-training/Week2/Files/sample_out.csv")),CSVFormat.EXCEL.withHeader());
for(CSVRecord record:p)
{
Iterator it=a.iterator();
List list=new ArrayList();
int i=0;
while(it.hasNext())
{
i++;
JSONObject temp=(JSONObject) it.next();
 String result=record.get(temp.get("Values").toString());
list.add(result);


/*else if(it.next() instanceof JSONArray)
{

JSONArray details=(JSONArray) it.next();
Set<String> keys = details.keyset();
String result;
for(int i=0;i<keys.size();i++)
{
if(result==null)
result=keys.get(i)+":"+record.get(keys.get(i).toString);
result=result+","+keys.get(i)+":"+record.get(keys.get(i).toString);
}
list.add(result);
}*/
pri.print(list);
pri.println();
}
System.out.println("MY FUNC"+i);
}

public static void main(String[] args)
{
  
  JSONParser parser= new JSONParser();
  JSONObject obj=(JSONObject) parser.parse(new FileReader("/home/cb-venugopal/cb-training/Week2/Files/document.json"));

  Reader r=new FileReader("/home/cb-venugopal/cb-training/Week2/Files/sample_input.csv");
  CSVParser p=new CSVParser(r,CSVFormat.EXCEL.withHeader());

  JSONArray arr=(JSONArray)obj.get("configuration");
  
  function(arr,parser);

}
}
