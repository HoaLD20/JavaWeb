<%-- 
    Document   : transaction
    Created on : Sep 1, 2020, 7:56:33 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ExceptionHandler.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="myStyle.css" />
        <title>Transaction</title>
    </head>
    <body>
        <h1>Transaction demo</h1>
        <sql:setDataSource 
            driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost:3306/jsp;"
                    user="root"
                    password="" 
            var="conn"/>
        <sql:transaction dataSource="${conn}">
            <sql:update var="update">Update  Employees  set  FirstName=?,  Lastname=?  where EmployeeID=?
                <sql:param value="Mr"/>
                <sql:param value="Beeeeeeen"/>
                <sql:param value="1"/></sql:update>
            <sql:update var="update1">Update  Employees  set  FirstName=?,  Lastname=?  where EmployeeID=?
                <sql:param value="Mr"/>
                <sql:param value="Jacky"/>
                <sql:param value="a"/>
            </sql:update>
        </sql:transaction>
    </body>
</html>
