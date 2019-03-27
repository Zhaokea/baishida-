<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"> 
<link href="qiantai/css/common.css" rel="stylesheet" type="text/css" />
<link href="qiantai/css/A.css" rel="stylesheet" type="text/css" />
<link href="qiantai/css/topmenu_bk.css" rel="stylesheet" type="text/css" />

 <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.css" rel="stylesheet">
 <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
 <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <style>
            #subMenu {
                display: none;
                position: fixed;
                top: 55px;
                left: 10px;
            }
         </style>
        <script>
            function showSubMenu() {
                var m = document.getElementById("subMenu");
                m.style.display = "block";
            }
 
            function hiddenSubMenu() {
                var m = document.getElementById("subMenu");
                m.style.display = "none";
            }
        </script>



 <style>
        
        body,
        html {
            font-size: 20px;
            font-family: 'Microsoft Yahei', '微软雅黑', 'Simsun', '宋体', 'Arial', sans-serif;
        }
        img {
            border: 0;
        }
        a {
            color: #fff;
            text-decoration: none;
            outline: none;
        }
        ol,
        ul,
        li {
            list-style: none;
        }
        
        
        .head-nav {
            width: 100%;
            height: 45px;
            background: ;
        }
        .head-nav-con {
            width: 1200px;
            height: 60px;
            margin: auto;
        }
        .head-nav-con ul li {
            width: 110px;
            height: 45px;
            font-size: 15px;
            text-align: center;
        }
        .head-nav-con ul li:hover {
            background: #84ff7b;
        }
        .head-nav-con ul a {
            display: block;
            text-decoration: none;
            text-align: center;
            line-height: 60px;
            color: white;
        }
        .head-nav-con .drop-down {
            position: relative;
        }
        
        
        .head-nav-con .drop-down-content {
            padding: 0;
            height: 45px;
            display: none;
            position: absolute;
            z-index: 1;
            background: #9ab2ff;
        }
        .head-nav-con .drop-down-content li:hover > a {
            background-color: #84ff7b;
        }
        .head-nav-con .drop-down:hover .drop-down-content {
            display: block;
        }
        
        
        
        .head-nav-con .drop-down-2 {
            position: relative;
        }
        .head-nav-con .drop-down-content-2 {
            padding: 0;
            
            width: 440px;
            display: none;
            position: absolute;
            z-index: 1;
            background-color: #9ab2ff;
            right: -440px;
            top: 0;
        }
        .head-nav-con .drop-down-content-2 > li {
            float: none;
            background-color: #9ab2ff;
        }
        .head-nav-con .drop-down-content-2 li:hover a {
            background-color: 84ff7b;
        }
        .head-nav-con .drop-down-2:hover .drop-down-content-2 {
            display: block;
        }
    </style>








</head>
<body style='background: transparent'>



	<div id='contain'
		style='width: 900px; background: rgb(255, 255, 255); margin: 0px auto; padding: 0px'>

		<div id='top'
			style='width: 900px; height: 75px; background: none transparent scroll repeat 0% 0%'>


			<!-- 顶部菜单(一级) -->

			<div id='pdv_3607' class='pdv_class'
				style='width: 500px; height: 25px; top: 0px; left: 350px; z-index: 4'>
				<div id='spdv_3607' class='pdv_top'
					style='overflow: hidden; width: 100%; height: 100%'>
					<div class="pdv_border"
						style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">

						<div style="padding: 0px">
							<div id="topmenu">
								亲爱的${user.name}您好!&nbsp;&nbsp;欢迎光临!| 
								<a href="qiantai/login.jsp" target="_self">会员登录</a>| 
								<a href="qiantai/reg.jsp" target="_self">会员注册</a>| 
								<a href="${pageContext.request.contextPath}/UserServlet?action=logout">注销退出</a>| 
								<a href="qiantai/carry.jsp" target="_self">配送说明</a>| 
								<a href="qiantai/our.jsp" target="_self">关于我们</a>
							</div>

						</div>
					</div>

				</div>
			</div>

			<!-- 二级导航菜单 -->

			<div id='pdv_3605' class='pdv_class'
				style='width: 898px; height: 41px; top: 100px; left: 0px; z-index: 6;color:'>
				<div id='spdv_3605' class='pdv_top'
					style='overflow: visible; width: 100%; height: 100%'>
					<div class="pdv_border"
						style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
						<div
							style="height: 50px; margin: 1px; display: none; background:;">
							<div
								style="float: left; margin-left: 0px; line-height: 25px; font-weight: bold; color:#1C86EE">

							</div>
							<div style="float: right; margin-right: 10px; display: none">
								<a href="-1" style="line-height: 25px; color:">更多</a>
							</div>
						</div>
						<div style="padding: 0px ">
							<div id="menu">
								<div class="mainmenuleft"></div>
								<div class="mainmenuright"></div>

								<div  id="mainmenu" >
								
					
					
					
<div class="header">
        <div class="head-nav">
        <div class="head-nav-con clearFloat">
            
                <ul>
					

                    
                    <li class="drop-down"><a href="qiantai/index.jsp">菜谱分类</a>
                        <ul class="drop-down-content">
                                <li class="drop-down-2"><a>食疗健康</a>
                                <ul class="drop-down-content-2">
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=1">高血糖</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=2">高血压</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=3">高血脂</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=4">低血糖</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=5">胆固醇高</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=6">胃炎</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=7">腹泻</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=8">咳嗽</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=9">口腔溃疡</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=10">消化不良</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=11">便秘</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=12">肾亏</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=13">止咳</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=14">发烧</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=15">降火</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=16">缺钾</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=17">中暑</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=18">热感冒</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=19">咳嗽有痰</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=20">扁桃体发炎</a></li>
                                    <li><a href="${pageContext.request.contextPath}/IllnessServlet?action=searchByFname&fname=21">对抗雾霾</a></li>
                                    
                                </ul>
                                </li>
                             
                        </ul>
                    </li>
                            			<li><a href="qiantai/index.jsp" target="_self">首页</a></li>

										<li><a href="qiantai/shoppingcar.jsp" target="_self">我的餐车</a></li>

										<li><a href="qiantai/order.jsp" target="_self">我的订单</a></li>
										<li><a href="qiantai/center.jsp" target="_self">用户中心</a></li>

										<li><a href="qiantai/carry.jsp" target="_self">配送说明</a></li>

										<li><a href="qiantai/our.jsp" target="_self">关于我们</a></li>

										<li><a href="${pageContext.request.contextPath}/UserServlet?action=logout">注销退出</a></li>
							
								
                           


                          
                    
                </ul>
            </div>
        </div>
    </div>					
					
					
					
									
									
								</div>

      


								<div id="smenu">
									<div class="smenuleft"></div>
									<div class="smenuright"></div>
									<ul>

									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

								</div>
							</div>
							<script>
								showMenu(0);
							</script>

						</div>
					</div>

				</div>
			</div>
						
			<style>
				.box1 {width:300px;float:left; display:inline;}
				.box2 {width:100px;float:left; display:inline;}
			</style>
			<div class="container" >
			
			<div id='pdv_3608' class="box1" title=''
				style='width: 310px; height: 80px; left: 0px; z-index: 10'>
				<div id='spdv_3608' class='pdv_top'
					style='overflow: hidden; width: 100%; height: 100% '>
						<div class="pdv_border"
						style="margin: 0; padding: 0; width: 100%; height: 60px; border: 0px solid; background:;">
						<div style="padding: 0px">
							<img src="qiantai/images/logo.jpg" alt="" height= "55px" width="50%" border="0" />
							<font size="4pt" color="green">您的专属营养师</font>
						</div>
						</div>
                 </div>
            </div>

    
                 
			</div>

		</div>	
</div>


</body>
${addmsg}
</html>
