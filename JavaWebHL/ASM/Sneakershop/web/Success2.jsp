<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp" %>

<section id="form"><!--form-->
    <div class="container">
        <div class="row">

            <div class="alert alert-success">
                <strong>${message}</strong> 
                <p style="cursor: pointer"><a href="index.jsp">Home</a></p>
            </div>

        </div>
    </div>

    <c:if test="${!empty requestScope.ShowComfirm}">
        <center><div id="goToCharge" >
                <font size="5px">  <a href="ConfirmForget.jsp"><i class="fa fa-arrow-circle-right fa-3x"></i>Go To Confirm</a></font>
            </div></center>
        </c:if>
</section>


<%@include file="footer.jsp" %>
