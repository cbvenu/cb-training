
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.apache.commons.csv.*;
import java.text.DateFormat;

class JSONCSV
{
private static void dateFormatter(JSONObject obj,List a,CSVRecord r) throws Exception
{
String full1=r.get(obj.get("Values").toString());
String day=full1.substring(0,full1.lastIndexOf("T"));
String time=full1.substring(full1.lastIndexOf("T")+1,full1.lastIndexOf("."));
String full=day+" "+time;
SimpleDateFormat formatter = new SimpleDateFormat(obj.get("Format").toString());
SimpleDateFormat convert = new SimpleDateFormat(obj.get("ToFormat").toString());
Date date = formatter.parse(full);
a.add(convert.format(date));
}


private static void headerAdd(JSONArray a,CSVPrinter p) throws Exception
{

Iterator it=a.iterator();
List list=new ArrayList();

while(it.hasNext())
{
JSONObject temp=(JSONObject) it.next();
list.add(temp.get("Column Name").toString());
}
p.printRecord(list);
}

public static void fetching(JSONArray a,CSVParser p,CSVPrinter pri) throws Exception
{

System.out.println("MY FUNC"+a.size());
for(CSVRecord record:p)
{
Iterator it=a.iterator();
String result="";
List list=new ArrayList();
while(it.hasNext())
{

JSONObject temp=(JSONObject) it.next();
//System.out.println("VENU"+temp.get("Format"));

if(temp.get("Format")!=null && list.size()!=0)
{
dateFormatter(temp,list,record);
}
else if(!(temp.get("Column Name").equals("Customer Details")))
{ 
//if(!(result.equals("")))
//result=result+",";
 result=record.get(temp.get("Values").toString());
//System.out.println(result);
list.add(result);

}

else if((temp.get("Column Name").equals("Customer Details"))) 
{
JSONObject details=(JSONObject) temp.get("Values");
result="\"First Name\":\""+record.get(details.get("First Name").toString())+"\" , \"";
result=result+"Last Name\":\""+record.get(details.get("Last Name").toString())+"\" , \"";
result=result+"Email\":\""+record.get(details.get("Email").toString())+"\" , \"";
result=result+"Company\":\""+record.get(details.get("Company").toString())+"\"";
list.add(result);
}

 
}
pri.printRecord(list);

}

pri.close();
}

public static void main(String[] args) throws Exception
{
  JSONParser parser= new JSONParser();
  JSONObject obj=(JSONObject) parser.parse(new FileReader("/home/cb-venugopal/cb-training/Week2/Files/document.json"));
  CSVPrinter pri = new CSVPrinter(new  FileWriter(new File("/home/cb-venugopal/cb-training/Week2/Files/sample_out.csv")),CSVFormat.EXCEL.withSkipHeaderRecord(true));
  Reader r=new FileReader("/home/cb-venugopal/cb-training/Week2/Files/sample-input.csv");
  CSVParser p=new CSVParser(r,CSVFormat.EXCEL.withHeader());

  JSONArray arr=(JSONArray)obj.get("configuration");
headerAdd(arr,pri);  
  fetching(arr,p,pri);
}
}
