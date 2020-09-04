<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Controller.User.IndexProductServlet" %> 

<%-- include header file --%> 
<%@include file="header.jsp" %>


<%-- include slider file --%> 
<%@include file="slider.jsp" %>


<%-- include slidebar file --%> 
<%@include file="slidebar.jsp" %>
<jsp:include page="/IndexProductServlet"/>
<div class="col-sm-9 padding-right">
    <div class="features_items"><!--features_items-->
        <h2 class="title text-center">New Items</h2>

        <c:if test="${!empty requestScope.limitedProducts}">

            <c:forEach items="${requestScope.limitedProducts}" var="product">

                <div class="col-sm-4">
                    <div class="product-image-wrapper">
                        <div class="single-products">
                            <div class="productinfo text-center">
                                <img src=${product.pImage} alt="" />
                                <h2>${product.pPrice} VND</h2>
                                <p>${product.pName}</p>
                                <a class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                            </div>
                            <div class="product-overlay">
                                <div class="overlay-content">
                                    <h2>${product.pPrice} VND</h2>
                                    <p>${product.pName}</p>
                                    <a  id="${product.pId}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                </div>
                            </div>
                            <img src="images/home/new.png" class="new" alt="" />
                        </div>
                        <div class="choose">
                            <ul class="nav nav-pills nav-justified">
                                <li><a href="ProductController?id=${product.pId}"><i class="fa fa-plus-square"></i>View Details</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>

    </div><!--features_items-->
</div>
</div>
</div>
</section>


<%-- include footer file --%> 
<%@include file="footer.jsp" %>
