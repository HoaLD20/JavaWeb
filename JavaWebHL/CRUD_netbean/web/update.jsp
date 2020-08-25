<%-- 
    Document   : update
    Created on : Aug 24, 2020, 9:39:54 AM
    Author     : root
--%>

<%@page import="Model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update page</title>
    </head>
    <body>
        <%
            Student student = (Student)getServletContext().getAttribute("userinfo");
        %>
        <form action="StudentController" method="post">
            username:<input type="text" name="txtusername" value="<%=student.getUsername()%>" readonly="true"/><br>
            password:<input type="password" name="txtpassword" value="<%=student.getPassword()%>" /><br>
            full name:<input type="text" name="txtfullname" value="<%=student.getFullname()%>" /><br>
            gender:<input type="text" name="txtgender" value="<%=student.getGender()%>" /><br>
            birthday:<input type="text" name="txtbirthday" value="<%=student.getBirthday()%>" /><br>
            email: <input type="email" name="txtemail" value="<%=student.getEmail()%>" /><br>
            address: <input type="text" name="txtaddress" value="<%=student.getAddress()%>" /><br>
            <button name="updatesubmit">Update</button>
        </form>
    </body>
</html>
