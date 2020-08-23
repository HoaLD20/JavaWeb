<%-- 
    Document   : index
    Created on : Aug 21, 2020, 7:38:08 AM
    Author     : root
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
              
        <table border="1px solid black" align="center" style=width:750px style="text-align: center">
            <caption>Student management</caption>
            <tr>
            <td>username</td>
            <td>password</td>
            <td>full name</td>
            <td>gender</td>
            <td>birthday</td>
            <td>email</td>
            <td>address</td>
            </tr>
            <%
                ResultSet rs = (ResultSet)getServletContext().getAttribute("studentList");
                System.out.println("truoc while");
              while(rs.next()){
            %>
            <tr>
                <td> <%= rs.getString("username")%> </td>
                <td> <%= rs.getString("password")%> </td>
                <td> <%= rs.getString("fullname")%> </td>
                <td> <%= rs.getString("gender")%> </td>
                <td> <%= rs.getString("birthday")%> </td>
                <td> <%= rs.getString("email")%> </td>
                <td> <%= rs.getString("address")%> </td>
                <td><a href="StudentController?page=edit&id=<%=rs.getString("username")%>">edit</a> </td>
                <td><a href="StudentController?page=delete&id=<%=rs.getString("username")%>">delete</a> </td>
                <td><a href="StudentController?page=add&id=<%=rs.getString("username")%>">add</a> </td>
            </tr>
            <%
                }
            %>

        </table> 
    </body>
</html>
