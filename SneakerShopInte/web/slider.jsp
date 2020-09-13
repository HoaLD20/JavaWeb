<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>
 <jsp:include page="/SliderIndex"/>

<section id="slider"><!--slider-->
    <div class="container">
        <div class="row">
            <c:if test="${not empty slides}">
                <div class="col-sm-12">
                <!-- include slides-->
               
                <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <c:forEach var="i" begin="0" end="${fn:length(slides)-1}" >
                            <c:if test="${i==0}">
                                <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                            </c:if>
                            <c:if test="${i!=0}">
                                <li data-target="#slider-carousel" data-slide-to="${i}"></li>
                            </c:if>
                        </c:forEach>
                    </ol>

                    <div class="carousel-inner">
                        <c:forEach var="slide" items="${slides}" varStatus="loop">
                            <c:if test="${loop.index == 0}">
                                <c:set var="classActive" value="active" />
                            </c:if>

                            <div class="item ${classActive}">
                                <div class="col-sm-6 slide-height">
                                    <h1>${slide.sTitle}</h1>
                                    <h2>${slide.sSubtitle}</h2>
                                    
                                    <a href="ProductController?id=${slide.pId}" class="btn btn-default get">Get it now</a>
                                </div>
                                <div class="col-sm-6">
                                    <img src="${slide.sImage}" class="girl img-responsive " alt="" />

                                </div>  



                            </div>

                            <c:set var="classActive" value="" />
                        </c:forEach>

                    </div>

                    <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                        <i class="fa fa-angle-left"></i>
                    </a>
                    <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                        <i class="fa fa-angle-right"></i>
                    </a>
                </div>

            </div>
            </c:if>
        </div>
    </div>
</section><!--/slider-->