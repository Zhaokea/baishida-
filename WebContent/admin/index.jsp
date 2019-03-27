<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>网上订餐管理员登陆</title>
<link href="images/skin.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/verify.js"></script>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #50a3a2;
}
</style>
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

<body>
	<table width="100%" height="66" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="42" valign="top">
				<table width="100%" height="42"	border="0" cellpadding="0" cellspacing="0" style="background-color: #4A708B;background-repeat: repeat-x;">
					<tr>
						<td width="100%" height="21">&nbsp;</td>
						<td height="42">&nbsp;</td>
						<td width="100%">&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td valign="top">
				<table width="100%" height="532" border="0"
					cellpadding="0" cellspacing="0" class="login_bg">
					<tr>
						<td width="50%" valign="bottom"><table width="100%"
								height="59" border="0" align="center" cellpadding="0"
								cellspacing="0">
								
								<tr>
									<td>&nbsp;</td>
									<td height="21"><table cellSpacing="0" cellPadding="0"
											width="100%" border="0" id="table211" height="328">
											<tr>
												<td height="164" colspan="2" align="center">

																				<!--EL表达式                          发送请求到AdminServlet    用？传值       动作为login-->
													<form class="form1" name="form1" action="${pageContext.request.contextPath}/AdminServlet?action=login" method="post"
														onSubmit="return verifyLogin()">
														<button  type="text" id="login-button">登陆网上订餐后台管理</button>
														<Br /> <Br />
														<table cellSpacing="0" cellPadding="0" width="100%"
															border="0" height="143" id="table212">
															
																
															<tr>
															<td height="38" colspan="2" class="top_hui_text"><input
																	name="name" class="name" value="" size="20" placeholder="管理员"></td>
															</tr>
															<tr>
																
																<td height="38" colspan="2" class="top_hui_text"><input
																	class="pwd" type="password" size="20" name="pwd" placeholder="密码">
																</td>
															</tr>
															<tr>
																
																<td height="38"><input name="Submit"
																	type="submit" class="button" id="Submit" value="登 陆">
																</td>
																</tr>
															<tr>
																<td height="38" class="top_hui_text"><input
																	name="cs" type="reset" class="button" id="cs"
																	value="重置"></td>
															</tr>
														</table>
														<br>
													</form>

												</td>
											</tr>
											<tr>
												<td width="433" height="164" align="right" valign="bottom" background="#50a3a2"></td>
												<td width="57" align="right" valign="bottom">&nbsp;</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
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
		<tr>
			<td height="50"><table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0" style="background-color: #4A708B;background-repeat: repeat-x;">
					<tr>
						<td align="center"><span class="login-buttom-txt" >Copyright
								&copy; 2017-2020</span></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>

${updatemsg }
</html>
