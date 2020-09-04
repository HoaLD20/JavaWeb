<%-- 
    Document   : update
    Created on : Sep 4, 2020, 8:25:33 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost/jsp"
                           user="root"  password=""/>

        <sql:query dataSource="${dbsource}" var="result">
            SELECT * from khachhang where id=?;
            <sql:param value="${param.id}" />
        </sql:query>
        <form action="updatedb.jsp" method="post">
            <table border="0" width="40%">
                <caption>Update Khach Hang</caption>
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
                        <td><input type="text" name="txtid" value="${row.id}"/></td>                                     
                        <td><input type="text" name="txtname" value="${row.name}"/></td>     
                        <td><input type="text" name="txtgender" value="${row.gender}"/></td>            
                        <td><input type="text" name="txtbirthday" value="${row.birthday}"/> </td>               
                        <td><input type="text" name="txtaddress" value="${row.address}"/> </td>               
                        <td><input type="submit" value="Save" /></td>
                        <td><input type="reset" value="reset"/></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="display.jsp">Back</a>
        </form>
    </body>
</html>
