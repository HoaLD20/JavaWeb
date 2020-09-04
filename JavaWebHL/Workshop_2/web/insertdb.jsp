<%-- 
    Document   : insertdb
    Created on : Sep 4, 2020, 8:04:38 AM
    Author     : root
--%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
    <head>
        <title>Insert Page</title>       
    </head>
    <body>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost/jsp"
                           user="root"  password=""/>

        <sql:update dataSource="${dbsource}" var="result">
            insert into khachhang(id, name, gender, birthday, address) VALUES (?,?,?,?,?);
            <sql:param value="${param.txtid}" />
            <sql:param value="${param.txtname}" />
            <sql:param value="${param.txtgender}" />
            <sql:param value="${param.txtbirthday}" />
            <sql:param value="${param.txtaddress}" />
        </sql:update>
        <c:if test="${result>=1}">
            <c:redirect url="display.jsp"/>
        </c:if> 
                       
    </body>
</html>