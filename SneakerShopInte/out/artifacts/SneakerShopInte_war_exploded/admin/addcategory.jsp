<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 06:03
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="Header.jsp" %>

<%@include file="Slidebar.jsp" %>
<div class="col-sm-8">
    <div class="product-information"><!--/product-information-->
        <form action="AdminCategory" method="post" >
            <h2>Add Category</h2>
            <label>Category Name</label>
            <input type="text" placeholder="Category Name" name="CategoryName"  class="input-field" id="ProductName" required/>
            <button type="submit" class="btn btn-default">Add Category </button>
        </form>
    </div>
</div>
<%@include file="Footer.jsp" %>

