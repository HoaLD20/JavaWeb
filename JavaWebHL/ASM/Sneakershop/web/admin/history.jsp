<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="Header.jsp" %>

<%@include file="Slidebar.jsp" %>
<div class="col-sm-9 padding-right">
    <h2>History</h2>
    <div class="table-responsive cart_info">
        <table class="table table-condensed">
            <thead>

                <tr class="cart_menu">
                    <td class="quantity">HistoryId</td>
                    <td class="quantity">UserId</td>
                    <td class="quantity">ProductId</td>
                    <td class="description">Date</td>
                    <td class="quantity">Quantity</td>
                    <td></td>
                </tr>
                
            </thead>
            <tbody>

                <c:if test="${!empty requestScope.listOfHistorys}">

                    <c:forEach items="${requestScope.listOfHistorys}" var="history">
                        <tr>
                            <td class="cart_quantity">
                                <p>${history.hId}</p>
                            </td>
                            <td class="cart_quantity">
                                <p>${history.uId}</p>
                            </td>
                            <td class="cart_quantity">
                                <p>${history.pId}</p>
                            </td>
                            <td class="cart_description">
                                <p>${history.hDate}</p>
                            </td>
                            <td class="cart_quantity">
                                <p>${history.hQuantity}</p>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
    </div>
</div>
<%@include  file="Footer.jsp" %>

<%@include  file="Notify.jsp" %>
