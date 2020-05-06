<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <title>HOME</title>

    <link href="theme/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="theme/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="theme/css/2.css" media="all"/>

    <script src="theme/js/jquery-2.1.0.min.js"></script>
    <script src="theme/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="theme/layui/layui.js"></script>
    <script type="text/javascript" src="theme/js/carousel.js"></script>
</head>
<body>
<!--==============================header=================================-->
<div class="page-header">
    <h1>英雄联盟转会 <small>欢迎您</small></h1>
</div>
<div class="layui-fluid" style="margin-top: 20px;">
    <div class="layui-row layui-col-space10">
        <!-- 常规轮播 -->
        <div class="layui-col-sm4 layui-col-md4" style="margin-left: 230px">
            <div class="layui-card" style="width: 1030px; height: 590px">
                <div class="layui-card-header">
                    <fieldset class="layui-elem-field layui-field-title">
                        <legend>常规轮播</legend>
                    </fieldset>
                </div>
                <div class="layui-card-body" >
                    <div class="layui-carousel" id="carousel02" >
                        <div carousel-item style="width: 1000px; height: 500px">
                            <div>
                                <a href="http://www.baidu.com"/>
                                <img src="theme/images/uzi.jpg" />
                                </a>
                            </div>
                            <div>
                                <img src="theme/images/uzi.jpg" />
                            </div>
                            <div>
                                <img src="theme/images/uzi.jpg" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 常规轮播 End -->
    </div>
</div>

<!--=======content================================-->

<div class="content page1">
    <div class="menu_block">
        <nav  class="" >
            <ul class="sf-menu">
                <p class="text-center" style="margin: 10px;">
                    <a class="btn btn-default" href="#" role="button">全部</a>
                    <a class="btn btn-default" href="#" role="button">打野</a>
                    <a class="btn btn-default" href="#" role="button">中路</a>
                    <a class="btn btn-default" href="#" role="button">下路</a>
                    <a class="btn btn-default" href="#" role="button">上单</a>
                    <a class="btn btn-default" href="#" role="button">辅助</a>
                </p>
            </ul>
        </nav>
        <div class="clear"></div>
        <hr>
    </div>
    <div style="margin-left: 100px; width: 1300px">
        <div class="row">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img src="theme/images/4.jpg" alt="...">
                    <div class="caption">
                        <h2>UZI</h2>
                        <p style="color: #0000FF; font-size: large">
                            打野&nbsp&nbsp中路&nbsp&nbsp辅助
                        </p>
                        <p>
                            对面五个人，你们被我包围了,对面五个人，你们被我包围了,对面五个人，你们被我包围了
                        </p>
                        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-4" style="min-height: 480px">
                <div class="thumbnail">
                    <img src="theme/images/4.jpg" alt="...">
                    <div class="caption">
                        <h2>UZI</h2>
                        <p style="color: #0000FF; font-size: large">
                            打野&nbsp&nbsp中路&nbsp&nbsp辅助
                        </p>
                        <p>
                            对面五个人，你们被我包围了
                        </p>
                        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-4" style="min-height: 480px">
                <div class="thumbnail">
                    <img src="theme/images/4.jpg" alt="...">
                    <div class="caption">
                        <h2>UZI</h2>
                        <p style="color: #0000FF; font-size: large">
                            打野&nbsp&nbsp中路&nbsp&nbsp辅助
                        </p>
                        <p>
                            对面五个人，你们被我包围了
                        </p>
                        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img src="theme/images/4.jpg" alt="...">
                    <div class="caption">
                        <h3>Thumbnail label</h3>
                        <p>...</p>
                        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img src="theme/images/4.jpg" alt="...">
                    <div class="caption">
                        <h3>Thumbnail label</h3>
                        <p>...</p>
                        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                    </div>
                </div>
            </div>
        </div>

<%--        <div>--%>
<%--            <c:forEach items="${pb.list}" var="info" varStatus="s">--%>
<%--                <div class="grid_3">--%>
<%--                    <img src=${info.photo} alt="">--%>
<%--                    <div class="text1">${info.pName}</div>--%>
<%--                    <p class="col1"> ${info.gameCareer1}  ${info.gameCareer2}  ${info.gameCareer3} </p>--%>
<%--                    <p class="col1"> ${info.pIntroduce} </p>--%>
<%--                    <a href="#" class="btn">more</a>--%>
<%--                </div>--%>

<%--            </c:forEach>--%>
<%--        </div>--%>

    </div>
</div>
<div>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pb.currentPage == 1}">
            <li class="disabled">
                </c:if>

                <c:if test="${pb.currentPage != 1}">
            <li>
                </c:if>


                <a href="${pageContext.request.contextPath}/searchByPageServlet?currentPage=${pb.currentPage - 1}&number=8" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>


            <c:forEach begin="1" end="${pb.totalPage}" var="i" >


                <c:if test="${pb.currentPage == i}">
                    <li class="active"><a href="${pageContext.request.contextPath}/searchByPageServlet?currentPage=${i}&number=8">${i}</a></li>
                </c:if>
                <c:if test="${pb.currentPage != i}">
                    <li><a href="${pageContext.request.contextPath}/searchByPageServlet?currentPage=${i}&number=8">${i}</a></li>
                </c:if>

            </c:forEach>


            <li>
                <a href="${pageContext.request.contextPath}/searchByPageServlet?currentPage=${pb.currentPage + 1}&number=8" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 25px;margin-left: 5px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>

        </ul>
    </nav>
</div>

</body>
</html>