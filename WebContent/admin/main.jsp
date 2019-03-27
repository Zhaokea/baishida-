<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>网上订餐后台- 管理页面</title>
<meta http-equiv=Content-Type content=text/html;charset=gb2312>
</head>

<!-- 使用的框架 -->
<frameset rows="64,*" frameborder="no" border="0" framespacing="0">

	<!-- 上面一部分 -->
	<frame src="admin_top.jsp" noresize="noresize" frameborder="no"
		name="topFrame" scrolling="no" marginwidth="0" marginheight="0"
		target="main" />

	<!-- 下面一部分 -->

	<frameset cols="200,*" rows="560,*" id="frame">
		<!-- 左面一部分 -->
		<frame src="admin_left.jsp" name="leftFrame" noresize="noresize"
			marginwidth="0" marginheight="0" frameborder="0" scrolling="no"
			target="main" />
		<!-- 右面一部分 -->
		<frame src="../qiantai/mainpage/images/slider/slider-img-1.jpg" name="main" marginwidth="0" marginheight="0"
			frameborder="0" scrolling="auto" target="_self" />
	</frameset>
	<noframes>
		<body></body>
	</noframes>
	</frameset>
</html>
