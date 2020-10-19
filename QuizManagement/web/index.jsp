
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String includePage = (String) request.getAttribute("page");
    String user = (String) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <title>Quiz Management</title>
    </head>
    <body>
        <header class="bs-docs-nav navbar navbar-static-top" id="top"> 
            <div class="container"> 
                <div class="navbar-header">
                    <button aria-controls="bs-navbar" aria-expanded="false" class="collapsed navbar-toggle" data-target="#bs-navbar" data-toggle="collapse" type="button"> </button> 
                    <a href="Index" class="navbar-brand">Home</a> 
                </div> 
                <nav class="collapse navbar-collapse" id="bs-navbar"> 
                    <ul class="nav navbar-nav"> 
                        <li><a class="navbar-brand" href="TakeQuiz">Take Quiz</a></li>
                        <li><a class="navbar-brand" href="MakeQuiz">Make Quiz</a></li>
                        <li><a class="navbar-brand" href="ManageQuiz">Manage Quiz</a></li>
                        <% if (user != null) { %>
                        <li><a class="navbar-brand" href="Logout">Logout</a></li>
                        <% }%>
                    </ul> 
                </nav>
            </div>
        </header>
        <div id="main-content">
            <jsp:include page="<%= includePage%>" />
        </div>
    </body>
</html>
