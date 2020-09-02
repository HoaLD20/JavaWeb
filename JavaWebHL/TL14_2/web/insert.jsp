<%-- 
    Document   : insert
    Created on : Sep 1, 2020, 7:47:32 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="myStyle.css" />
        <title>Edit Page</title>
    </head>
    <body>
        <a href="insert.jsp">Add new</a> |<a href="list.jsp">Listall</a>
        <form>
            <table align="center">
                <tr>
                    <td colspan="2" align="center"> <h1>JSP Page</h1> </td>
                </tr>
                <tr>
                    <td>ID</td>
                    <td> <input type="text" name="txtid" value="${param.id}"> </td>
                </tr>
                <tr>
                    <td>First name</td>
                    <td><input type="text" name="txtfirst" value="${param.f}"></td>
                </tr>
                <tr>
                    <td>Last name</td>
                    <td><input type="text" name="txtlast" value="${param.l}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Insert"></td></tr>
            </table>
            <c:if test="${!empty param.txtid}">
                <sql:setDataSource
                    driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost:3306/jsp"
                    user="root"
                    password="" 
                    var="conn"/>

                <sql:update var="insert" dataSource="${conn}">
                    INSERT INTO `employees`(`FirstName`, `Lastname`, `EmployeeID`) VALUES (?,?,?)
                    <sql:param value="${param.txtfirst}"/>
                    <sql:param value="${param.txtlast}"/>
                    <sql:param value="${param.txtid}"/>
                </sql:update>
            </c:if>
        </form>
                
        <div class="footer" align="right"><br>
            <hr>
            <h5>Web Component Development</h5>
        </div>
    </body>
</html>
