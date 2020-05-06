<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>尝试</title>

<%--    <link rel="stylesheet" href="theme/layui/css/layui.css" media="all">--%>
<%--    <link rel="stylesheet" href="theme/css/2.css" media="all"/>--%>
<%--    <script src="theme/layui/layui.js"></script>--%>
    <script src="theme/js/calendar.js" type="text/javascript" language="javascript"></script>
    <script src="theme/js/jquery-2.1.0.min.js"></script>
<%--    <script>--%>
<%--        layui.use('carousel', function(){--%>
<%--            var carousel = layui.carousel;--%>
<%--            //建造实例--%>
<%--            carousel.render({--%>
<%--                elem: '#test1'--%>
<%--                ,width: '100%' //设置容器宽度--%>
<%--                ,arrow: 'always' //始终显示箭头--%>
<%--                //,anim: 'updown' //切换动画方式--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>


    <script>
        function a() {
            var json = {
                "name": "uzi",
                "age": 12,
                "gender": "男",
                "lastTeam": "rng",
                "mail": "123465@qq.com",
                "password": "123456",
                "identity": "战队选手"
            };
            $.ajax({
                url: "testServlet",
                data: {"json": JSON.stringify(json), "method": "testServlet"},
                type: "POST",
                success:function () {
                    alert(成功啦);
                }
            });

        }
    </script>


<%--    <script>--%>
<%--        function a() {--%>
<%--            var a = document.getElementById("txtDate1").value;--%>
<%--            alert(a);--%>
<%--        }--%>
<%--    </script>--%>

<%--    <script>--%>
<%--        function b() {--%>
<%--            // var a = document.getElementsByClassName("gender").value;--%>
<%--            --%>
<%--            alert(${gender});--%>
<%--        }--%>
<%--    </script>--%>
</head>
<body>

<h2>测试json</h2>
<input type="button" onclick="a()">


<%--<h3>时间插件测试</h3>--%>

<%--<input name="txtDate1" type="text" style="padding-left:5px;" id="txtDate1" onclick="SetDate(this,'yyyy-MM-dd')" readonly="readonly" />--%>
<%--<input type="button" onclick="a();">--%>


<%--<h3>单选框测试</h3>--%>

<%--<form action="${pageContext.request.contextPath}/testServlet">--%>
<%--    <label>性别：</label>--%>
<%--    <input type="radio" name="gender" class="gender" value="男" checked="checked"/>男--%>
<%--    <input type="radio" name="gender" class="gender" value="女"/>女--%>
<%--    <input type="submit">--%>
<%--</form>--%>
<%--<input type="button" onclick="b();">--%>


<%--<h3>头像上传及展示测试</h3>--%>

<%--<form>--%>
<%--    <div>--%>
<%--        <img src = "theme/userImages/${requestScope.image}" alt="...">--%>
<%--    </div>--%>
<%--</form>--%>
<%--<form action="${pageContext.request.contextPath}/testServlet" method="post" enctype="multipart/form-data">--%>
<%--    <div>--%>
<%--        <img src="theme/userImages/${requestScope.image}" alt="...">--%>
<%--    </div>--%>
<%--    头像<input type="file" name="head"><br>--%>
<%--    <input type="submit" value="注册">--%>
<%--</form>--%>
<%--<!-- 条目中可以是任意内容，如：<img src=""> -->--%>



<%--<h3>录播图片测试</h3>--%>

<%--<div class="layui-fluid" style="margin-top: 20px;">--%>
<%--    <div class="layui-row layui-col-space10">--%>
<%--        <!-- 常规轮播 -->--%>
<%--        <div class="layui-col-sm4 layui-col-md4" style="margin-left: 230px">--%>
<%--            <div class="layui-card" style="width: 1030px; height: 590px">--%>
<%--                <div class="layui-card-header">--%>
<%--                    <fieldset class="layui-elem-field layui-field-title">--%>
<%--                        <legend>常规轮播</legend>--%>
<%--                    </fieldset>--%>
<%--                </div>--%>
<%--                <div class="layui-card-body" >--%>
<%--                    <div class="layui-carousel" id="carousel02" >--%>
<%--                        <div carousel-item style="width: 1000px; height: 500px">--%>
<%--                            <div>--%>
<%--                                <a href="http://www.baidu.com"/>--%>
<%--                                <img src="theme/images/uzi.jpg" />--%>
<%--                                </a>--%>
<%--                            </div>--%>
<%--                            <div>--%>
<%--                                <img src="theme/images/uzi.jpg" />--%>
<%--                            </div>--%>
<%--                            <div>--%>
<%--                                <img src="img/a3.jpg" />--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <!-- 常规轮播 End -->--%>
<%--    </div>--%>
<%--</div>--%>


<%--<script type="text/javascript" src="theme/layui/layui.js"></script>--%>
<%--<script type="text/javascript" src="theme/js/carousel.js"></script>--%>
</body>
</html>
