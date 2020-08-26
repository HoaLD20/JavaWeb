<%-- 
    Document   : index
    Created on : Aug 26, 2020, 12:14:22 AM
    Author     : root
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta  http-equiv="Content-Type"  content="text/html;  charset=UTF-8">
        <style>h1{color: yellowgreen;font-style: italic;}   
            div{margin-left: auto;margin-right: auto;width: 300px;}
            input[type=text]
            {width:150px;
             text-align:left;
             border:thin solid gray;
             padding: 2px 5px 2px 5px;
             border-radius: 3px 3px 3px 3px;}
            input[type=submit]
            {width:75px;
             text-align:center;
             border:thin solid gray;
             padding: 3px 5px 3px 5px;
             border-radius: 3px 3px 3px 3px;
             background-color: orange;}
            input[type=submit]
            :hover{width:75px;
                   text-align:center;
                   border:thin solid gray;
                   padding: 3px 5px 3px 5px;
                   border-radius: 3px 3px 3px 3px;
                   background-color: yellowgreen;}
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Shopping card demo</h1>
            <%if (request.getParameter("btnOK") != null) {
                    codes.item item = new codes.item();
                    item.setId(Integer.parseInt(request.getParameter("txtID")));
                    item.setPrice(Integer.parseInt(request.getParameter("txtPrice")));
                    item.setQuantity(Integer.parseInt(request.getParameter("txtQuantity")));
                    java.util.ArrayList orders = new ArrayList();
                    if (session.getAttribute("Orders") != null) {
                        orders = ((java.util.ArrayList) session.getAttribute("Orders"));
                    }
                    orders.add(item);
                    session.setAttribute("Orders", orders);
                    response.sendRedirect("cart.jsp");
                }%>
            <form method="post">
                <table>
                    <tr>
                        <td>ID</td>
                        <td><input type="text" name="txtID" /></td>
                    </tr>
                    <tr>                    
                        <td>Price</td>
                        <td><input type="text" name="txtPrice"/></td>
                    </tr>
                    <tr>                
                        <td>Quantity</td>
                        <td><input type="text" name="txtQuantity"/></td>
                    </tr>
                    <tr>          
                        <td><input type="submit"value="OK" name="btnOK"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>