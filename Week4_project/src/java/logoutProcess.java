import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Connection;


 
public class logoutProcess extends HttpServlet
{
    
    /*public void doGET(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
    doPOST(request,response);
    }*/
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
  {
     HttpSession s=request.getSession(false);
     if(s!=null)
     {
         s.invalidate();
     }
     else
     {
        
     }
      response.sendRedirect("login-page.jsp");
  }
}