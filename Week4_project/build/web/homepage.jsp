<%-- 
    Document   : homepage
    Created on : 28 Jul, 2015, 6:02:55 PM
    Author     : cb-venugopal
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello Login Successfull</h1>
        <% 
           HttpSession s1=request.getSession(false);
          if(s1==null)
          { %>
          <jsp:forward page="login-page.jsp"/> 
          <% }
          else
       {
       
            ResultSet rs =(ResultSet) request.getAttribute("result");
            if(rs.next())
            { %>
            <h1> Welcome </h1> <%   String name=rs.getString("first_name");
                                   out.println(name);
                                 %>
               <h1> Your Mail </h1>  <% out.println(rs.getString("email"));%>
               <% request.setAttribute("first", name);} }%>
            <form action="adding.jsp" method="post">
                <input type="submit" value="Add Details"/>
            </from>
            <form action="update" method="post">
                <input type="submit" value="Update Details"/>
            </from>
            
    </body>
</html>
