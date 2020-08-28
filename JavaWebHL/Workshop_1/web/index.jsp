<%-- 
    Document   : index
    Created on : Aug 28, 2020, 8:25:21 PM
    Author     : root
--%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    </head>
    <style>
        /*        div.item {
                    vertical-align: top;
                    display: inline-block;
                    text-align: center;
                    width: 120px;
                }
                .caption {
                    display: block;
                }*/
    </style>
    <body>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>


        <%
            int i = 0;
            ResultSet rs = (ResultSet) getServletContext().getAttribute("getAllproduct");
            while (rs.next()) {
        %>

        <%
            if (i == 4) {

        %>
        <br>
        <%                    i = 0;
            }
            i++;
        %>

        <div class="container">
            <div class="row">
                <div class="col">
                    <!--                <%= rs.getString("pro_id")%> 
                    <%= rs.getString("pro_name")%>
                    <%= rs.getFloat("pro_price")%>
                    <%= rs.getInt("pro_quan")%>  -->
                    <img src="<%=rs.getString("pro_img") + ".jpg"%>" width="80" height="80"/>
    <!--                <span class="caption"><%= rs.getString("pro_des")%><br><a href="HomeServlet?page=addtoCart">Add to Cart</a><br><a href="HomeServlet?page=buy">Buy</a>
                    </span>-->
                </div>
            </div>
        </div>
        <%}%>
    </body>
</html>
