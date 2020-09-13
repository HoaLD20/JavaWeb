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

<%@include  file="Slidebar.jsp" %>
<div class="col-sm-9 padding-right">

    <h2>
        Slidebar
    </h2>
    <div class="table-responsive cart_info">
        <table class="table table-condensed">
            <thead>

                <tr class="cart_menu">
                    <td class="image">Item</td>
                    <td class="price">Tittle</td>
                    <td class="quantity">productId</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <c:if test="${!empty requestScope.listOfSlider}">

                    <c:forEach items="${requestScope.listOfSlider}" var="slider">
                        <tr>
                            <td class="cart_product">
                                <a href=""><img src="../${slider.sImage}" alt=""></a>
                            </td>
                            <td class="cart_description">
                                <p>${slider.sTitle}</p>
                            </td>
                            <td class="cart_price">
                                <p>${slider.pId}</p>
                            </td>
                            <td class="cart_delete">
                                <a class="cart_quantity_delete" href="DeleteSlider?id=${slider.sId}"><i class="fa fa-times"></i></a>
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
