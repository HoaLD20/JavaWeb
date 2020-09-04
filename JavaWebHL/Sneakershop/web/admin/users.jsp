<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="Controller.Admin.AdminUserServlet" %>

<%@include file="Header.jsp"%>

<%@include file="Slidebar.jsp" %>
<div class="col-sm-9 padding-right">

    <h2>Users</h2>
    <div class="table-responsive cart_info">
        <table class="table table-condensed">
            <thead>
                <tr class="cart_menu">
                    <td class="image">User</td>
                    <td class="description"></td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <c:if test="${!empty requestScope.listOfUser}">

                    <c:forEach items="${requestScope.listOfUser}" var="user">
                        <tr>
                            <td class="cart_product">
                                <img src="../${user.uPhoto}" alt="">
                            </td>
                            <td class="cart_description">
                                <h4>${user.uName}</h4>
                                <p>${user.uEmail}</p>
                            </td>
                            <td class="cart_delete">
                                <a class="cart_delete a" href="AdminProfile?id=${user.uId}"><i class="fa fa-pencil"></i></a>
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
