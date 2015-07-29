<%-- 
    Document   : newjsp
    Created on : 27 Jul, 2015, 11:58:14 AM
    Author     : cb-venugopal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
            </head>
    
    <body>
        <form action="newuser" id="entry" method="post" novalidate="novalidate"> 
          User Name <input type="text" name="User_name"/><br>
            
            Email<input type="text" id="email" name="email"/> <br>
            Confirm Email <input type="text" name="confemail"/><br>
            
            Password : <input type="password" id="password" name="Password"/><br>
        Confirm Password : <input type="password" name="confpassword"/> <br>
        <input type="submit" value="submit"/>
        
        </form>
      
</body> 
    </body>
</html>
