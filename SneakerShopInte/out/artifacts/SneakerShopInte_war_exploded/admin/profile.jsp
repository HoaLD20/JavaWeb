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

<c:choose>
    <c:when test="${empty userInfo.uPhoto}">
        <c:set var="uPhoto" value="user.png"/>
        <c:set var="uPhotoSrc" value="/web/upload/user.png"/>
    </c:when>
    <c:otherwise>
        <c:set var="uPhoto" value="../${userInfo.uPhoto}"/>
        <c:set var="uPhotoSrc" value="${userInfo.uPhoto}"/>
    </c:otherwise>
</c:choose>
<div class="col-sm-9 padding-right">
    <div class="product-details"><!--product-details-->
        <div class="col-sm-4">
            <div class="view-product">
                <img src="${uPhoto}"  id="imageView" alt="" />
            </div>
        </div>

        <div class="col-sm-8">


            <div class="product-information"><!--/product-information-->
                <form action="AdminProfile" method="post" id="editProfileForm" enctype="multipart/form-data" onsubmit="return validateSignup();">	
                    <h2>${userInfo.uName}</h2>
                    <p>Account Setting</p>
                    <label>E-mail</label>
                    <input type="email" placeholder="E-mail"  class="input-field" name="email" id="editEmail" value="${userInfo.uEmail}" required/>
                    <label>Password</label>
                    <input type="Password" placeholder="Password"  class="input-field" name="password" id="SignupPassword" required/>
                    <label>Confirm Password</label>
                    <input type="Password" placeholder="Confirm Password"  class="input-field" id="SignupConfirmPassword" required/>

                    <label>Address</label>
                    <input type="text" placeholder="Address"  class="input-field" name="address" id="editAddress" value="${userInfo.uAddress}" required />
                    <label>Job</label>
                    <input type="text" placeholder="Job"  class="input-field" name="job" id="editJob" value="${userInfo.uJob}" required/>
                    <label>Credit Card</label>
                    <input type="text" placeholder="Credit Card"  class="input-field" name="creditcard" id="SignupCreditCard" value="${userInfo.uCreditCard}" required/>
                    <input type="hidden" name="id" value="${userInfo.uId}" />
                    <input type="hidden" name="photo" value="${uPhotoSrc}"/>
                    <input type="hidden" name="cash" value="${userInfo.uCash}"/>
                    <input type="hidden" name="role" value="${userInfo.uRole}"/>
                    <input type="hidden" name="name" value="${userInfo.uName}"/>
                    
                    <label>Image</label>
                    <input type="file" name="image" id="image" accept="image/*"><br/>
                    <button type="submit" class="btn btn-default" id="editSubmitBtn">Update</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="Footer.jsp" %>
