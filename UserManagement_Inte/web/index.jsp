<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 9/29/2020
  Time: 7:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login Page</title>
  </head>
  <body>
  <div align="center">
    <h1>Login</h1>
    <form action="<%=request.getContextPath()%>/login" method="post">
      <table style="with: 100%">
        <tr>
          <td>UserName</td>
          <td><input type="text" name="username" /></td>
        </tr>
        <tr>
          <td>Password</td>
          <td><input type="password" name="password" /></td>
        </tr>

      </table>
      <input type="submit" value="Submit" />
    </form>
  </div>
  </body>
</html>
