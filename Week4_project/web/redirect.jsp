<%-- 
    Document   : redirect
    Created on : 28 Jul, 2015, 12:30:13 PM
    Author     : cb-venugopal
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! ha ha ah </h1>
        <%@page import ="java.util.*,java.io.*" %>
        <% 
         ResultSet rs=(ResultSet) request.getAttribute("result");
        while(rs.next())
        {
            out.print(rs.getString("name"));
            out.print(rs.getString("address"));
        }
        
        %>
         
         
    </body>
</html>
