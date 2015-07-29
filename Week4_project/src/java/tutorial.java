import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

 
public class tutorial extends HttpServlet
{
    
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // JDBC driver name and database URL
        String JDBC_DRIVER="com.mysql.jdbc.Driver";  
      String DB_URL="jdbc:mysql://localhost/JDBCPhone";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
      //  Database credentials
        String USER = "root";
      String PASS = "";
      try
      {
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");
         // Open a connection
         Connection conn = (Connection)DriverManager.getConnection(DB_URL,USER,PASS);

         // Execute SQL query
         Statement stmt = (Statement)conn.createStatement();
         String sql;
         sql = "SELECT * FROM Directory";
         ResultSet rs = stmt.executeQuery(sql);
        request.setAttribute("result", rs);
            RequestDispatcher rd = request.getRequestDispatcher("redirect.jsp");
           rd.forward(request, response);       
         }
      catch(Exception e)
      {   
      }
      }
}