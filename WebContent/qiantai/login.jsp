<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>用户登录</title>
<head>
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/memberlogin_c.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/verify.js"></script>
<script type="text/javascript">
	//验证用户名和密码是否为空
	function verifyLogin() {
		if(!verifyNotNull(document.form1.name.value)) {
			alert("用户名不能为空！");
			return false;
		}
		
		if(!verifyNotNull(document.form1.pwd.value)) {
			alert("密码不能为空！");
			return false;
		}
	}
</script>
</head>
<body >
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top">
  
    
 <jsp:include flush="fasle" page="top.jsp"/>
    
    </td>
  </tr>
  <tr >
  <td height="20"></td>
  
</tr>
  
  <tr  >
    <td align="center" valign="middle">
    
    
    <div class="htmleaf-container">
	<div class="wrapper">
		<div class="container" style="width:900px;">
			<h1>请登录O(∩_∩)O~~</h1>
			
			<form class="form1" method="post" action="${pageContext.request.contextPath}/UserServlet?action=login" name="form1" onsubmit="return verifyLogin()">
				<input type="text" placeholder="用户名" id="muser" name="name"  >
				<input type="password" placeholder="密码" id="mpass" name="pwd" >
				<button >登录！biu~~</button> <Br /> <Br />
				<a class="input1" href="qiantai/reg.jsp" target="_self" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点这里注册新会员&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
			</form>
		</div>
		
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
</div>
    
<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script>
$('#login-button').click(function (event) {
	event.preventDefault();
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
});
</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
</div>    
    </td>
  </tr>

  <tr>
    <td height="35" align="center" valign="middle">&nbsp; 
   
        <jsp:include flush="fasle" page="copyright.jsp"/>
    </td>
  </tr>
  
</table>


 
</body>
</html>
