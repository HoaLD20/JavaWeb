<%-- 
    Document   : newjsp
    Created on : Aug 29, 2020, 9:47:58 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/staticFunction.tld" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta  http-equiv="Content-Type"  content="text/html;  charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>EL -Static function call</h1>
        <form method="post" name="myForm">
            <table border="1" cellspacing="0" cellpadding="0">
                <tr>
                    <td align="right">First Number: </td>
                    <td><input type="text" name="txtFirstNumber">
                    </td>
                </tr>
                <tr>
                    <td align="right">Second Number: </td>
                    <td><input type="text" name="txtSecondNumber"></td>
                </tr>   
                <tr>
                    <td colspan="2"><input type="submit" value="Add"></td>
                </tr>
            </table>   
            <hr>
            add:  ${fn:add(param.txtFirstNumber,  param.txtSecondNumber)} 
            <br>
            sub: ${fn:sub(param.txtFirstNumber, param.txtSecondNumber)}
    </body>
</html>
