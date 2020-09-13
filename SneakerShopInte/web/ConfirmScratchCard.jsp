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


<Form action="ConfirmScratchCardServlet" id="ConfirmCardForm" method="POST"><!--form-->
    <div class="container">
        <div class="row">
            <div class="col-xs-9">
                <center><h2 class="title text-center"> Please enter your code </h2>
            <p>your cash VND${LoginUser.uCash}</p>
               <Input type="text" class="input-field" name="CardStr" placeholder="write card code" required="true">
                
                <BR>
                <BR>
                <button type="submit" class="btn btn-default">Submit</button> 
                </center>
            </div>
            
        </div>
    </div>
</Form>

<%@include file="footer.jsp" %>

