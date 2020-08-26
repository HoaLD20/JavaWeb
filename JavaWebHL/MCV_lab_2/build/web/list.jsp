<%-- 
    Document   : list
    Created on : Aug 26, 2020, 1:13:25 AM
    Author     : root
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Customer</title>
    </head>
    <body style="text-align: center">
        <h2>List Customer</h2>
        <table border="1px solid black" align="center" style="width: 750px">
            <tr>
                <td>Full name</td>
                <td>User name</td>
                <td>Password</td>
                <td>Email</td>
            </tr>

            <%
                ResultSet rs = (ResultSet)getServletContext().getAttribute("customerList");
                while (rs.next()) {

            %>

            <tr>
                <td><%=rs.getString("fullname")%></td>
                <td><%=rs.getString("username")%></td>
                <td><%=rs.getString("password")%></td>
                <td><%=rs.getString("email")%></td>
                <td><a href="CustomerController?page=delete&id=<%=rs.getString("username")%>">delete</a></td>
            </tr>
            <%                }

            %>
        </table>
    </body>
</html>
