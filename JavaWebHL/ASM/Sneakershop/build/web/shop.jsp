<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Controller.User.ShopController"%> 
<%-- include header file --%> 
<%@include file="header.jsp" %>


<%-- include slidebar file --%> 
<%@include file="slidebar.jsp" %>

<div class="col-sm-9 padding-right">
    <div class="features_items"><!--features_items-->
        <h2 class="title text-center">Features Items</h2>

      

        <c:if test="${!empty requestScope.allProducts}">

            <c:forEach items="${requestScope.allProducts}" var="product">

                <div class="col-sm-4">
                    <div class="product-image-wrapper">
                        <div class="single-products">
                            <div class="productinfo text-center">
                                <img src="${product.pImage}" alt="" />
                                <h2>${product.pPrice} VND</h2>
                                <p>${product.pName}</p>
                                <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                            </div>
                            <div class="product-overlay">
                                <div class="overlay-content">
                                    <h2>${product.pPrice} VND</h2>
                                    <p>${product.pName}</p>
                                    <a href="id=${product.pId}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                </div>
                            </div>
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






    <ul class="pagination">
        <%--handel Category--%>
        <c:if test="${not empty query}">
            <c:set var="stringQuery" value="&cate=${query}"/>
        </c:if>

        <%--to display Previous arrow except for the 1st page --%>
        <c:if test="${currentPage != 1}">
            <li><a href="ShopController?page=${currentPage - 1}${stringQuery}">&laquo;</a></li>
            </c:if>

        <%--to displaying Page numbers--%>
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage == i}">
                    <li class="active"><a href="">${i}</a></li>
                    </c:when>
                    <c:otherwise>
                    <li><a href="ShopController?page=${i}${stringQuery}">${i}</a></li>

                </c:otherwise>
            </c:choose>
        </c:forEach>

        <%--to display Next arrow --%>
        <c:if test="${currentPage lt noOfPages}">
            <li><a href="ShopController?page=${currentPage + 1}${stringQuery}">&raquo;</a></li>
            </c:if>
    </ul>
</div>

<%-- include footer file --%> 
<%@include file="footer.jsp" %>