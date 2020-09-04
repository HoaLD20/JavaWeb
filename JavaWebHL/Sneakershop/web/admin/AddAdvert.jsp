<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 06:03
  To change this template use File | Settings | File Templates.
--%>
<%-- include header file --%>
<%@include file="Header.jsp" %>

<%-- include slidebar file --%> 
<%@include file="Slidebar.jsp" %>

<c:choose>
    <c:when test="${empty ads.aImage}">
        <c:set var="aImage" value="/web/upload/poni.jpg"/>
        <c:set var="aImageScr" value="/web/upload/poni.jpg"/>
    </c:when>
    <c:otherwise>
        <c:set var="aImage" value="../${ads.aImage}"/>
        <c:set var="aImageSrc" value="${ads.aImage}"/>
    </c:otherwise>
</c:choose>

<div class="col-sm-9 padding-right">
    <div class="product-details"><!--product-details-->
        <div class="col-sm-4">
            <div class="view-product">
                <img src="${aImage}"  id="imageView" alt="" />
            </div>
        </div>
        <div class="col-sm-8">
            <div class="product-information"><!--/product-information-->
                <form action="AddAdvertisement" method="post" enctype="multipart/form-data">
                    <h2>Add Advertisement</h2>                   
                    <label>Photo</label>
                    <input type="file"  name="image" id="image" accept="image/*"/><br/>
                    <input type="hidden" name="id" value="${ads.aId}"/>
                    <input type="hidden" name="photo" value="${aImageSrc}"/>

                    <label>URL</label>
                    <input type="text" placeholder="URL" name="url"  class="input-field"  />
                    <button type="submit" class="btn btn-default">Add Advertisement</button>
                </form>
            </div><!--/product-information-->
        </div>
    </div><!--/product-details-->
</div>


<%@include file="Footer.jsp" %>