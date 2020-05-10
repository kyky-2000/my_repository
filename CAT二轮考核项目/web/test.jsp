<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="theme/css/bootstrap.min.css" rel="stylesheet">
    <script src="./theme/js/jquery-3.3.1.min.js"></script>
    <script src="theme/js/bootstrap.min.js"></script>

    <script>
        // var user = $.parseJSON(sessionStorage.getItem("json"));
        // alert(user.name);
        // alert(user.ID);


        function a() {
            var json = {
                "name": "uzi",
                "age": $("#age").val(),
                "gender": "男",
                "lastTeam": "rng",
                "mail": "123465@qq.com",
                "password": "123456",
                "identity": "战队选手"
            };
            $.ajax({
                url: "/baseServlet/user/login",
                data: {"json": JSON.stringify(json), "method": "testServlet"},
                type: "POST",
                dataType: "json",
                success:function(data) {
                    // alert(data);
                    alert(data.code);
                    alert(data.data);
                },
                error:function () {
                    alert("不行啊");
                }
            });

        }


        function b() {
            var json1 = {
                "name": "uzi",
                "introduce": "老子全能",
                "gameCareer1": "打野",
                "gameCareer2": "中路",
                "gameCareer3": "下路"
            };
            $.ajax({
                url: "/baseServlet/info/addInfo",
                data: {"json": JSON.stringify(json1), "method": "testServlet"},
                type: "POST",
                success:function (data) {
                    alert("成功啦");
                }
            });

        }

        function c() {
            $.ajax({
                url: "/baseServlet/user/turn",
                data: {"name":"test"},
                type: "POST",
                success:function (data) {
                    var name = "uzi";
                    var password = "123456";
                    var mail = "123@qq.com";
                    var profile = "我来试试";
                    var json = {"name":name, "password": password, "mail":mail, "profile": profile};
                    sessionStorage.setItem("json", JSON.stringify(json));
                    window.location.href="/test1.jsp?json=tryOneTry";
                    alert("成功啦");
                }
            });

        }

        function doUpload() {
            // var formData = new FormData($("#uploadForm")[0]);//构造FormData对象
            var formObj = $("#uploadForm")[0];
            var formData = new FormData(formObj);
            $.ajax({
                url: 'baseServlet/user/upload',//接受请求的Servlet地址
                type: 'POST',
                // data: {"formData": new FormData($("#uploadForm")[0])},
                data: formData,
                processData:false,
                async: true,//同步请求
                cache: false,//不缓存页面
                contentType: false,//当form以multipart/form-data方式上传文件时，需要设置为false
                // processData: false,//如果要发送Dom树信息或其他不需要转换的信息，请设置为false
                success: function () {
                    // $("#img_test").attr('src', url);//上传成功后，把服务器获取到的图片路径绑定到img标签是src属性上
                    alert("成功啦");
                },
                error: function () {
                    // alert();
                }

            });
        }



        // $(function () {
        //     // $(" li ").click(function () {
        //     //      alert($(this).text() - 1);
        //     //
        //     // })
        //     // $("#left").unbind("click");
        //     // $("#left").click( function () {
        //     //     alert("hhh");
        //     // })
        //     $(" tr ").click(function () {
        //         alert($(this)[0]);
        //     })
        // })

        function aa() {
            alert($(this).val());
        }



       $(function () {
           var name = "老板";
       });
        function searchPersonalInfo() {
            var json = {"ID": "13", "name": "老板"};
            $.ajax({
                url: "baseServlet/user/showPersonalData",
                type: "POST",
                data: {"json": JSON.stringify(json)},
                dataType: "json",
                success:function () {
                    alert($("#tt").val())
                }
            })
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
<a onload="aa()">aaaaaa</a>
<input type="button" name="id" value="${ID}">
<%--<a href="${pageContext.request.contextPath}/test1.jsp?ID=${ID}"><input type="button"></a>--%>
<input type="button" onclick="searchPersonalInfo()" >
<%--<label id="name">hhhhhhhh</label>--%>


<%--测试分页行的操作--%>
<%--<nav aria-label="Page navigation">--%>
<%--    <ul class="pagination">--%>
<%--        <li>--%>
<%--            <a href="#" aria-label="Previous">--%>
<%--                <span aria-hidden="true">&laquo;</span>--%>
<%--            </a>--%>
<%--        </li>--%>
<%--&lt;%&ndash;        <li onclick="d()"><a>99</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <li onclick="d()">666</li>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <li onclick="d()"><a onclick="d()">2</a></li>&ndash;%&gt;--%>
<%--        <li><a href="#">3</a></li>--%>
<%--        <li><a href="#">4</a></li>--%>
<%--        <li><a href="#">5</a></li>--%>
<%--        <li id="left">--%>
<%--            <a href="#" aria-label="Next">--%>
<%--                <span aria-hidden="true">&raquo;</span>--%>
<%--            </a>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--</nav>--%>
<%--<button onclick="e()">--%>





<%--<h2>测试json</h2>--%>
<%--<input type="text" id="age">--%>
<%--<input type="button" onclick="a()">--%>
<%--<input type="button" onclick="b()">--%>
<%--<input type="button" onclick="c()">--%>

<%--<a onclick="d()"> <span id="dd" >啊哈</span></a>>--%>
<%--<a onclick="d()"> aaa<span id="aa" >啊哈</span></a>>--%>

<%--<p class="col1"> ${object.name}  ${object.age}  ${object.status} </p>--%>

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
<%--&lt;%&ndash;    <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <img src="theme/userImages/${requestScope.image}" alt="...">&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--    头像<input type="file" name="file"><br>--%>
<%--    <input type="submit" value="上传">--%>
<%--</form>--%>
<!-- 条目中可以是任意内容，如：<img src=""> -->


<%--<form id="uploadForm" enctype="multipart/form-data">--%>
<%--    <label for="file">头像：</label>--%>
<%--    <input type="file" name="file" id="file" />--%>
<%--    &lt;%&ndash;            <label for="file">头像：</label>&ndash;%&gt;--%>
<%--    &lt;%&ndash;            <input type="file" name="file" id="file1" />&ndash;%&gt;--%>
<%--    <input type="submit" value="上传" onclick="doUpload();" />--%>
<%--</form>--%>


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
