<%-- 
    Document   : login
    Created on : Aug 26, 2020, 12:53:44 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body style="text-align: center">
        <h2>Login Page</h2>
        <form action="HomeController" method="post">
            Username: <input type="text" name="txtusername"/>
            <br>
            Password: <input type="password" name="txtpassword"/>
            <br>
            <button>Login</button>
        </form>
    </body>
</html>
