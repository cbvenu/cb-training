import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Connection;


 
public class newUser extends HttpServlet
{
    
    /*public void doGET(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
    doPOST(request,response);
    }*/
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  {
      // JDBC driver name and database URL
        String JDBC_DRIVER="com.mysql.jdbc.Driver";  
      String DB_URL="jdbc:mysql://localhost/login";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
      //  Database credentials
        String USER = "root";
      String PASS = "";
      try
      {
            try {
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(newUser.class.getName()).log(Level.SEVERE, null, ex);
            }
         // Open a connection
         Connection conn = (Connection)DriverManager.getConnection(DB_URL,USER,PASS);
        String email=request.getParameter("email");
        String fn=request.getParameter("User_name");
        String password=request.getParameter("Password");
         // Execute SQL query
         
         String sql;
         
         out.println(password);
         sql = "SELECT * from users where email like \""+email+"\";";
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery(sql);
        // out.println(sql);
         if(!rs.next())
         {
            String query="INSERT INTO users (first_name,email,password) values(?,?,?);";
         PreparedStatement stmt =conn.prepareStatement(query);
         stmt.setString(1, fn);
         stmt.setString(2, email);
         stmt.setString(3, password);
         stmt.execute();
            HttpSession session = request.getSession(true);
             session.setAttribute("email", email);
             
                session.setAttribute("email", email);
             
                 //out.print("Suceesfull ! Login again");
                getServletContext().getRequestDispatcher("/login-page.jsp").forward(request, response);
             }
      }
      
      catch(Exception e)
      { 
          System.out.println(e);
      }
       
      }
}
}