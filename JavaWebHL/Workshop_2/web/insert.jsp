<%-- 
    Document   : insert
    Created on : Sep 4, 2020, 7:44:56 AM
    Author     : root
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
    </head>
    <body>
        <form action="insertdb.jsp" method="post">
            <table border="0" cellspacing="5" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Create new Khach Hang</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><label>ID khach hang</label></td>
                        <td><input type="text" name="txtid"/></td>
                    </tr>
                    <tr>
                        <td><label>Name Khach Hang</label></td>
                        <td><input type="text" name="txtname"/></td>
                    </tr>
                    <tr>
                        <td><label>Gender Khach Hang</label></td>
                        <td><input type="text" name="txtgender"/></td>
                    </tr>
                    <tr>
                        <td><label>Birthday Khach Hang</label></td>
                        <td><input type="date" name="txtbirthday"/></td>
                    </tr>
                    <tr>
                        <td><label>Address Khach Hang</label></td>
                        <td><input type="text" name="txtaddress"/></td>
                    </tr>
                   
                    <tr>
                        <td><input type="submit" value="Save" /></td>
                        <td><input type="reset" value="reset"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
       

    </body>
</html>