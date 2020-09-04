<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>

<%@page import="javax.tools.DocumentationTool.Location"%>
<%-- include header file --%> 
<%@include file="header.jsp" %>
<%@ page import="Controller.User.CartHandlerServlet" %> 




<section id="cart_items">
    <div class="container">

        <div class="review-payment">
            <h2>Review & Payment</h2>
        </div>

        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                    <tr class="cart_menu">
                        <td class="image">Item</td>
                        <td class="description"></td>
                        <td class="price">Price</td>
                        <td class="quantity">Quantity</td>
                        <td class="total">Total</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>



                    <c:set var="total" value="${0}"/>

                    <c:if test="${!empty requestScope.carts}">
                       

                        <c:forEach items="${requestScope.carts}" var="cart">
                            <tr>



                                <td class="cart_product">
                                    <a href=""><img src="${cart.pImage}" alt=""></a>
                                </td>
                                <td class="cart_description">
                                   
                                    <p>Product ID: ${cart.pId}</p>
                                </td>
                                <td class="cart_price">

                                    <p id="P_${cart.cartId}">${cart.pPrice} VND</p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <a class="cart_quantity_up" id="U_${cart.cartId}"> + </a>
                                        <input class="cart_quantity_input" 
                                               type="text" name="quantity" id="V_${cart.cartId}"
                                               value="${cart.cartQuantity}" autocomplete="off" 
                                               size="2" disabled>
<!--                                        <p>${cart.cartQuantity}</p>-->
                                        <a class="cart_quantity_down" id="D_${cart.cartId}" > - </a>
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price"  id="T_${cart.cartId}">
                                            ${cart.pPrice*cart.cartQuantity} VND
                                    </p>

                                </td>
                                <td class="cart_delete">
                                    <INPUT type="hidden" id="hiddenCart" value="${cart.cartId}"/>
                                  
                                    <a  href="DeleteCart?id=${cart.cartId}"><i class="fa fa-times"></i></a>
                         

                                </td>
                                <c:set var="total" value="${total+(cart.pPrice*cart.cartQuantity)}"/>
                            </tr>
                        </c:forEach>
                    </c:if>


                    <tr>
                        <td colspan="4">&nbsp;</td>
                        <td colspan="2">
                            <table class="table table-condensed total-result">
                                <tr>
                                    <td>Cart Sub Total</td>
                                    <td id="subTotal">${total} VND</td>
                                </tr>
                                <tr class="shipping-cost">
                                    <td>Shipping Cost</td>
                                    <td>Free</td>										
                                </tr>
                                <tr>
                                    <td>Total</td>
                                    <td><span id="total">${total} VND
                                        </span></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="payment-options">
            <a class="btn btn-primary" href="PayController">Pay</a>
        </div>
    </div>
</section> <!--/#cart_items-->

<%-- include footer file --%> 
<%@include file="footer.jsp" %>
