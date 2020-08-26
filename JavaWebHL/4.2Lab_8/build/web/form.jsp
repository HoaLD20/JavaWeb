<%-- 
    Document   : form
    Created on : Aug 26, 2020, 12:39:54 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <% String fNumber = request.getParameter("fNumber");
            String sNumber = request.getParameter("sNumber");
            String oper = request.getParameter("oper");
            String result = "";
            if (oper != null) {
                if (oper.equalsIgnoreCase("+")) {
                    result = (Integer.parseInt(fNumber) + Integer.parseInt(sNumber)) + "";
                } else if (oper.equalsIgnoreCase("-")) {
                    result = (Integer.parseInt(fNumber) - Integer.parseInt(sNumber)) + "";
                } else if (oper.equalsIgnoreCase("*")) {
                    result = (Integer.parseInt(fNumber) * Integer.parseInt(sNumber)) + "";
                } else if (oper.equalsIgnoreCase("/")) {
                    result = (Integer.parseInt(fNumber) / Integer.parseInt(sNumber)) + "";
                } else {
                    result = "NaN";
                }
            }%> 
        <h1>This is demo simple JSP</h1> 
        <form action="form.jsp" method="post">
            <br> <table width="400px" border="1px" cellpadding="0"> 
                <tr> 
                    <td> First number: </td> 
                    <td> <input type="text" name="fNumber" value="<%=fNumber%>"/>
                    </td> 
                </tr> 
                <tr>
                    <td> Second number: </td> 
                    <td> <input type="text" name="sNumber" value="<%=sNumber%>"/><br> 
                    </td> </tr> <tr> <td> Operator: </td> 
                    <td> <input type="text" name="oper" value="<%=oper%>"/><br>
                    </td> </tr> 
                <tr> <td> Result </td> 
                    <td> <input type="text" name="Result" value="<%=result%>"> </td> 
                </tr> 
                <tr> 
                    <td></td> 
                    <td> <input type="Submit" value=Submit> </td> 
                </tr> 
            </table> 
        </form> 
    </body>
</html>
