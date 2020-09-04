<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="online shopping website using javaEE">
        <meta name="author" content="">
        <title>Sneaker Shop</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet" />
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%@taglib prefix="myCate" uri="/WEB-INF/tlds/myTags_library.tld" %>
    </head><!--/head-->

    <body>
        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="contactinfo">
                                <ul class="nav nav-pills">
                                    <li><a href="#"><i class="fa fa-phone"></i> +84 35 373 8125</a></li>
                                    <li><a href="#"><i class="fa fa-envelope"></i>hoaldce140469@fpt.edu.vn</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="https://www.facebook.com/010010000110111101100001b/"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="https://twitter.com/GroupKvt"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#/"><i class="fa fa-instagram"></i></a></li>
                                    
                                    <li><a href="https://mail.google.com"><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header_top-->

            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="logo pull-left">
                                <a href="index.jsp"><img src="images/home/logo.png" alt="" /></a>
                            </div>

                        </div>
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    
                                    <c:if test="${!empty sessionScope.LoginUser && sessionScope.LoginUser.uRole =='user' }">
                                        <li><a href="Profile"><i class="fa fa-user"></i> ${sessionScope.LoginUser.uName}</a></li>
                                        <li><a href="CartHandlerServlet"><i class="fa fa-shopping-cart"></i> Cart (<span id="number"></span> )</a></li>
                                        <li><a href="#"><i class="fa fa-usd"></i> ${sessionScope.LoginUser.uCash}</a></li>
                                         <li><a href="ScratchCards.jsp"><i class="fa fa-cc-visa"></i> Charge </a></li>
                                        <li><a href="logout"><i class="fa fa-sign-out"></i> Logout</a></li>
                                        <script type="text/javascript">var userID = '${sessionScope.LoginUser.uId}';</script>
                                    </c:if>
                                        
                                        <c:if test="${!empty sessionScope.LoginUser && sessionScope.LoginUser.uRole =='admin' }">
                                        <li><a href="admin/Index.jsp"><i class="fa fa-cog"></i> Admin Panel</a></li>
                                        <li><a href="admin/logout1"><i class="fa fa-sign-out"></i> Logout</a></li>
                                    </c:if>

                                        <c:if test="${empty sessionScope.LoginUser}">
                                        <li><a href="login.jsp"><i class="fa fa-sign-in"></i> Signup</a></li>
                                        <li><a href="login.jsp"><i class="fa fa-lock"></i> Login</a></li>
                                    </c:if> 
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->

            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="mainmenu pull-left">
                                <ul class="nav navbar-nav collapse navbar-collapse">
                                    <li><a href="index.jsp" class="headerBar" id="homeBtn">Home</a></li>
                                    <li><a href="ShopController?page=1" class="headerBar" id="shopBtn" >Shop</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-sm-3">
                            <div class="search_box pull-right">
                                <form action="SearchForProduct">
                                <input type="text" placeholder="Search" name="search"/>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div><!--/header-bottom-->
        </header><!--/header-->
