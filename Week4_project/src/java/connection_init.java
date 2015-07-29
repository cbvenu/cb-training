/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cb-venugopal
 */
import java.sql.*;
import java.util.*;
import java.io.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javax.servlet.*;
import javax.servlet.http.*;



public class connection_init extends HttpServlet
{    
  
   public void doGet(HttpServletRequest req, HttpServletResponse res) 
           throws ServletException, IOException   
   {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost/JDBCPhone","root","");
            Statement stmt;      
           stmt = (Statement) conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM Directory WHERE name LIKE \"%" + "venu" + "%\"");
           req.setAttribute("result", rs);
           RequestDispatcher rd = req.getRequestDispatcher("redirect.jsp");
           rd.forward(req, res);
       }
       catch (Exception e)
       {
        }
   }
    
}
