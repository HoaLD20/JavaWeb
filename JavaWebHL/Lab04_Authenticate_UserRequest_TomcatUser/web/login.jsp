<%-- 
    Document   : login
    Created on : Aug 20, 2020, 4:12:38 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <% String url = "";
    if (request.getParameter("returnURL") != null) {
        url = "?returnURL=" + request.getParameter("returnURL");
    }%>
        <h1>Login</h1>
        <form action="action/Authentication<%=url%>" method="POST">
            User:

            <input type="text" name="txtUser" value="admin"/> <br>

            User:

            <input type="password" name="txtPass" value="admin"/><br>

            <input type="Submit" value="Login"/>
        </form>

    </body>
</html>
