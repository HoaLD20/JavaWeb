<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 06:03
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include  file="Header.jsp" %>

<%@include  file="Slidebar.jsp" %>

<%@taglib  prefix="lib" uri="/WEB-INF/tlds/myTags_library.tld" %>

<c:if test="${empty requestScope.type}">
    <c:set var="type" value="Add"/>
</c:if>

<c:choose>
    <c:when test="${empty product.pImage}">
        <c:set var="pImage" value="../upload/empty.png"/>
        <c:set var="pImageSrc" value="upload/empty.png"/>
    </c:when>
    <c:otherwise>
        <c:set var="pImage" value="../${product.pImage}"/>
        <c:set var="pImageSrc" value="${product.pImage}"/>
    </c:otherwise>
</c:choose>
<div class="col-sm-9 padding-right">
    <div class="product-details">
        <div class="col-sm-4">
            <div class="view-product">
                <img src="${pImage}" id="imageView" alt=""/>
            </div>
        </div>
    </div>
    <div class="col-sm-8">
        <div class="product-information">
            <form action="AdminProduct" method="post" enctype="multipart/form-data">
                <h2>${type} Product</h2>
                <label>Product Name</label>
                <input type="text" placeholder="Product Name" name="ProductName" value="${product.pName}" class="input-field" id="ProductName" required=""/>
                <label>Product Price</label>
                <input type="number" placeholder="Product Price" name="ProductPrice" value="${product.pPrice}" step="0.01" class="input-field" id="ProductPrice" required=""/>
                <label>Product Quantity</label>
                <input type="number" placeholder="Product Quantity" name="ProductQuantity" value="${product.pQuantity}" class="input-field" id="ProductQuantity" required=""/>
                <label>Product Weight</label>
                <input type="number" placeholder="Product Weight" name="ProductWeight" value="${product.pWeight}" class="input-field" id="ProductWeight" required=""/>
                <label>Product Description</label>
                <textarea  placeholder="Product Description" name="ProductDescription" class="input-field">${product.pDescription}</textarea>
                <label>Category</label>
                <lib:SelectCategory selectID="${product.cId}"/>
                <label>Photo</label>
                <input type="file"  name="image" id="image" accept="image/*"/><br/>
                <input type="hidden" name="id" value="${product.pId}"/>
                <input type="hidden" name="pImage" value="${pImageSrc}"/>
                <button type="submit" class="btn btn-default">${type} Product</button>
            </form> 
            </form>
        </div>
    </div>
</div>
<%@include  file="Footer.jsp" %>