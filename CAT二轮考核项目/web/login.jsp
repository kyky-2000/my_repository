<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <title>登录</title>

    <link href="./theme/css/style.css" rel='stylesheet' type='text/css' media="all">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600,700" rel="stylesheet">
    <script type="text/javascript" src="./theme/js/jquery-3.3.1.min.js"></script>
    <script>
        addEventListener("load", function () { setTimeout(hideURLbar, 0); }, false); function hideURLbar() { window.scrollTo(0, 1); }

        function refreshCode(){
            $("#vcode").attr("src", "${pageContext.request.contextPath}/baseServlet/user/checkCode?time="+new Date().getTime());
        }

        function login() {
            var checkCode1 = $("#checkCode").val();
            var mail = $("#mail").val();
            var password = $("#password").val();
            var json = {"checkCode1": checkCode1, "mail": mail, "password": password};

            $.ajax({
                url: "/baseServlet/user/login",
                data: {"json": JSON.stringify(json)},
                type: "POST",
                dataType: "json",
                success: function(data) {
                    if(data.code == 200) {
                        alert(data.data.name + "用户， 欢迎您");
                        sessionStorage.setItem("json", JSON.stringify(data.data));
                        window.location.href = "/home.jsp";
                    }
                    else
                        alert(data.msg);
                }
            });
        }
    </script>

</head>
<body>
    <div class="mid-class">
        <div class="art-right-w3ls">
            <h2>欢迎您</h2>
            <form method="post">
                <div class="main">
                    <div class="form-left-to-w3l">
                        <input type="text" name="mail" id="mail" placeholder="账号" required="">
                    </div>
                    <div class="form-left-to-w3l ">
                        <input type="password" name="password" id="password" placeholder="密码" required="">
                        <div class="clear"></div>
                    </div>
                    <div class="form-left-to-w31">
                        <input type="text" name="verifycode" id="checkCode" placeholder="请输入验证码" required="">
                        <a href="javascript:refreshCode();">
                            <img src="${pageContext.request.contextPath}/baseServlet/user/checkCode" title="看不清点击" id="vcode"/>
                        </a>
                    </div>
                </div>
                <div class="left-side-forget">
                    <input type="checkbox" class="checked">
                    <span class="remenber-me">记住密码 </span>
                </div>
                <div class="right-side-forget">
                    <a href="#" class="for">忘记密码?</a>
                </div>
                <div class="clear"></div>
                <div class="btnn">
                    <button type="submit" id="btnn-login" onclick="login();" >登录</button>
                </div>
                <!-- 出错显示的信息框 -->
<%--                <div class="alert alert-warning alert-dismissible" role="alert">--%>
<%--                    <button type="button" class="close" data-dismiss="alert" >--%>
<%--                        <span>&times;</span>--%>
<%--                    </button>--%>
<%--                    <strong>${login_msg}</strong>--%>
<%--                </div>--%>
            </form>
            <div class="w3layouts_more-buttn">
                <h3>您当前还没有用户吗?
                    <a href="${pageContext.request.contextPath}/register.jsp">注册新用户
                    </a>
                </h3>
            </div>
        </div>
    </div>
</body>
</html>