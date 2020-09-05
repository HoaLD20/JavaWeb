<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>

<%-- include header file --%> 
<%@include file="header.jsp" %>
<section id="form"><!--form-->
    <div class="container">
        <div class="row">
            <div class="alert alert-warning" role="alert" id="error" style="display: none;"></div>
            <div class="col-sm-4 col-sm-offset-1">
                <div class="login-form"><!--login form-->
                    <h2>Enter New Password</h2>
                    <form action="UpdateNewPass" id="SigninForm" method="post">
                        <input type="password" placeholder="Password" id="SignupPassword" name= "NewPassword" required/>
                        <input type="password" placeholder="ConfirmPassword" id="SignupConfirmPassword" required/>
                        <button type="submit" class="btn btn-default">Enter</button>
                    </form>

                </div><!--/login form-->
            </div>
           
        </div>
    </div>
</section><!--/form-->

<%-- include footer file --%> 
<%@include file="footer.jsp" %>
