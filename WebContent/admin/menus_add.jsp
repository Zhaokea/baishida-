<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<script type="text/javascript" src="js/verify.js"></script>
<script type="text/javascript">
	function verifyInfo() {
		//��Ʒ����
		if(!verifyNotNull(document.form1.name.value)) {
			alert("��Ʒ���Ʋ���Ϊ��!");
			return false;
		}
		//ԭ��
		if(!verifyNotNull(document.form1.burden.value)) {
			alert("ԭ�ϲ���Ϊ��");
			return false;
		}
		//�г��۸�
		/* debugger; */
		if(!verifyPositiveInt(document.form1.price.value)) {
			alert("�г��۸����Ϊ������");
			return false;
		}
		
		//˵��
		if(!verifyNotNull(document.form1.brief.value)) {
			alert("��������Ϊ��");
			return false;
		}
		//ͼƬ
		if(!verifyNotNull(document.form1.img.value)) {
			alert("ͼƬ����Ϊ��");
			return false;
		}
	}
</script>
</head>
<body>

	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">

				<p>��Ӳ˵�</p>

				<div align="center">

					<form action="${pageContext.request.contextPath}/MenuServlet?action=addMenu" method="post" name="form1"
						onSubmit="return verifyInfo()" enctype="multipart/form-data">


						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">��Ʒ���ƣ�</span></td>
								<td class="line_table" height="25" width="80%"><input
									type="text" name="name" size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">ԭ&nbsp;&nbsp;&nbsp; �ϣ�</span></td>
								<td class="line_table" height="25" width="80%"><input
									type="text" name="burden" size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">�г��۸�</span></td>
								<td height="25" width="80%"><input type="text" name="price"
									size="45" value=""></td>
							</tr>
							
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">��&nbsp;&nbsp;&nbsp; ����</span></td>
								<td class="line_table" height="25" width="80%"><textarea
										rows="12" name="make" cols="100"></textarea></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">��Ʒ���</span></td>
								<td class="line_table" height="25" width="80%">
								<select name="typeid">
									<c:if test="${typeList!=null}">
									<c:forEach items="${typeList }" var="type">
										<option value="${type.id}">${type.name}</option>
									</c:forEach>
									</c:if>			
								</select></td>
							</tr>

							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">�ϴ�ͼƬ��</span></td>
								<td class="line_table" height="25" width="80%"><input
									type="file" name="img" size="50"></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="center" colspan="2"><input
									type="submit" value="���"></td>
							</tr>
						</table>
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
