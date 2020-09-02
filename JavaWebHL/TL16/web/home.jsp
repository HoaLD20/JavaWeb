<%-- 
    Document   : home
    Created on : Sep 1, 2020, 9:54:42 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/customTag.tld" prefix="my"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
      <my:Header companyName="Can Tho Universsity Software Center (CUSC)"/>
        <my:Loop start="0" end="2">
            <%=new java.util.Date()%>
        </my:Loop>
        <my:employee>
           SELECT * FROM `employees`
        </my:employee>
        <my:Footer companyName="Can Tho Universsity Software Center (CUSC)"/>
    </body>
</html>
