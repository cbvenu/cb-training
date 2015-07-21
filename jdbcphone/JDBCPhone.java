/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcphone;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author cb-venugopal
 */
public class JDBCPhone {

    static final String DB_URL = "jdbc:mysql://localhost/JDBCPhone";
    static final String USER = "root";
    static final String PASS = "";
    private static Connection conn = null;
    private static JSONObject jsonobject = null;
    private static JSONArray arr = null;
    private static Statement stmt = null;

    private static void initialize() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = (Statement) conn.createStatement();
            JSONParser par = new JSONParser();
            jsonobject = (JSONObject) par.parse(new FileReader("/home/cb-venugopal/cb-training/Week2/Files/phone_input.json"));
            arr = (JSONArray) jsonobject.get("Details");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private static void createDB() throws SQLException {
        String c = "create database JDBCPhone;";
        stmt.executeUpdate(c);
    }

    private static void createTable() throws SQLException {
        String c = "create table Directory(name varchar(20),"
                + "address varchar(30),work varchar(10),"
                + "home varchar(10),mobile varchar(10))";
        stmt.executeUpdate(c);
    }
     private static void loadIntoDB() throws SQLException {

        PreparedStatement ps = null;
        Iterator it = arr.iterator();
        ps = conn.prepareStatement("insert into Directory "
                + "values(?,?,?,?,?)");

        while (it.hasNext()) {
            JSONObject obj = (JSONObject) it.next();
            JSONObject phone = (JSONObject) obj.get("Phone");
            ps.setString(1, obj.get("Name").toString());
            ps.setString(2, obj.get("Address").toString());
            ps.setString(3, phone.get("Work").toString());
            ps.setString(4, phone.get("Home").toString());
            ps.setString(5, phone.get("Mobile").toString());
            ps.execute();
        }
    }

    private static void display(ResultSet res) throws SQLException {
        if(!res.next())
            System.out.println("No Such Result Found");
        else
        {
        System.out.println("Name\t  Address\t Work\t\tHome\t\tMobile");
        res.beforeFirst();
        }
        while (res.next()) {
            System.out.print(res.getString("name") + "    ");
            System.out.print(res.getString("address") + "\t");
            System.out.print(res.getString("work") + "\t");
            System.out.print(res.getString("home") + "\t");
            System.out.println(res.getString("mobile"));
        }
    }

    private static void numberSearch(String num) throws SQLException {

        ResultSet rs = stmt.executeQuery("SELECT * FROM Directory WHERE "
                + "home LIKE \"" + num + "\" "
                + "OR work LIKE \"" + num + "\" "
                + "OR mobile LIKE \"" + num + "\"");

        display(rs);
    }

    private static void nameSearch(String s) throws Exception {
        ResultSet rs = stmt.executeQuery("SELECT * FROM Directory WHERE name LIKE \"%" + s + "%\"");
        display(rs);
    }

   
    private static void updateEntry() throws Exception
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter any phone Number to update");
        String num=sc.next();
        System.out.println("Enter which field you want to update and its value ex. name venu");
        String field=sc.next();
        String value=sc.next();
        String query="UPDATE Directory SET "+field+"=\""+value
                + "\" WHERE home LIKE \"" + num + "\" "
                + "OR work LIKE \"" + num + "\" "
                + "OR mobile LIKE \"" + num + "\";";
        System.out.println(query);
        if(stmt.executeUpdate(query)!=0)
        System.out.println("Update Success");
    }
    private static void addEntry() throws Exception
    {
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter Name,address");
     String name=sc.next();
     String add=sc.next();
     System.out.println("Enter Phone Numbers (Work,Home,Mobile) \n "
             + "If any num is not availabe give NA and coutinue");
     String w=sc.next();
     String h=sc.next();
     String m=sc.next();
     
     String query="INSERT INTO Directory VALUES (\""+name+"\",\""+add+"\",\""+w+"\",\""
             +h+"\",\""+m+"\");";
     if(stmt.executeUpdate(query)!=0)
         System.out.println("Successfull");
     else
         System.out.println("Failed Try Again Sometime later");
             
    }
    
    private static void UserInterface() throws Exception {
        boolean flag = true;
        int choice; 
        Scanner sc = new Scanner(System.in);
        while (flag == true) 
        {
            System.out.println("Select the Option TO Proceed");
            System.out.println("1.Search Contact By Name\n2.Search Contact By Number\n"
                    + "3.Add New Entry\n4.Update Entry");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter Name to Search");
                    nameSearch(sc.next());
                    break;
                case 2:
                    System.out.println("Enter Number to Search");
                    numberSearch(sc.next());
                    break;
                case 3:
                    addEntry();
                    break;
                case 4:
                    updateEntry();
                    break;
                default:
                    System.out.println("Wrong Choice");
            }
            System.out.println("Do you want to countinue? (1.Yes/ 2.No)");
            if(sc.nextInt()!=1)
                flag=false;
        }
                
            }
        


    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        initialize();   // Open JDBC connection and open JSON file
        UserInterface();
        // createTable();  // Create a new Table
        //loadIntoDB(); // Load all data into Database from JSON
        //nameSearch("ven");
        //numberSearch("8122370690");

    }

}
