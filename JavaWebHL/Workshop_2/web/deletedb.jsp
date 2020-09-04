<%-- 
    Document   : deletedb
    Created on : Sep 4, 2020, 9:21:50 AM
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
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost/jsp"
                           user="root"  password=""/>
        <sql:update dataSource="${dbsource}" var="count">
            DELETE FROM khachhang
            WHERE id=?
            <sql:param value="${param.id}"/>
        </sql:update>
        <c:if test="${count>=1}">
            <c:redirect url="display.jsp"/>
        </c:if>
    </body>
</html>
