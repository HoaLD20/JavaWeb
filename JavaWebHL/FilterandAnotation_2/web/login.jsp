<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 20/08/2020
  Time: 08:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<% String url =""; if (request.getParameter("returnURL") != null) { url = "?returnURL="+request.getParameter("returnURL"); } %>
<h1>Login</h1>
<form action="action/Authentication<%=url%>" method="POST">
    User:

    <input type="text" name="txtUser" value="admin"/>

    User:

    <input type="password" name="txtPass" value="admin"/>

    <input type="Submit" value="Login"/>
</form>

</body>
</html>