<%-- 
    Document   : adding
    Created on : 29 Jul, 2015, 9:42:58 AM
    Author     : cb-venugopal
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            HttpSession se=request.getSession(false);
            String name=null,email=null;
            ResultSet rs=null;
            
            if(se==null)
            {
                
            }
            else
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
           email=(String)se.getAttribute("email");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost/login","root","");
            Statement stmt=c.createStatement();
            out.println(email);
            out.println("select * from users where email like \""+email+"\";");
            rs=stmt.executeQuery("select * from users where email like \""+email+"\";");
            if(rs.next())
                name=rs.getString("first_name");
                }
                catch(Exception e)
                {
                }
            
        %>
        <% }%>
        <form action="add_db" method="post">
            First Name <input type="text" name="first_name" value="<%= name %>" disabled />
           Last Name <input type="text" name="last_name" />
           Address <textarea name="address" rows="4" cols="10"></textarea>
           Email <input type="text" name="emails" value="<%= email %>" readonly="readonly" />
           <input type="submit" name="submit"/>
        </form>
       
          
    </body>
</html>
