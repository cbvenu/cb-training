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
            ResultSet rs =(ResultSet) request.getAttribute("result");    
            %>
            <h1> Welcome Mr <%= rs.getString("first_name")%> </h1>
            
    </body>
</html>
