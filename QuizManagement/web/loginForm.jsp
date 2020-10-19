
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String message = (String) request.getAttribute("m");
    String userName = "";
    if (message != null) {
        userName = (String) request.getAttribute("savedUserName");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="resource/css/index.css"/>

        <title>Login Page</title>
    </head>
    <body>
        <form action="Login" method="post" class="form-horizontal">
            <div class="form-group">
                <h4 class="col-sm-2 control-label" id="loginFornTitle">Login Form</h4>
            </div>
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">Username</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="username" value="<%=userName%>" placeholder="Username">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-3">
                    <input type="password" class="form-control" name="password" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="col-sm-1">Sign in</button>
                    <a class="col-sm-1 control-label" href="Register">Register</a>
                </div>
            </div>
            <% if ((message != null) && (message.equals("fail"))) { %>
            <span class="failed">Username or password is incorrect, please try again</span>
            <% }%> 
        </form>                
    </body>
</html>
