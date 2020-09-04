<%-- 
    Document   : updatedb
    Created on : Sep 4, 2020, 8:35:47 AM
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
                    UPDATE `khachhang` SET `name`=?,`gender`=?,`birthday`=?,`address`=?
                    WHERE id=?
        
            <sql:param value="${param.txtname}" />
            <sql:param value="${param.txtgender}" />
            <sql:param value="${param.txtbirthday}" />
            <sql:param value="${param.txtaddress}" />
            <sql:param value="${param.txtid}" />
            
        </sql:update>

        <c:if test="${count>=1}">
            <c:redirect url="display.jsp"/>
        </c:if> 
    </body>
</html>
