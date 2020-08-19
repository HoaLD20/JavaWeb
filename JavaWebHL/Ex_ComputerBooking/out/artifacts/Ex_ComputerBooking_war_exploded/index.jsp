<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 18/08/2020
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Computer Booking</title>
  </head>
  <body>
  <form action="ShowInfServlet" style="text-align: left">
    <h1 style="color: coral">Computer Booking</h1>
    Product: <input type="text" name="txtProduct"><br>
    Quantity: <input type="text" name="txtQuantity"><br>
    Price: <input type="text" name="txtPrice"><br>
    <input type="radio" name="Dis" value="Discount">Discount
    <input type="radio" name="Dis" value="NotDiscount">NotDiscount<br>

    Percent Discount: <input type="text" name="txtPerDis" value="0"><br>
    <button>Book</button>
  </form>
  </body>
</html>
