<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<html:form method="post" action="/loginpath">
    Username: <html:text property="txtusername"/><html:errors property="lblusernameError"/>
    <br>
    Password: <html:text property="txtpassword"/><html:errors property="lblpassError"/>
    <br>
    <html:submit value="Login"/>
    <html:reset value="Reset"/>
</html:form>