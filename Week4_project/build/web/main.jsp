<%-- 
    Document   : main
    Created on : 27 Jul, 2015, 12:52:52 PM
    Author     : cb-venugopal
--%>

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
            int a=10;
            System.out.println("************************************Calculating...******************************");
            out.println(a);
            %>
            <br> 
            <%= java.lang.System.getProperty("java.version")%>
         <% out.println(a); %>
        <%= new java.util.Date()%>
        <%= request.getParameter("first")%>
        <%= request.getParameter("last")%>
                
        
    </body>
</html>
