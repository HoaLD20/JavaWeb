<%-- 
    Document   : success
    Created on : Sep 3, 2020, 8:27:34 AM
    Author     : root
--%>

<%@page import="com.myapp.struts.ShowList"%>
<%@page import="Dao.UserDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Success login ok ....</h1>
        
             <table border="1px solid black" align="center" style=width:750px style="text-align: center">
            <caption>Student management</caption>
            <tr>
            <td>username</td>
            <td>password</td>
            <td>full name</td>
            </tr>
            <%
                UserDao ud = new UserDao();
                ResultSet rs = (ResultSet) ud.getUser();
                getServletContext().setAttribute("studentList", rs);
                ShowList sl = new ShowList();
              while(rs.next()){
            %>
            <tr>
                <td> <%= rs.getString("FirstName")%> </td>
                <td> <%= rs.getString("lastname")%> </td>
                <td> <%= rs.getString("EmployeeID")%> </td>
      
      
            </tr>
            <%
                }
            %>

        </table> 
    </body>
</html>
