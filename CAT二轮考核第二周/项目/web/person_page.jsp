<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>个人主页</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="theme/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="theme/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="theme/js/bootstrap.min.js"></script>
<%--    <script type="text/javascript">--%>
<%--    </script>--%>
    <style type="text/css">
        .mat20{margin-top: 20px;}
        .highlight ul li img{width: 90%;margin: 0 auto;}
    </style>

</head>
<body>
<div align="center">
    <img src="theme/images/uzi.jpg" alt="..." class="img-circle"/>
</div>
<form class="form-horizontal" style="margin-left: 450px; width: 600px; font-size: 21px;">
    <span class="form-group" style="display: none">
        <label for="uID" class="col-sm-2 control-label" >用户标识</label>
        <label id="uID" class="col-sm-2 control-label" >${user.uID}</label>
    </span>
    <hr>
    <div class="form-group" style="line-height:24px;padding:3px;vertical-align: top;">
        <label for="name" class="col-sm-2 control-label" >姓名：</label>
        <label id="name" class="col-sm-2 control-label">${user.name}</label>
    </div>
    <br>
    <div class="form-group">
        <label for="age" class="col-sm-2 control-label" >年龄：</label>
        <label id="age" class="col-sm-2 control-label" >${user.age}</label>
    </div>
    <br>
    <div class="form-group" >
        <label for="gender" class="col-sm-2 control-label" >性别：</label>
        <label id="gender" class="col-sm-2 control-label">${user.gender}</label>
    </div>
    <br>
    <div class="form-group">
        <label for="mail" class="col-sm-2 control-label" >邮箱：</label>
        <label id="mail" class="col-sm-2 control-label" >${user.mail}</label>
    </div>
    <br>
    <div class="form-group">
        <label for="lastTeam" class="col-sm-2 control-label" style="width: 160px">上一支战队：</label>
        <label id="lastTeam" class="col-sm-2 control-label" >${user.lastTeam}</label>
    </div>
    <br>
    <div class="form-group">
        <label for="identity" class="col-sm-2 control-label" style="width: 145px">用户身份：</label>
        <label id="identity" class="col-sm-2 control-label" >${user.identity}</label>
    </div>
    <br>
    <area class="form-group">
    <label for="profile" class="col-sm-2 control-label" style="width: 140px">个人简介：</label><br>
    <area id="profile" class="col-sm-2 control-label" style="font-size: 16px" disabled="true"></area>
    </div>
</form>
<button type="button" class="btn btn-info" style="margin-left: 800px">修改信息</button>
<hr>
<div>
<div class="highlight">
    <div class="page-header" style="margin:0 auto;">
        <h2>高光时刻 <small>秀起来</small></h2>
    </div>
    <ul>
        <li class="col-md-4 col-sm-4 col-xs-4 mat20"><img src="theme/images/1.png"></li>
        <li class="col-md-4 col-sm-4 col-xs-4 mat20"><img src="theme/images/1.png"></li>
        <li class="col-md-4 col-sm-4 col-xs-4 mat20"><img src="theme/images/1.png"></li>
        <li class="col-md-4 col-sm-4 col-xs-4 mat20"><img src="theme/images/1.png"></li>
        <li class="col-md-4 col-sm-4 col-xs-4 mat20"><img src="theme/images/1.png"></li>
        <li class="col-md-4 col-sm-4 col-xs-4 mat20"><img src="theme/images/1.png"></li>
        <div class="clear"></div>
    </ul>
    <div>
        <input type="file" name="file" id="images" value="上传图片" style="color:blue">
    </div>
</div>
</div>
<hr>
<div class="comment" style="margin-left: 300px; width: 900px;">
    <div class="page-header" style="margin:0 auto;">
        <h2>评论</h2>
    </div>
    <ul class="list-group">
        <li class="list-group-item">Cras justo odio</li>
        <li class="list-group-item">Dapibus ac facilisis in</li>
        <li class="list-group-item">Morbi leo risus</li>
        <li class="list-group-item">Porta ac consectetur ac</li>
        <li class="list-group-item">Vestibulum at eros</li>
    </ul>
    <div class="col-lg-6" style="width: 900px">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search for...">
            <span class="input-group-btn">
        <button class="btn btn-default" type="button">Go!</button>
      </span>
        </div><!-- /input-group -->
    </div><!-- /.col-lg-6 -->
</div>
</body>
</html>
