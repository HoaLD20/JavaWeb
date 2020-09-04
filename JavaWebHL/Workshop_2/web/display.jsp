<%-- 
    Document   : display
    Created on : Sep 4, 2020, 7:45:08 AM
    Author     : root
--%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
    <head>
        <title>Khach Hang List</title>
       
    </head>
    <body>

        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost/jsp"
                           user="root"  password=""/>

        <sql:query dataSource="${dbsource}" var="result">
            SELECT * from khachhang;
        </sql:query>
    <center>
        <form>
            <table border="1" width="40%">
                <caption>Khach Hang Management</caption>
                <tr>
                    <th>Khach Hang ID</th>
                    <th>Khach Hang Name</th>
                    <th>Khach Hang Gender</th>
                    <th>Khach Hang Birthday</th>
                    <th>Khach Hang Address</th>
                    <th colspan="2">Action</th>
                </tr>
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                        <td><c:out value="${row.id}"/></td>
                        <td><c:out value="${row.name}"/></td>
                        <td><c:out value="${row.gender}"/></td>
                        <td><c:out value="${row.birthday}"/></td>
                        <td><c:out value="${row.address}"/></td>
                        <td><a href="update.jsp?id=<c:out value="${row.id}"/>">Update</a></td>
                        <td><a href="deletedb.jsp?id=<c:out value="${row.id}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
         <a href="insert.jsp">Insert Khach Hang</a><p></p>
    </center>
</body>
</html>
