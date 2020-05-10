<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>个人主页</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="theme/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="theme/js/jquery-3.3.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="theme/js/bootstrap.min.js"></script>
<%--    <script type="text/javascript">--%>
<%--    </script>--%>
    <style type="text/css">
        .mat20{margin-top: 20px;}
        .highlight ul li img{width: 90%;margin: 0 auto;}
    </style>

    <script>
        var json = $.parseJSON(sessionStorage.getItem("json"));
        var user;
        var status;
        var ID;
        var name;
        if(json != null){
            user = json.user;
            status = json.status;
            ID = user.ID;
            name = user.name;
        }

        function searchPersonalInfo() {
            var json = {"ID": ID+"", "name": name};
            $.ajax({
                url: "baseServlet/user/showPersonalData",
                type: "POST",
                data: {"json": JSON.stringify(json)},
                dataType: "json",
                success : function (data) {
                    var user = data.data.user;
                    var history = data.data.history;
                    $("#headPicture").attr("src", "theme/userImages/" + user.head);
                    $("#uID").html(user.ID);
                    $("#personalData").append("<tr><td>姓名</td><td>"+user.name+"</td></tr>");
                    $("#personalData").append("<tr><td>年龄</td><td>"+user.age+"</td></tr>");
                    $("#personalData").append("<tr><td>性别</td><td>"+user.gender+"</td></tr>");
                    $("#personalData").append("<tr><td>邮箱</td><td>"+user.mail+"</td></tr>");
                    $("#personalData").append("<tr><td>上一支战队</td><td>"+(user.lastTeam!=null?user.lastTeam:"")+"</td></tr>");
                    $("#personalData").append("<tr><td>加入LPL时间</td><td>"+(user.joinDate!=null?user.joinDate:"")+"</td></tr>");
                    $("#personalData").append("<tr><td>个人简介</td><td>"+user.profile+"</td></tr>");
                    if(status == "详情"){
                        for(key in history){
                            $("#personalData").append("<tr><td>加入"+key+"</td><td>"+history[key]+"</td></tr>");
                        }
                    }

                    if(status == "个人信息"){
                        $(".highlight").hide();
                        var letter = data.data.map;
                        for(var key in letter){
                            $("#letter").append("<tr><td>"+key+"</td><td>"+letter[key]+"</td><td><button onclick='reply("+key+")'>回复</button></td></tr>")
                        }
                    }else if(status == "详情"){
                        $(".btn-info").hide();
                        $("#letterPage").hide();
                        if(data.data.photo1 != null)
                            $("#highlight").append("<li class=\"col-md-4 col-sm-4 col-xs-4 mat20\"><img src=\"./theme/userImages/highlight/"+data.data.photo1+"\"></li>");
                        if(data.data.photo2 != null)
                            $("#highlight").append("<li class=\"col-md-4 col-sm-4 col-xs-4 mat20\"><img src=\"./theme/userImages/highlight/"+data.data.photo2+"\"></li>");
                        if(data.data.photo3 != null)
                            $("#highlight").append("<li class=\"col-md-4 col-sm-4 col-xs-4 mat20\"><img src=\"./theme/userImages/highlight/"+data.data.photo3+"\"></li>");
                    }
                },
                error:function () {
                    alert("服务器繁忙");
                }
            })
        }
        function reply(master) {
            var content = prompt("请输入您要回复的内容：");
            if(content==null || content==""){
                alert("请输入您要回复的内容");
                return;
            }
            var json = {"master": master, "guest": name, "content": content};
            $.ajax({
                url: "baseServlet/user/reply",
                data: {"json": JSON.stringify(json)},
                dataType: "json",
                type: "POST",
                success: function (data) {
                    alert("回复成功");
                },
                error:function () {
                    alert("服务器繁忙");
                }

            })
        }

    </script>

</head>
<body onload="searchPersonalInfo()">
<input type="hidden" name="id">
<div align="center">
    <img id="headPicture" src="theme/images/uzi.jpg" alt="..." class="img-circle"/>
</div>
<form class="form-horizontal" style="margin-left: 480px; width: 600px; font-size: 21px;">
    <hr>
    <table class="table table-striped" id="personalData" style="font-size: 22px">
        <tr>
            <th>类型</th>
            <th>内容</th>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/updateServlet"><button type="button" class="btn btn-info" style="margin-left: 800px">修改信息</button></a>
<hr>
<div>
<div class="highlight">
    <div class="page-header" style="margin:0 auto;">
        <h2>高光时刻 <small>秀起来</small></h2>
    </div>
    <ul id="highlight">
    </ul>
</div>
</div>
<hr>
<div style="margin-left: 350px; width: 900px;" id="letterPage">
    <div class="page-header" style="margin:0 auto;">
        <h2>私信</h2>
    </div>
    <table id="letter" class="table table-hover" >
        <tr>
            <th>发信人</th>
            <th>内容</th>
            <th>操作</th>
        </tr>
    </table>

</div>
</body>
</html>
