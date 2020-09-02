<%--Document   : indexCreated on : Mar 16, 2017, 2:12:59 PMAuthor     : lhhuong--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html><html><head><meta  http-equiv="Content-Type"  content="text/html;  charset=UTF-8">
        <title>JSP Page</title>
        <style>
            form {border: 3px solid #f1f1f1;}
            input[type=text]
            {width: 100%;padding: 12px 20px;margin: 8px 0;display: inline-block;border: 1px solid #ccc;box-sizing: border-box;}
            .btn{background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;width: 100%;}
            .btn:hover {opacity: 0.8;}.cancelbtn {width: auto;padding: 10px 18px;background-color: #f44336;}
            .sendbtn {width: auto;padding: 10px 18px;background-color: green;}
            .container {padding: 16px;}span.psw {float: right;padding-top: 16px;}
            /*  Change  styles  for  span  and  cancel  button  on  extra  small screens */
            @media screen and (max-width: 300px) {span.psw {display: block;float: none;}
                                                  .cancelbtn {width: 100%;}}
            </style>
        </head>
        <body>
            <h1>JSTL and SQL</h1>
            <!--Bat dau cho xu ly -->
            <!--Kiem tra nguoi dung co nhan nut them khong?-->
            <c:if test="${! empty param.btnAdd}">
                <!--Neu nguoi dung co nhap ho ten va dia chi -->
                <c:if   test="${!   empty   param.txtFullName   &&   !   empty param.txtAddress}">
                    <!--Ket noi csdl-->
                    <sql:setDataSource var="conn" scope="session"
                                       url="jdbc:mysql://localhost:3306/jsp" 
                                       user="root" 
                                       password=""
                                       driver="com.mysql.jdbc.Driver"/>
                    <!--Tao cau lenh insert-->
                    <sql:update dataSource="${conn}"
                                var="result"
                                scope="session"
                                sql="Insert into Users(HoTen, DiaChi) values(?,?)">
                        <sql:param value="${param.txtFullName}" />
                        <sql:param value="${param.txtAddress}" />
                    </sql:update>
                    <!--Neu du lieu them thanh cong thi hien thi thong bao -->
                    <c:if test="${result > 0}">Data is added into database
                    </c:if>
                    <!--Hien thi thong bao loi neu khong the them vao csdl -->
                    <c:if test="${result <= 0}">Cannot add the data into database</c:if>

                </c:if>
                <!--Hien thi thong bao loi khi nguoi dung khong nhap du lieu -->
                <c:if     test="${empty     param.txtFullName     ||     empty param.txtAddress}">Data cannot be null!</c:if>

            </c:if>
            <!--Ket thuc xu ly-->
            <form method="post">
                <div class="container">
                <label><b>Full Name</b>
                </label>
                <input  type="text"  placeholder="Enter  your  fullname" name="txtFullName" required="">
                <label><b>Address</b>
                </label>
                <input   type="text"   placeholder="Enter   your  address" name="txtAddress" required="">
            </div>
            <div class="container" style="background-color:#f1f1f1">
                <input  type="submit"  class="btn  sendbtn"  name="btnAdd" value="Add New" />
                <input type="reset" class="btn cancelbtn" />
            </div>
        </form>
    </body>
</html>