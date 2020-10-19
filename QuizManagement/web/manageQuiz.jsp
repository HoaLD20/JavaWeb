

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.Entity.Question"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Question> questions = (List<Question>) request.getAttribute("quizData");
    int numOfQuiz = Integer.parseInt(request.getAttribute("numOfQuiz").toString());
    int numOfPage = Integer.parseInt(request.getAttribute("numOfPage").toString());
    int currentPage = (request.getParameter("p") == null) ? 1 : Integer.parseInt(request.getParameter("p"));
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="resource/css/index.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Manage Quiz</title>
    </head>
    <body>
        <% if ((questions != null) && (!questions.isEmpty())) {%>
        <h3>Number of question: <span class="blue"><%=numOfQuiz%></span></h3>
        <table>
            <colgroup>
                <col class="labelCol">
                <col class="fieldCol">
                <col class="fieldAction">
            </colgroup>
            <thead>
                <tr>
                    <th>Question</th>
                    <th>Date Created</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% for (Question q : questions) {%>
                <tr>
                    <td><%=q.getContent()%></td>
                    <td><%=formatter.format(q.getCreated())%></td>
                    <td><a onclick="delQuestion('<%=currentPage %>', '<%=q.getId()%>')">Delete</a></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <ul id="pageList">
            <% for (int i = 0; i < numOfPage; i++) {%>
            <li class="<%= ((i+1) == currentPage ? "selected" : "") %>"><a href="ManageQuiz?p=<%=i + 1%>"><%=i + 1%></a></li>
                <%} %>
        </ul>
        <% } else { %>
        <h5>No question available</h5>
        <% }%>
    </body>
</html>
