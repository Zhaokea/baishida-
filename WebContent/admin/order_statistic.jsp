<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="admin/images/skin.css" rel="stylesheet" type="text/css" />
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
								<td class="line_table" align="center" colspan="8" height="20">
									<span class="left_bt2">本日销售额统计</span>
								</td>
							</tr>
							<tr>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">菜品名称</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">订购数量</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">单价</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">合计</span></td>
							</tr>

						<c:forEach items="${orderByPage.data}" var="order">
						<c:set var="totalMoney" value="${totalMoney+order.menuSum*order.price1}"></c:set>
							<tr>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${order.menuName }</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${order.menuSum }</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${order.price1 }</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${order.price1*order.menuSum }</span></td>
							</tr>
							

						</c:forEach>
						
							<tr>
								<td class="line_table" align="center" colspan="11" height="20">
								<span class="left_bt2">第${orderByPage.curPage}页
										&nbsp;&nbsp;共${orderByPage.totalPage}页
								</span>&nbsp;&nbsp; 
								    <a href="${pageContext.request.contextPath}/AdminOrderServlet?action=sumOrderByPage&curPage=1">[首页]</a>
								    <a href="${pageContext.request.contextPath}/AdminOrderServlet?action=sumOrderByPage&curPage=${orderByPage.totalPage}">[尾页]</a>&nbsp;&nbsp; 
								    
								    
								    <!-- 对“上一页”按钮判断：若当前页为第一页，则 curpage=1；否则curpage=${orderByPage.curPage-1}-->
								    <c:if test="${orderByPage.curPage!=1}">
								    <a href="${pageContext.request.contextPath}/AdminOrderServlet?action=sumOrderByPage&curPage=${orderByPage.curPage-1}">[上一页]</a>
									</c:if>
									<c:if test="${orderByPage.curPage==1}">
								    <a href="${pageContext.request.contextPath}/AdminOrderServlet?action=sumOrderByPage&curPage=1">[上一页]</a>
									<!--或不让跳转 <a href="#">[上一页]</a>
									 			或<a href="javascript：void(0)">[上一页]</a>
									 -->
									</c:if>
									
									<c:if test="${orderByPage.curPage!=orderByPage.totalPage}">
								    <a href="${pageContext.request.contextPath}/AdminOrderServlet?action=sumOrderByPage&curPage=${orderByPage.curPage+1}">[下一页]</a>
									</c:if>
									<c:if test="${orderByPage.curPage==orderByPage.totalPage}">
								    <a href="${pageContext.request.contextPath}/AdminOrderServlet?action=sumOrderByPage&curPage=${orderByPage.curPage}">[下一页]</a>
									<!--或不让跳转 <a href="#">[下一页]</a>
									 			或<a href="javascript：void(0)">[下一页]</a>
									 -->
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="line_table" align="center" colspan="8"><span
									class="left_bt2">本日销售总额：${totalMoney}元
								</span></td>
							</tr>
						
					</table>
				</div>

			</td>

		</tr>
	</table>
</body>
</html>
