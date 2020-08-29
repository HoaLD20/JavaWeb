<%-- 
    Document   : index
    Created on : Aug 29, 2020, 9:25:23 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta  http-equiv="Content-Type"  content="text/html;  charset=UTF-8">
        <title>Expression Language in JSP</title>
    </head>
    <body>
        <h1>Expression Language in JSP</h1>
        <form method="post" name="frmEL">
            <table border="1" cellspacing="0" cellpadding="0">
                <tr>
                    <td>Product name</td>
                    <td><input type="text" name="txtName"></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="txtPrice"></td>
                </tr>
                <tr>
                    <td>Quality</td>
                    <td><input type="text" name="txtQuality"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit"></td>
                </tr>
            </table>            
        </form>
        <hr>
        <table border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td align="right">Product Name: </td>
                <td>${param.txtName}</td>
            </tr>
            <tr>
                <td align="right">Price: </td>
                <td>${param.txtPrice}</td>
            </tr>
            <tr>
                <td align="right">Quality: </td>
                <td>${param.txtQuality}</td>
            </tr>
            <tr>
                <td align="right">Total: </td>
                <td>${param.txtPrice * param.txtQuality}</td>
            </tr>
        </table>
    </body>
</html>
