<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 19/08/2020
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<form action="UploadServlet" method="post" style="text-align: -moz-left" enctype = "multipart/form-data">
    <h3>File Upload</h3>
    <br>
    Select file to upload<br>
    <input type="file" name="file" size="50">
    <br>
    <br>
    <input type="submit" value="Upload file">
</form>
</body>
</html>
