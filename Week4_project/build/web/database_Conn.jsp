<%-- 
    Document   : database_Conn
    Created on : 28 Jul, 2015, 10:56:41 AM
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
        <h1>Hello Hello World!  JSP 1</h1>
        <%@page import="java.util.*, java.io.*, java.sql.*" %>
        <%@page import ="javax.servlet.*" %> 
        
        <% /* <sql:setDataSource var="mydb"
                           driver="com.mysql.jdbc.Driver"
                           url="jdbc.,mysql://locathost/Venu1"
                           user="root"
                           password=""
                           />
        <sql:query dataSource="${mydb}" var="result" >
                   select * from  first;
        </sql:query>
        
                   <c:forEach var="row" items="${result.rows}" >
                   <c.out value="row.id"/>
                       <c.out value="row.name"/>
                   </c:forEach>  */               
        %>
        <%
     request.getRequestDispatcher("newUser.java").forward(request, response);
%>

    </body>
</html>
