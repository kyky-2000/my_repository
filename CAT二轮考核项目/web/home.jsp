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

    <script src="theme/js/jquery-3.3.1.min.js"></script>
    <script src="theme/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="theme/layui/layui.js"></script>
    <script type="text/javascript" src="theme/js/carousel.js"></script>

    <script>
        var user = $.parseJSON(sessionStorage.getItem("json"));
        var uID;
        var username;
        if(user!=null) {
            uID = user.ID;
            username = user.ID;
        }
        function searchPhotos() {
            $.ajax({
                url: "baseServlet/info/searchPhotos",
                type: "POST",
                data: {"json": null},
                dataType: "json",
                success: function (data) {
                    var photos = data.data;
                    for (var i = 0; i < photos.length; ++i) {
                        $("#photo" + (i + 1)).attr("src", "theme/userImages/" + photos[i].photo + "");
                    }
                }
            })
            showInfo(1, "");
        }

        function showInfo(currentPage, gameCareer){
            var contextPath = $("#contextPath");
            // if(isNaN(currentPage)){
            //     _currentPage = currentPage + "";
            // }else
            //     _currentPage = currentPage;
            $.ajax({
                url: "baseServlet/info/searchInfo",
                type: "POST",
                data: {"json": JSON.stringify({"currentPage": currentPage+"", "number": 9+"", "gameCareer": gameCareer})},
                dataType: "json",
                success: function (data) {
                    $(".col-md-4").remove();
                    var list = data.data.list;
                    for(var i=0; i<list.length; ++i){
                        if(user != null && user.identity == "战队管理层"){
                            $("#info_group").append("" +
                                "<div class=\"col-sm-6 col-md-4\"style='height: 600px'>\n" +
                                "                <div class=\"thumbnail\" style='height: 70%'>\n" +
                                "                    <img src=\"./theme/userImages/"+list[i].photo+"\" style='height: 30%'>\n" +
                                "                    <div class=\"caption\">\n" +
                                "                        <h2>"+list[i].name+"</h2>\n" +
                                "                        <p style=\"color: #0000FF; font-size: large\">\n" +
                                "                            "+list[i].gameCareer1+"&nbsp&nbsp"+(list[i].gameCareer2==null?"":list[i].gameCareer2)+"&nbsp&nbsp"+(list[i].gameCareer3==null?"":list[i].gameCareer3)+"\n" +
                                "                        </p>\n" +
                                "                        <p style='font-size: large; color: #761c19'>\n" +
                                "                            期望薪资 "+list[i].salary+"元/年\n" +
                                "                        </p>\n" +
                                "                        <p>\n" +
                                "                            "+list[i].introduce+"\n" +
                                "                        </p>\n" +
                                "                        <p><a class=\"btn btn-primary\" onclick=\"turnPersonal("+list[i].ID+",'"+list[i].name+"');\">详情</a> " +
                                "                          <a class=\"btn btn-default\" role=\"button\" onclick='deleteInfo("+list[i].ID+")'>邀请</a> <a class=\"btn btn-default\" role=\"button\" onclick='updateInfo('"+list[i].name+"')'>举报</a></p>\n" +
                                "                    </div>\n" +
                                "                </div>\n" +
                                "            </div>");
                        }else if(user != null && user.identity == "职业选手"){
                            $("#info_group").append("" +
                                "<div class=\"col-sm-6 col-md-4\"style='height: 600px'>\n" +
                                "                <div class=\"thumbnail\" style='height: 70%'>\n" +
                                "                    <img src=\"./theme/userImages/"+list[i].photo+"\" style='height: 30%'>\n" +
                                "                    <div class=\"caption\">\n" +
                                "                        <h2>"+list[i].name+"</h2>\n" +
                                "                        <p style=\"color: #0000FF; font-size: large\">\n" +
                                "                            "+list[i].gameCareer1+"&nbsp&nbsp"+(list[i].gameCareer2==null?"":list[i].gameCareer2)+"&nbsp&nbsp"+(list[i].gameCareer3==null?"":list[i].gameCareer3)+"\n" +
                                "                        </p>\n" +
                                "                        <p style='font-size: large; color: #761c19'>\n" +
                                "                            期望薪资 "+list[i].salary+"元/年\n" +
                                "                        </p>\n" +
                                "                        <p>\n" +
                                "                            "+list[i].introduce+"\n" +
                                "                        </p>\n" +
                                "                        <p><a class=\"btn btn-primary\" onclick=\"turnPersonal("+list[i].ID+",'"+list[i].name+"');\">详情</a> </p>" +
                                "                    </div>\n" +
                                "                </div>\n" +
                                "            </div>");
                        }else{
                            $("#info_group").append("" +
                                "<div class=\"col-sm-6 col-md-4\"style='height: 600px'>\n" +
                                "                <div class=\"thumbnail\" style='height: 70%'>\n" +
                                "                    <img src=\"./theme/userImages/"+list[i].photo+"\" style='height: 30%'>\n" +
                                "                    <div class=\"caption\">\n" +
                                "                        <h2>"+list[i].name+"</h2>\n" +
                                "                        <p style=\"color: #0000FF; font-size: large\">\n" +
                                "                            "+list[i].gameCareer1+"&nbsp&nbsp"+(list[i].gameCareer2==null?"":list[i].gameCareer2)+"&nbsp&nbsp"+(list[i].gameCareer3==null?"":list[i].gameCareer3)+"\n" +
                                "                        </p>\n" +
                                "                        <p style='font-size: large; color: #761c19'>\n" +
                                "                            期望薪资 "+list[i].salary+"元/年\n" +
                                "                        </p>\n" +
                                "                        <p>\n" +
                                "                            "+list[i].introduce+"\n" +
                                "                        </p>\n" +
                                "                    </div>\n" +
                                "                </div>\n" +
                                "            </div>");
                        }
                    }

                    var pageBean = data.data;
                    $("#pageNumber").empty();
                    if(pageBean.currentPage == 1){
                        $("#pageNumber").append("" +
                            "<li class=\"disabled\" id=\"right\">\n" +
                            "      <span>\n" +
                            "        <span aria-hidden=\"true\">&laquo;</span>\n" +
                            "      </span>\n" +
                            "    </li>" +
                            "");
                    }else{
                        $("#pageNumber").append("" +
                            "<li id=\"right\">" +
                            "<a aria-label=\"Previous\">" +
                            "<span aria-hidden=\"true\">&laquo;</span>" +
                            "</a>" +
                            "</li>" +
                            "");
                    }
                    for(var j=1; j<=pageBean.totalPage; ++j){
                        if(j == pageBean.currentPage){
                            $("#pageNumber").append("" +
                                "<li class=\"active\">\n" +
                                "      <span>"+j+"<span class=\"sr-only\"></span></span>\n" +
                                "    </li>" +
                                "");
                        }else{
                            $("#pageNumber").append("" +
                                "<li><a>"+j+"<span class=\"sr-only\"></span></a></li>" +
                                "");
                        }
                    }
                    $("#pageNumber").append("" +
                        "<li id=\"left\">\n" +
                        "      <a aria-label=\"Next\">\n" +
                        "        <span aria-hidden=\"true\">&raquo;</span>\n" +
                        "      </a>\n" +
                        "    </li>" +
                        "");
                    $("#pageNumber").append("" +
                        "<span style=\"font-size: 25px;margin-left: 5px;\">\n" +
                        "                    共"+pageBean.totalCount+"条记录，共"+pageBean.totalPage+"页\n" +
                        "            </span>" +
                        "");

                    addListener(pageBean.currentPage, gameCareer);
                }

            })
        }

        function addListener(currentPage, gameCareer) {
            $(" li ").click(function(){
                // alert($(this).text());
                showInfo($(this).text(), gameCareer);
            });

            $("#left").unbind("click");
            $("#right").unbind("click");

            $("#left").click(function () {
                showInfo(currentPage + 1, gameCareer);
            });
            $("#right").click(function () {
                showInfo(currentPage - 1, gameCareer);
            });
        }
        function turnPersonal(ID, name) {
            if(ID==null || ID==""){
                ID = uID;
            }
            if(name==null || name==""){
                name = username;
            }
            var status = $(this).text();
            if(status!="个人信息"){
                status = "详情"
            }
            var user = {"name": name, "ID": ID};
            var json = {"user": user, "status": status};

            sessionStorage.setItem("json", JSON.stringify(json));
            window.location.href = "/person_page.jsp";
        }
        function deleteInfo(ID){
            var json = {"ID": ID, "name": "Info"};
            $.ajax({
                url: "baseServlet/manager/delete",
                data: {"json": JSON.stringify(json)},
                type: "POST",
                dataType: "json",
                success: function (data) {
                    alert(data.msg);
                },
                error: function () {
                    alert("服务器繁忙");
                }
            })
        }
        function updateInfo(name){
            var json = {"name": name, "status": "被举报"};
            $.ajax({
                url: "baseServlet/user/updateInfo",
                data: {"json": JSON.stringify(json)},
                type: "POST",
                dataType: "json",
                success: function (data) {
                    alert(data.msg);
                },
                error: function () {
                    alert("服务器繁忙");
                }
            })
        }

        $(function () {
            if(!user){
                $(".btn-lg").hide();
                $(".btn-primary").hide();
                $(".btn-default").hide();
            }

            if(user!=null && user.identity == "战队管理层")
            $(".btn-default").click(function () {
                var gameCareer;
                if($(this).text() == "全部"){
                    gameCareer = "";
                }else{
                    gameCareer = $(this).text();
                }
                showInfo(1, gameCareer);
            });

        });

    </script>
</head>
<body onload="searchPhotos()">
<!--==============================header=================================-->

<%--<span class="form-group" style="display: none">--%>
<%--    <label id="contextPath" >${pageContext.request.contextPath}</label>--%>
<%--</span>--%>

<div class="page-header" >
    <h1 style="font-size: 60px">英雄联盟转会 <small>欢迎您</small></h1>
</div>
<div class="layui-fluid" style="margin-top: 20px;">
    <div class="layui-row layui-col-space10">
        <!-- 常规轮播 -->
        <div class="layui-col-sm4 layui-col-md4" style="margin-left: 230px">
            <div class="layui-card" style="width: 1030px; height: 590px">
                <div class="layui-card-header">
                    <fieldset class="layui-elem-field layui-field-title">
                        <legend>热门选手</legend>
                    </fieldset>
                </div>
                <div class="layui-card-body" >
                    <div class="layui-carousel" id="carousel02" >
                        <div carousel-item style="width: 1000px; height: 500px">
                            <div>
                                <img src="theme/images/uzi.jpg" id="photo1"/>
                                </a>
                            </div>
                            <div>
                                <img src="theme/images/uzi.jpg" id="photo2"/>
                            </div>
                            <div>
                                <img src="theme/images/uzi.jpg" id="photo3"/>
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
<hr>
<div style="float: end; margin: 5px">
    <p>
        <button type="button" class="btn btn-default btn-lg" onclick="turnPersonal()">个人信息</button>
        <button type="button" class="btn btn-primary btn-lg">提交转会申请</button>
    </p>
</div>
<hr>

<div class="content page1">
    <div class="menu_block">
        <nav  class="" >
            <ul class="sf-menu">
                <p class="text-center" style="margin: 10px;">
                    <a class="btn btn-default" href="#" role="button">全部</a>
                    <a class="btn btn-default" href="#" role="button">打野</a>
                    <a class="btn btn-default" href="#" role="button">中路</a>
                    <a class="btn btn-default" href="#" role="button">下路</a>
                    <a class="btn btn-default" href="#" role="button">上路</a>
                    <a class="btn btn-default" href="#" role="button">辅助</a>
                </p>
            </ul>
        </nav>
        <div class="clear"></div>
        <hr>
    </div>
    <div style="margin-left: 100px; width: 1300px">
        <div class="row" id="info_group" >
        </div>
    </div>
</div>
<div>
    <nav aria-label="Page navigation" style="margin-left: 600px">
        <ul class="pagination" id="pageNumber">
        </ul>
    </nav>

</div>

</body>
</html>