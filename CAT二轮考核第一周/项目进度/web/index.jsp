<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
<%--	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>--%>
<%--	<meta name="viewport" content="width=device-width, initial-scale=1"/>--%>
<%--	<meta name="keywords" content=""/>--%>

	<title>HOME</title>

	<link rel="icon" href="theme/images/favicon.ico">
	<link rel="shortcut icon" href="theme/images/favicon.ico" />
	<link rel="stylesheet" href="theme/css/style1.css">
	<link rel="stylesheet" href="theme/css/slider.css">
	<link href="theme/css/bootstrap.min.css" rel="stylesheet">

	<script src="theme/js/jquery-2.1.0.min.js"></script>
	<script src="theme/js/superfish.js"></script>
	<script src="theme/js/tms-0.4.1.js"></script>
	<script src="theme/js/bootstrap.min.js"></script>
	<script>
	 	 $(window).load(function(){
	 	 	$('.slider')._TMS({
				show:0,
			  	pauseOnHover:false,
			  	prevBu:'.prev',
			  	nextBu:'.next',
			  	playBu:false,
			  	duration:800,
			  	preset:'fade',
			  	pagination:true,//'.pagination',true,'<ul></ul>'
				pagNums:false,
				slideshow:8000,
				numStatus:false,
				banners:true,
				waitBannerAnimation:false,
				progressBar:false
	  		})
	 	 });

	</script>
</head>
<body>
<!--==============================header=================================-->
 <header>
	 <div class="container_12">
		<div class="grid_12">
			<h1><a href="index2.jsp"><img src="theme/images/4.png" alt="英雄联盟选手转会系统"></a> </h1>
			<div class="clear"></div>
			<div class="menu_block">
				<nav  class="" >
					<ul class="sf-menu">
						<li class="current">
					   		<a href="index.jsp">主页</a>
				   		</li>
				   		<li class="auction_mart">
							<a href="#">拍卖场</a>
				   		</li>
					</ul>
		   		</nav>
				<div class="clear"></div>
			</div>
		   	<div class="clear"></div>
		</div>
	</div>
</header>
<div class="top_block">
 	<div class="slider-relative">
		<div class="slider-block">
	 		 <div class="slider">
				<ul class="items">
					<li><img src="theme/images/slide.jpg" alt="">
						<div class="banner">The experience<br>
 						You May Trust
						</div>
					</li>
					<li><img src="theme/images/slide1.jpg" alt="">
						<div class="banner">Make a right<br> Choise</div>
					</li>
					<li><img src="theme/images/slide2.jpg" alt="">
			  			<div class="banner">We will show you the<br>
						way to success!
						</div>
					</li>
					<li><img src="theme/images/slide3.jpg" alt="">
			  			<div class="banner">Well being of our<br>
						clients first!
						</div>
		  			</li>
				</ul>
			 </div>
		</div>
	</div>
 </div>
<!--=======content================================-->

<div class="content page1">
	<div class="menu_block">
		<nav  class="" >
			<ul class="sf-menu">
				<p class="text-center" style="margin: 10px;">
					<a class="btn btn-default" href="#" role="button">全部</a>
					<a class="btn btn-default" href="#" role="button">打野</a>
					<a class="btn btn-default" href="#" role="button">中路</a>
					<a class="btn btn-default" href="#" role="button">下路</a>
					<a class="btn btn-default" href="#" role="button">上单</a>
					<a class="btn btn-default" href="#" role="button">辅助</a>
				</p>
			</ul>
		</nav>
		<div class="clear"></div>
		<hr>
	</div>
  	<div class="container_12">
		<c:forEach items="${pb.list}" var="info" varStatus="s">
			<div class="grid_3">
				<img src=${info.photo} alt="">
				<div class="text1">${info.pName}</div>
				<p class="col1"> ${info.gameCareer1}  ${info.gameCareer2}  ${info.gameCareer3} </p>
				<p class="col1"> ${info.pIntroduce} </p>
				<a href="#" class="btn">more</a>
			</div>

		</c:forEach>
  	</div>

</div>
<div>
	<nav aria-label="Page navigation">
		<ul class="pagination">
			<c:if test="${pb.currentPage == 1}">
			<li class="disabled">
				</c:if>

				<c:if test="${pb.currentPage != 1}">
			<li>
				</c:if>


				<a href="${pageContext.request.contextPath}/searchByPageServlet?currentPage=${pb.currentPage - 1}&number=8" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>


			<c:forEach begin="1" end="${pb.totalPage}" var="i" >


				<c:if test="${pb.currentPage == i}">
					<li class="active"><a href="${pageContext.request.contextPath}/searchByPageServlet?currentPage=${i}&number=8">${i}</a></li>
				</c:if>
				<c:if test="${pb.currentPage != i}">
					<li><a href="${pageContext.request.contextPath}/searchByPageServlet?currentPage=${i}&number=8">${i}</a></li>
				</c:if>

			</c:forEach>


			<li>
				<a href="${pageContext.request.contextPath}/searchByPageServlet?currentPage=${pb.currentPage + 1}&number=8" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
				</a>
			</li>
			<span style="font-size: 25px;margin-left: 5px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>

		</ul>
	</nav>
</div>
<div class="bottom_block">
	<div class="container_12">
		<div class="grid_6">
	  		<h5>Latest events</h5>
	  		<ul>
				<li><a href="#">Excepteur sint occaecat cupidatat</a></li>
				<li><a href="#">Vivamus ac odio ut enim ullamcorper</a></li>
				<li><a href="#">Quisque elementum tempus risus</a></li>
				<li><a href="#">Proin id tellus id tellus mattis posuere ac </a></li>
				<li><a href="#">Etiam non nibh id nibh porta ornare id ut </a></li>
	  		</ul>
		</div>
		<div class="grid_5">
	  		<h4>contact Us</h4>
	  		<p>Lorem ipsum dolor sit amet conse ctetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna  hjifd naliua. Ut enim ad minim veniam. Ghjkftuityojljpreytftf hdighj fgdlkaioi gdsfkruif weqpomvc jhlodfgohl hjdk.</p>
	  		<span>+1 (234) 4567-890</span><span>+1 (234) 4567-891</span>
		</div>
  	</div>
</div>

<div style="display:none">
	<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script>
</div>
</body>
</html>