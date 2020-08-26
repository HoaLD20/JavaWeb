<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 08/08/2020
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%! public String methodA() {
    return methodB();
}
%>
<%! public String methodB() {
    return "JAD Final Test";
}
%>
<h2><%= methodA()%></h2>
</body>
</html>