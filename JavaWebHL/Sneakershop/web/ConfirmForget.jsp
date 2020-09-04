<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<%@include file="slidebar.jsp" %>


<Form action="ConFirmCodeServlet" id="ConfirmCardForm" method="POST"><!--form-->
    <div class="container">
        <div class="row">
            <div class="col-xs-9">
                <center><h2 class="title text-center">Enter Code</h2>
               <Input type="text" class="input-field" name="ForgetName" placeholder="Enter Code" required="true">
                <BR>
                <BR>
                <button type="submit" class="btn btn-default">Submit</button> 
                </center>
            </div>
            
        </div>
    </div>
</Form>

<%@include file="footer.jsp" %>

