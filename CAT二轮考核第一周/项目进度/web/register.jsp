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
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="theme/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="theme/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div style="text-align: center;"><h3>注册新用户</h3></div>
    <form action="${pageContext.request.contextPath}/registerServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入真实姓名">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
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
            <input type="text" class="form-control" id="lastTeam" name="lastTeam" placeholder="请输入您效力的上一支队伍"/>
        </div>

        <div class="form-group">
            <label for="mail">Email：</label>
            <input type="text" class="form-control" id="mail" name="mail" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group">
            <label for="password">密码</label>
            <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码"/>
        </div>

        <div class="form-group">
            <label>身份</label>
            <input type="radio" name="identity" value="战队管理层" checked="checked"/>战队管理层
            <input type="radio" name="identity" value="职业选手"/>职业选手
        </div>

        <div class="form-group">
            <label for="profile">个人简介</label>
            <textarea class="form-control" id="profile" name="profile" rows="4" placeholder="介绍一下自己吧"></textarea>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>
