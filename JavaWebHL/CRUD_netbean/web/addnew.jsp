<%-- 
    Document   : addnew
    Created on : Aug 24, 2020, 12:28:41 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new</title>
    </head>
    <body>
        <form action="StudentController" method="post"> 
            username:<input type="text" name="txtusername"/><br>
            password:<input type="password" name="txtpassword"/><br>
            full name:<input type="text" name="txtfullname"/><br>
            gender:<input type="text" name="txtgender"/><br>
            birthday:<input type="text" name="txtbirthday"/><br>
            email: <input type="email" name="txtemail"/><br>
            address: <input type="text" name="txtaddress"/><br>
            <button name="btnsubmit">Submit</button>
        </form>
    </body>
</html>
