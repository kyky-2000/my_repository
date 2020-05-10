<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>尝试</title>
    <link href="theme/css/bootstrap.min.css" rel="stylesheet">
    <script src="./theme/js/jquery-3.3.1.min.js"></script>
    <script src="theme/js/bootstrap.min.js"></script>
    <script>

        <%--var code = "${sessionScope._checkCode}";--%>
        <%--function refreshCode(){--%>
        <%--    $("#vcode").attr("src", "${pageContext.request.contextPath}/baseServlet/user/checkCode?time="+new Date().getTime());--%>
        <%--    code = "${sessionScope._checkCode}"--%>
        <%--}--%>
        <%--function a() {--%>
        <%--    alert(code);--%>
        <%--}--%>


        // var json = $.parseJSON(sessionStorage.json);
        // // var json = sessionStorage.json;
        // alert(json);
        // alert(json.name);
        // alert(json.profile);

        // $("#aa").html(json);
        // function a() {
        //     var  json1 = sessionStorage.json
        //     alert(json1)
        // }

        // function a() {
        //     $(".btn-default").hide();
        // }



        // $(function () {
        //     $("#test").val("试试");
        // })
        // function a() {
        //     alert($("#test").val());
        // }



        // function doUpload() {
        //     // var formData = new FormData($("#uploadForm")[0]);//构造FormData对象
        //     // var formObj = $("#uploadForm");
        //     // var formData = new FormData(formObj);
        //     $.ajax({
        //         url: 'testServlet',//接受请求的Servlet地址
        //         type: 'POST',
        //         data: {"formData": new FormData($("#uploadForm")[0])},
        //         processData:false,
        //         // async: true,//同步请求
        //         cache: false,//不缓存页面
        //         contentType: false,//当form以multipart/form-data方式上传文件时，需要设置为false
        //         // processData: false,//如果要发送Dom树信息或其他不需要转换的信息，请设置为false
        //         success: function () {
        //             // $("#img_test").attr('src', url);//上传成功后，把服务器获取到的图片路径绑定到img标签是src属性上
        //             alert("成功啦");
        //         },
        //         error: function () {
        //             // alert();
        //         }
        //
        //     });
        // }

        // function upload() {
        //     $.ajax({
        //         //几个参数需要注意一下
        //         type: "POST",//方法类型
        //         dataType: "json",//预期服务器返回的数据类型
        //         url: "baseServlet/user/upload" ,//url
        //         // data: $('#form1').serialize(),
        //         success: function (result) {
        //             // console.log(result);//打印服务端返回的数据(调试用)
        //             // if (result.resultCode == 200) {
        //             //     alert("SUCCESS");
        //             // }
        //             // ;
        //             alert("正常")
        //         },
        //         error : function() {
        //             alert("异常！");
        //         }
        //     });
        //}

        // function a(){
        //     // $("#photo" + 1).src = "theme/userImages/2.jpg";
        //     $("#photo" + 1).attr("src", "theme/userImages/2.jpg");
        // }


        // $(function () {
        //     $("button").click(function () {
        //         alert($(this).html()+ "被点击了");
        //     })
        // });



        // function a() {
        //     for (var i = 0; i < 7; ++i) {
        //         var j = i+".jsp";
        //         var k = "theme/userImages/" + j + ".jsp";
        //         $(".info_group").append("" +
        //             "<div class=\"col-sm-6 col-md-4\">\n" +
        //             "                <div class=\"thumbnail\">\n" +
        //             "                    <img src=\"theme/userImages/"+i+".jpg\" id=\"img"+i+"\"alt=\"...\">\n" +
        //             "                    <div class=\"caption\">\n" +
        //             "                        <h2>UZI</h2>\n" +
        //             "                        <p style=\"color: #0000FF; font-size: large\">\n" +
        //             "                            打野&nbsp&nbsp中路&nbsp&nbsp辅助\n" +
        //             "                        </p>\n" +
        //             "                        <p>\n" +
        //             "                            对面五个人，你们被我包围了,对面五个人，你们被我包围了,对面五个人，你们被我包围了\n" +
        //             "                        </p>\n" +
        //             "                        <p><a href=\"#\" class=\"btn btn-primary\" role=\"button\">Button</a> <a href=\"#\" class=\"btn btn-default\" role=\"button\">Button</a></p>\n" +
        //             "                    </div>\n" +
        //             "                </div>\n" +
        //             "            </div>")
        //
        //         $("#img"+i).src = "theme/userImages/" + i + ".jsp";
        //
        //     }
        //     $("#img" + 1).src = "theme/userImages/uzi.jpg";
        //     $("#img" + 6).hide();
        // }

        // $(function () {
        //     $(".btn-lg").click(function () {
        //         // alert($(this).text());
        //         if($(this).text() == "个人信息"){
        //             alert(1111);
        //         }else if($(this).text() == "提交转会申请"){
        //             alert(2222);
        //         }
        //     })
        // });

    </script>

</head>
<body onload="a()">
<form>
    <button value="${ID}">



    <%--测试分页展示--%>
    <div class="info_group">
    </div>
<%--        <button onclick="a()">--%>



<%--    &lt;%&ndash;测试按钮值的获取&ndash;%&gt;--%>
<%--        <div class="btn-group" role="group" aria-label="...">--%>
<%--            <button type="button" class="btn btn-default">Left</button>--%>
<%--            <button type="button" class="btn btn-default">Middle</button>--%>
<%--            <button type="button" class="btn btn-default">Right</button>--%>
<%--        </div>--%>
<%--        <button type="button" class="btn btn-default1" onclick="a()">Right</button>--%>
        <p>
            <button type="button" class="btn btn-default btn-lg">个人信息</button>
            <button type="button" class="btn btn-primary btn-lg">提交转会申请</button>
        </p>


    <%--测试拼接图片路径能否展示--%>
<%--    <img src="theme/userImages/1.jpg" id="photo1">--%>
<%--    <button onclick="a();">--%>



<%--    &lt;%&ndash;测试用ajax图片上传&ndash;%&gt;--%>
<%--        <form id="uploadForm" enctype="multipart/form-data">--%>
<%--            <label for="file">头像：</label>--%>
<%--            <input type="file" name="file" id="file" />--%>
<%--&lt;%&ndash;            <label for="file">头像：</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="file" name="file" id="file1" />&ndash;%&gt;--%>
<%--            <input type="button" value="上传" onclick="doUpload();" />--%>
<%--        </form>--%>

<%--        <form action="" method="post" id="form1" enctype="multipart/form-data">--%>
<%--&lt;%&ndash;            <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <img src="theme/userImages/${requestScope.image}" alt="...">&ndash;%&gt;--%>
<%--&lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--            头像<input type="file" name="head"><br>--%>
<%--            <input type="submit" value="注册" onclick="upload()">--%>
<%--        </form>--%>






<%--    &lt;%&ndash;测试标签值的获取&ndash;%&gt;--%>
<%--    <input type="text" id="test">--%>
<%--    <input type="button" onclick="a()">--%>


     <%--测试按钮组隐藏功能--%>
<%--    <div class="btn-group" role="group" aria-label="...">--%>
<%--        <button type="button" class="btn btn-default">Left</button>--%>
<%--        <button type="button" class="btn btn-default">Middle</button>--%>
<%--        <button type="button" class="btn btn-default">Right</button>--%>
<%--    </div>--%>
<%--    <button type="button" class="btn btn-default1" onclick="a()">Right</button>--%>

    <%--测试获取session，结果失败--%>
<%--    <div>--%>
<%--        <img src = "theme/userImages/${requestScope.image}" alt="...">--%>
<%--    </div>--%>
<%--    <input type="button" onclick="a()">--%>
<%--    <label id="aa">${sessionScope.json}</label>--%>

         <%--测试验证码--%>
         <%--    <div >--%>
<%--        <input type="text" name="verifycode" id="checkCode" placeholder="请输入验证码" required="">--%>
<%--        <a href="javascript:refreshCode();">--%>
<%--            <img src="${pageContext.request.contextPath}/baseServlet/user/checkCode" title="看不清点击" id="vcode"/>--%>
<%--        </a>--%>
<%--        <button onclick="a()"></button>--%>
<%--    </div>--%>
</form>
</body>
</html>
