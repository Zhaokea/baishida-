<%@page import="java.util.*"%>
<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link href="images/common.css" rel="stylesheet" type="text/css" /> -->
<link href="${pageContext.request.contextPath}/admin/images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>

<script type="text/javascript">
	function deleteMenu(id){
		if(confirm("确认要删除吗")){
			window.location.href="MenuServlet?action=deleteMenu&id="+id;
		}
	}
</script>




</head>
<body>
	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<div align="center">
					<table id="table2" class="line_table"
						style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0">
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="11" height="20"><span
									class="left_bt2">菜单信息列表</span></td>
							</tr>
							<tr>
								<td class="line_table" align="center"><span
									class="left_bt2">菜单名称</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">展示图片</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">原料</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">类型</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">做法</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">市场价格</span></td>
							
							</tr>
						<c:if test="${pageCurrent.data!=null}">
						<c:forEach items="${pageCurrent.data}" var="menuinfo">
						
							<tr>
								<td class="line_table" align="center"><a
									href="menus_update.jsp?">${menuinfo.name}</a></td>
								<td class="line_table" align="center"><a
									href="../img/m_tangcupaigu.gif"><img src="${pageContext.request.contextPath}/${menuinfo.imgpath}"
										width="30" height="30"></a></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menuinfo.burden}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menuinfo.fname}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menuinfo.make}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menuinfo.price}</span></td>
								
								
							</tr>
						
						</c:forEach>
						</c:if>

						

						
							
							<tr>
								<td class="line_table" align="center" colspan="11" height="20">
								<span class="left_bt2">第${pageCurrent.curPage}页
										&nbsp;&nbsp;共${pageCurrent.totalPage}页
								</span>&nbsp;&nbsp; 
								    <a href="${pageContext.request.contextPath}/MenuServlet?action=getMenuByPage&curPage=1">[首页]</a>
								    <a href="${pageContext.request.contextPath}/MenuServlet?action=getMenuByPage&curPage=${pageCurrent.totalPage}">[尾页]</a>&nbsp;&nbsp; 
								    
								    
								    <!-- 对“上一页”按钮判断：若当前页为第一页，则 curpage=1；否则curpage=${pageCurrent.curPage-1}-->
								    <c:if test="${pageCurrent.curPage!=1}">
								    <a href="${pageContext.request.contextPath}/MenuServlet?action=getMenuByPage&curPage=${pageCurrent.curPage-1}">[上一页]</a>
									</c:if>
									<c:if test="${pageCurrent.curPage==1}">
								    <a href="${pageContext.request.contextPath}/MenuServlet?action=getMenuByPage&curPage=1">[上一页]</a>
									<!--或不让跳转 <a href="#">[上一页]</a>
									 			或<a href="javascript：void(0)">[上一页]</a>
									 -->
									</c:if>
									
									<c:if test="${pageCurrent.curPage!=pageCurrent.totalPage}">
								    <a href="${pageContext.request.contextPath}/MenuServlet?action=getMenuByPage&curPage=${pageCurrent.curPage+1}">[下一页]</a>
									</c:if>
									<c:if test="${pageCurrent.curPage==pageCurrent.totalPage}">
								    <a href="${pageContext.request.contextPath}/MenuServlet?action=getMenuByPage&curPage=${pageCurrent.curPage}">[下一页]</a>
									<!--或不让跳转 <a href="#">[下一页]</a>
									 			或<a href="javascript：void(0)">[下一页]</a>
									 -->
									</c:if>
									
									<!-- 以上过程太繁琐，可用choose实现 -->
									<c:choose>
										<c:when test="">
										
										</c:when>
										
										<c:otherwise>
										
										</c:otherwise>
									</c:choose>
									
									</td>
							</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
${addmsg }
${deletemsg }
${updatemsg }
</html>
