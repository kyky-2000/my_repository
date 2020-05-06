<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>注册</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="theme/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. 监听用户输入是否为空 -->
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600,700" rel="stylesheet">
    <!-- 3. jQuery导入，建议使用1.9以上的版本 -->
    <script src="theme/js/jquery-2.1.0.min.js"></script>
    <!-- 4. 导入bootstrap的js文件 -->
    <script src="theme/js/bootstrap.min.js"></script>
    <!-- 5. 倒计时插件的包 -->
    <script type="text/javascript" src="theme/js/leftTime.min.js"></script>
    <!-- 6. 日期插件-->
    <script src="theme/js/calendar.js" type="text/javascript" language="javascript"></script>

    <script type="text/javascript">
        function a() {
            $.ajax({
                url: "sendCodeServlet",
                type: "POST",
                data: {mail: $("#mail").val()},
                success: function () {
                    alert("成功");
                }
            });
        }

        function s(){
            var head = $("#head").val();
            var name = $("#name").val();
            var gender = $(".gender").val();
            var age = $("#age").val();
            var mail = $("#mail").val();
            var lastTeam = $("#lastTeam").val();
            var code = $("#code").val();
            var profile = $("#profile").val();
            var password = $("#password").val();
            var identity = $(".identity").val();
            var test = "试试";

            var json = {"head":head, "name":name, "gender":gender, "age":age, "mail":mail, "lastTeam":lastTeam,
                "code":code, "profile":profile, "password":password, "identity":identity, "test":test};

            alert(name);
            // var data = $("form").serialize();
            // data = decodeURIComponent(data, true);

            $.ajax({
                url: "testServlet",
                data: {"json" : JSON.stringify(json)},
                type:"POST",
                success: function () {
                    alert("注册成功");
                },
                error: function () {
                    alert("注册失败");
                }
            });
        }
        $(function(){
            $("#mail").blur(function () {
                if (checkEMail($(this)) == true) {
                    $("#dateBtn1").attr("disabled", false);
                } else {
                    alert("账号非邮箱地址！");
                }
            });

            function checkEMail(e){
                var reEml = /^[\w\-\.]+@[a-z0-9]+(\-[a-z0-9]+)?(\.[a-z0-9]+(\-[a-z0-9]+)?)*\.[a-z]{2,4}$/i;
                if(reEml.test(e.val())){
                    return true;
                }else{
                    return false;
                }
            }
            $("#dateBtn1").on("click",function(){
                var _this=$(this);
                a();
                $("#dateBtn1").attr("disabled", true);
                if(!$(this).hasClass("on")){
                    $.leftTime(60,function(d){
                        if(d.status){
                            _this.addClass("on");
                            _this.html((d.s=="00"?"60":d.s)+"秒后重新获取");
                        }else{
                            _this.removeClass("on");
                            _this.html("获取验证码");
                            $("#dateBtn1").attr("disabled", false);
                        }
                    });
                }
            });
        })
    </script>
</head>
<body>
<div class="container">
    <div style="text-align: center;"><h3>注册新用户</h3></div>
    <form action="" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>请传入DVD图片<br>必须是gif格式</label>
            <input type="file" name="head" id="head" required=""/>
        </div>
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入真实姓名" required=""/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" class="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" class="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄" required=""/>
        </div>

<%--        <div class="form-group">--%>
<%--            <label for="address">籍贯：</label>--%>
<%--            <select name="address" class="form-control" id="address">--%>
<%--                <option value="陕西">陕西</option>--%>
<%--                <option value="北京">北京</option>--%>
<%--                <option value="上海">上海</option>--%>
<%--            </select>--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="lastTeam">效力的上一支队伍：</label>
            <input type="text" class="form-control" id="lastTeam" name="lastTeam" placeholder="请输入您效力的上一支队伍" required=""/>
        </div>
        <div class="form-group">
            <label for="mail">邮箱：</label>
            <div class="input-group">
                <input type="text" class="form-control" id="mail" name="mail" placeholder="请输入正确的邮箱">
<%--                <button class="btn btn-default" type="button" id="get_code" onclick="a();" disabled="true">发送验证码</button>--%>
                <span> </span>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
        <button type="button" class="testBtn-a" id="dateBtn1" disabled="true" style="display: inline-block;height:30px;line-height:30px;padding:0 10px;
                    border:0; border-radius:5px;color:#fff;background:rgb(65,133,244);cursor: pointer">获取验证码</button>
        <div class="form-group">
            <label for="code">验证码</label>
            <input type="text" class="form-control" id="code" name="code" placeholder="请输入验证码" required=""/>
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码" required=""/>
        </div>
        <div class="form-group">
            <label for="joinDate">加入LPL时间</label>
            <input type="text" class="form-control" id="joinDate" name="joinDate" placeholder="2020-02-02"
                   onclick="SetDate(this,'yyyy-MM-dd')" readonly="readonly" required=""/>
        </div>
        <div class="form-group">
            <label>身份</label>
            <input type="radio" name="identity" class="identity" value="战队管理层" checked="checked"/>战队管理层
            <input type="radio" name="identity" class="identity" value="职业选手"/>职业选手
        </div>
        <div class="form-group">
            <label for="profile">个人简介</label>
            <textarea class="form-control" id="profile" name="profile" rows="4" placeholder="介绍一下自己吧"></textarea>
        </div>
        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" id="submit" type="submit" value="提交" onclick="s();"/>
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>
