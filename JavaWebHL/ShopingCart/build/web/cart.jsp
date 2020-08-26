<%-- 
    Document   : cart
    Created on : Aug 26, 2020, 12:17:56 AM
    Author     : root
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta  http-equiv="Content-Type"  content="text/html;  charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1{color: yellowgreen;font-style: italic;} 
            div{margin-left: auto;margin-right: auto;width: 300px;}
            table{border: 1px solid gray;padding: 3px 3px 3px 3px;}
            th{color: brown;}.back{width:75px;text-align:center;
                                   border:thin solid gray;
                                   padding: 2px 5px 2px 5px;
                                   border-radius: 3px 3px 3px 3px;
                                   background-color: orange;}.back:hover{width:75px;text-align:center;
                                                  border:thin solid gray;
                                                  padding: 3px 5px 3px 5px;
                                                  border-radius: 3px 3px 3px 3px;
                                                  background-color: yellowgreen;}
            </style></head><body>        
            <div><h1>Your card</h1>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Price</th>
                        <th>Quantity</th> 
                        <th>Total</th>
                        <th>Operator</th>
                    </tr>
                    <%java.util.ArrayList orders = new ArrayList();
                        codes.item item = new codes.item();
                        if (session.getAttribute("Orders") != null) {
                            orders = ((java.util.ArrayList) session.getAttribute("Orders"));
                        }
                        int count = orders.size() - 1;
                        while (count > 0) {
                            item = (codes.item) orders.get(count);
                            if (request.getParameter("id") != null) {
                                if (item.getId() == Integer.parseInt(request.getParameter("id"))) {
                                    orders.remove(item);
                                    count--;
                                    continue;
                                }
                            }
                            out.print("<tr>");
                            out.print("<td>" + item.getId() + "</td>");
                            out.print("<td>" + item.getPrice() + "</td>");
                            out.print("<td>" + item.getQuantity() + "</td>");
                            out.print("<td>" + item.getQuantity() * item.getPrice() + "</td>");
                            out.print("<td>  <a  href='?id=" + item.getId() + "'>Delete</a></td>");
                            count--;
                            out.print("</tr>");
                        }%>
                </table>     
                <br/><a class="back" href="index.jsp">continue</a> 
        </div>
    </body>
</html>
</html>
