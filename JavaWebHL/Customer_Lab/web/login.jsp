<%-- 
    Document   : login
    Created on : Aug 26, 2020, 12:53:44 AM
    Author     : root
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
</head>
<body>
<div align="center">
    <h1>Employee Login Form</h1>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <table style="with: 100%">
            <tr>
                <td>UserName</td>
                <td><label>
                    <input type="text" name="username"/>
                </label></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>

        </table>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>
