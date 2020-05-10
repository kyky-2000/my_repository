<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
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
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>申请转会</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="theme/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="theme/js/jquery-3.3.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="theme/js/bootstrap.min.js"></script>

    <script>
        function addInfo(){

            var name = $("#name").val();
            var introduce = $("#introduce").val();
            var gameCareer1 = $("#gameCareer1").val();
            var gameCareer2 = $("#gameCareer2").val();
            var gameCareer3 = $("#gameCareer3").val();
            var salary = $("#salary").val();

            var json = {"name":name, "introduce":introduce, "gameCareer1":gameCareer1, "gameCareer2":gameCareer2,
                "gameCareer3":gameCareer3, "salary":salary};

            $.ajax({
                url: "baseServlet/info/addInfo",
                data: {"json" : JSON.stringify(json)},
                type:"POST",
                dataType: "json",
                success: function (data) {
                    alert(data.msg);
                },
                error: function () {
                    alert("服务器繁忙");
                }
            });
        }
    </script>
</head>
<body>
<div class="container">
    <div style="text-align: center;"><h3>申请转会</h3></div>
    <form method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" >
        </div>
        <div class="form-group">
            <label for="introduce">自我介绍：</label>
            <input type="text" class="form-control" id="introduce" name="introduce">
        </div>

        <div class="form-group">
            <label for="gameCareer1">擅长职业1：</label>
            <input type="text" class="form-control" id="gameCareer1" name="gameCareer1"/>
        </div>
        <div class="form-group">
            <label for="gameCareer2">擅长职业2：</label>
            <input type="text" class="form-control" id="gameCareer2" name="gameCareer2"/>
        </div>
        <div class="form-group">
            <label for="gameCareer3">擅长职业3：</label>
            <input type="text" class="form-control" id="gameCareer3" name="gameCareer3"/>
        </div>

        <div class="form-group">
            <label for="salary">预想薪水：</label>
            <input type="text" class="form-control" id="salary" name="salary" />
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" onclick="addInfo();"/>
            <a href="${pageContext.request.contextPath}/login.jsp"><input class="btn btn-default" type="button" value="返回" /></a>
        </div>
    </form>
</div>
</body>
</html>
