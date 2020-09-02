<%-- 
    Document   : list
    Created on : Sep 1, 2020, 7:43:23 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="myStyle.css" />
        <title>Database demo</title>
    </head>
    <body>
        <h1>Demo sql tag library</h1>
        <a href="insert.jsp">Add new</a>
        <sql:setDataSource 
            driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/jsp"
            user="root"
            password="" 
            var="conn"/>

        <sql:update
            var="delete" 
            dataSource="${conn}" 
            sql="Delete from employees where EmployeeID = '${param.del}'"/>
        
        <sql:query 
            var="employees"
            dataSource="${conn}">SELECT * from employees LIMIT 3 
        </sql:query>
            
        <table width="100%" border="1px" align="center">
            <tr bgcolor="#CFCF99">
                <c:forEach var="columnName" items="${employees.columnNames}">
                    <td width="27%">
                        <c:out value="${columnName}"/></td>
                    </c:forEach>
                <td>Del</td>
            </tr>
            <c:forEach var="row" items="${employees.rows}"><tr>
                    <c:forEach var="column" items="${row}"><td>
                            <c:out value="${column.value}"/></td>
                        </c:forEach>
                    <td>
                        <a href="list.jsp?del=${row.EmployeeID}">Del</a>
                        <a href="edit.jsp?id=${row.EmployeeID}&f=${row.FirstName}&l=${row.LastName}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="footer" align="right">
            <br>
            <hr>
            <h5>Web Component Development</h5>
        </div>
    </body>
</html>
