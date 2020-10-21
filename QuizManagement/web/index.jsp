<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String includePage = (String) request.getAttribute("page");
    String user = (String) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="resource/bootstrap-4.0.0/dist/css/bootstrap.min.css">
        <title>Quiz Management</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <div class="container">
                <nav class="collapse navbar-collapse" id="bs-navbar"> 
                    <ul></ul>
                    <ul>
                        <a class="navbar-brand" href="Index">Home</a>
                    </ul>
                    
                    <ul>                    
                        <a class="navbar-brand" href="TakeQuiz">Take Quiz</a>
                    </ul>   
                    
                    <ul>
                        <a class="navbar-brand" href="MakeQuiz">Make Quiz</a>
                    </ul>
                    
                    <ul>
                        <a class="navbar-brand" href="ManageQuiz">Manage Quiz</a>
                    </ul>
                    
                    <ul>
                        <% if (user != null) { %>
                        <a class="navbar-brand" href="Logout">Logout</a>
                        <% }%>
                    </ul>
                </nav>
            </div>
        </nav>


<!--        <div id="main-content">
            <%--<jsp:include page="<%= includePage%>" />--%>
        </div>-->
    </body>
</html>
