
import java.io.File;

public class Test {

	public static void main(String[] args) {
		

			File oldFile = new File("/home/cb-venugopal/cb-training/Day1/Hello.java");

			oldFile.renameTo(new File("/home/cb-venugopal/cb-training/Day2/"+ oldFile.getName())); 
	//			System.out.println("The file was moved successfully to the new folder");
			
	//			System.out.println("The File was not moved.");
			}

        }
