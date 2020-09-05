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

<%@taglib prefix="lib" uri="/WEB-INF/tlds/myTags_library.tld" %>

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
        <div class="product-details"><!--product-details-->
            <div class="col-sm-4">
                <div class="view-product">
                    <img src="${pImage}"  id="imageView" alt="" />
                </div>
            </div>
            <div class="col-sm-8">
                <div class="product-information"><!--/product-information-->
                    <form action="AddSlider" method="post" enctype="multipart/form-data">
                        <h2>${type} to Slidebar</h2>

                        <label>Tittle</label>
                        <input type="text" placeholder="Tittle" name="tittle" value="" class="input-field" id="ProductQuantity" required/>
                        <label>Sub tittle</label>
                        <input type="text" placeholder="Sub tittle " name="subTittle" value="" class="input-field" id="ProductModel" />
                        <label>Product Description</label>
                        <textarea  placeholder="Product Description" name="ProductDescription" class="input-field">${product.pDescription}</textarea>

                        <label>Photo</label>
                        <input type="file"  name="image" id="image" accept="image/*"/><br/>
                        <input type="hidden" name="id" value="${product.pId}"/>
                        <input type="hidden" name="pImage" value="${pImageSrc}"/>
                        <button type="submit" class="btn btn-default">${type} Slide</button>
                    </form>


                </div>
            </div>
        </div>
    </div>
<%@include file="Footer.jsp" %>