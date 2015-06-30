import java.util.*;
import java.io.*;
import org.apache.commons.csv.*;
class CsvFiles
{

 public static void main(String[] args) throws Exception
 {
  List<String> list=new ArrayList<String>();
  CSVPrinter p = new CSVPrinter(new  FileWriter(new File("/home/cb-venugopal/cb-training/out.csv")),CSVFormat.EXCEL.withHeader());
   Reader in =new FileReader("/home/cb-venugopal/cb-training/input.csv");
   CSVParser parser =new CSVParser (in, CSVFormat.EXCEL.withSkipHeaderRecord(true));  
// Iterable<CSVRecord> r= CSVFormat.EXCEL.withHeader().parse(in)
//    list=parser.getRecords();  

for(CSVRecord record :parser)
{
    if(!list.contains(record.toString()))
    { System.out.println(record.get(0));
       list.add(record.toString());
       p.printRecord(record);
     }   
}
//System.out.println(list);
//   p.printRecords(s);
	p.close();
}
}
