<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 02:05
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="Header.jsp" %>

<%@include file="Slidebar.jsp" %>

<div class="col-sm-9 padding-right">

    <h2>Category
        <a class="btn btn-default" style="float: right;" href="addcategory.jsp">New Category</a>
    </h2>

    <div class="table-responsive cart_info">
        <table class="table table-condensed">
            <thead>
                <tr class="cart_menu">
                    <td class="id">Id</td>
                    <td class="name">Name</td>
                </tr>
            </thead>
            <tbody>
                <c:if test="${!empty requestScope.listOfCategory}">

                    <c:forEach items="${requestScope.listOfCategory}" var="category">
                        <tr>
                            <td class="cart_id">
                                <p>${category.cId}</p>
                            </td>

                            <td class="cart_id">
                                <p>${category.cName}</p>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
    </div>
</div>

<%@include file="Footer.jsp" %>

<%@include file="Notify.jsp" %>

