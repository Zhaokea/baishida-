<%@page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜品展示</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="qiantai/css/dingcanall.css" rel="stylesheet" type="text/css" />
<link href="qiantai/css/newslist_time2.css" rel="stylesheet" type="text/css" />	
<link href="qiantai/css/dingcanche.css" rel="stylesheet" type="text/css" />	
<link href="qiantai/css/dingcanweekmenu.css" rel="stylesheet" type="text/css" />									
</head>

<body style='background: transparent'>
	

	
	
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		 <tr>
			<td height="30"></td>

		</tr>

		<tr>
			<td align="left" valign="top"><table width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="59%" align="left" valign="top"><div id='pdv_3606'
								class='pdv_class' title=''
								style='width: 648px; top: 0px; left: 0px; z-index: 11'>
								<div id='spdv_3606' class='pdv_content'
									style='overflow: visible; width: 100%;'>
									
		
		
									
	<div class="details">
        <div class="goods-img">
            <div class="main-img pic-big">
				<img src="${meal.imgpath}" />
            </div>
        </div>
        
        <div class="goods-info">
            <div class="good-name">${meal.name}</div>
            <div class="price-view">
                <p>价格</p>
                <div class="price">
                    ￥
                    <span>${meal.price}</span>
                    <span class="market-price">￥${meal.price+2}
                    </span>
                </div>
               
            </div>

                    <div class="addToCart handleCss" ><a class="addToCart handleCss" style="color: #fff" href="ShoppingCarServlet?action=add&mealId=${meal.id }">加入购物车</a></div>

        </div>
    </div>
									

	<div class="howmake">

	
			<fieldset class="particulars">
				<legend>主料</legend>
				<div class="recipeCategory_sub_R clear">
					<ul>
						<li>
							<span class="category_s1">
								<b>${meal.burden}</b>
							</span>
						</li>
					</ul>
				</div>
			</fieldset>
	
	
			<fieldset class="particulars1">
				<legend>做法步骤</legend>
				<div class="recipeCategory_sub_R clear">
					<ul>
						<li>
							<span class="category_s1">
								<b>${meal.make}</b>
							</span>
						</li>
					</ul>
				</div>
			</fieldset>	
	
	
	
	
	</div>				
							<!-- 		<div class="pdv_border"
										style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
										<div style="padding: 0px">
											<div id="dingcanall2">

												<div style="margin-top: 0px; padding: px;">






<div class="detail-desc">
            <div class="detail-comment">
                <div class="">商品介绍</div>
            </div>
            <div class="detail-content">
                															<div style="margin-top: 10px; margin-left: 30px; float: left;">
																<table>
																	<tr>
																		<td rowspan="5" class="bookPic"><img
																			src="img/m_fenzhengrou.gif" width="350px" height="350px"
																			 /></td>
																		<td></td>
																		<td><span class="good-name">鸡汁百叶包</span></td>
																		<td><span><strong>${menu.name}</strong></span></td>
																	</tr>
																	<tr>
																		<td></td>
																		<td><span class="price">价格:</span></td>
																		<td><span class="price1">￥15.90</span><span class="market-price">￥16.90</span></td>
                
																		<td><span>${menu.price}</span></td>
																	</tr>
																	<tr>
																		<td><span>配料:</span></td>
																		<td><span>${menu.burden}</span></td>
																	</tr>
																	<tr>
																		<td><span>菜品类型:</span></td>
																		<td><span>${menu.typename}</span></td>
																	</tr>
																	<tr>
																		<td colspan="2" style="height: 40px;"><a href="ShoppingCarServlet?action=add&menuId=${menu.id }">加入餐车</a></td>
																		<td></td>
																	</tr>
																</table>
															</div>
            </div>
            
        </div>
        
        
        
        
        



												</div>

											</div>
										</div>

										<div id="dingcanall_bottom_left">&nbsp;</div>
										<div id="dingcanall_bottom_right">&nbsp;</div>
										<input type="hidden" name="picw" id="picw" value="150" /> <input
											type="hidden" name="pich" id="pich" value="140" /> <input
											type="hidden" name="fittype" id="fittype" value="auto" />
									</div>
									
									
									
									
									-->
								</div>
							</div>
							</div></td>
						<td width="41%" align="right" valign="top"><table width="243"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td></td>
								</tr>
								<tr>

								</tr>
								<tr>
									<td height="10">&nbsp;</td>
								</tr>
								<tr>
									<td valign="top">
										<div id='pdv_3614' class='pdv_class' title='我的餐车'
											style='width: 243px; top: 0px; left: 0px; z-index: 2'>
											<div id='spdv_3614' class='pdv_content'
												style='overflow: visible; width: 100%;'>
												<div class="pdv_border"
													style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
													<div
														style="height: 25px; margin: 1px; display: none; background:;">
														<div
															style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color:">
															我的餐车</div>
														
													</div>
													<div style="padding: 0px">
														<div id="dingcanche">
															<div id="dingcanche2">
																<div id="dingcanche_top">
																	<div id="dingcanche_top_left">我的餐车</div>
																	<div id="dingcanche_top_right">&nbsp;</div>
																</div>
																<div id="dcinfo" style="margin: 0px 3px 1px 3px;"></div>
																<table width="100%" border="0" cellspacing="0"
																	style="background: #fef0d3;">
																	<tr>
																		<td align="center">菜单名称</td>
																		<td align="center">单价</td>
																		<td align="center">数量</td>
																		<td align="center"></td>
																	</tr>

																	<c:forEach items="${carList }" var="carItem">
																		<tr>
																			<td align="center">${carItem.name }</td>
																			<td align="center">${carItem.price }</td>
																			<td align="center">${carItem.sums }</td>
																			<td align="center"><a
																				href="ShoppingCarServlet?action=removeOne&menuId=${carItem.menuId }">取消</a></td>
																		</tr>
																		<!-- 设置属性 var：代表属性名，value：属性值-->
																		<c:set var="totalSums" value="${carItem.sums+totalSums }"></c:set>
																		<c:set var="totalMoney" value="${carItem.price*carItem.sums+totalMoney}"></c:set>
																	</c:forEach>
						

																</table>
																<div style="height: 24px; margin: 5px 3px 1px 3px;">
																	<div
																		style="float: left; line-height: 24px; padding-left: 25px;">小&nbsp;&nbsp;计：</div>
																	<div
																		style="float: right; line-height: 24px; padding-right: 15px;">
																		<font id="allnums" style="color: #ff0000;">${totalSums}</font>份
																	</div>
																	<div
																		style="float: right; line-height: 24px; padding-right: 30px;">
																		<font id="cpprice" style="color: #ff0000;">${totalMoney }</font>元
																	</div>
																</div>
																<!-- 购物车中有数据，则以下部分（提交、清除）可见 -->
															 <c:if test="${!empty carList }">
																<div style="height: 30px; margin: 5px 3px 1px 3px;">
																	<table width="100%" border="0" cellspacing="0">
																		<tr>
																			<td align="center" width="40%"></td>
																			<td align="center" width="40%"><a
																				href="UserOrderServlet?action=addOrder"><img
																					src="qiantai/images/canche_submit.gif" border="0" /></a></td>
																			<td align="center" width="40%"><a
																				href="ShoppingCarServlet?action=removeAll"><img
																					src="qiantai/images/quxiao2.gif" border="0" /></a></td>
																		</tr>
																	</table>
																</div>
																
															 </c:if>
															</div>
														</div>
													</div>
													<div id="dingcanche_bottom_left">&nbsp;</div>
													<div id="dingcanche_bottom_right">&nbsp;</div>
													<input type="hidden" name="modnums_b" id="modnums_b"
														value="" />
													
												</div>
											</div>
										</div>
										</div>

									</td>
								</tr>
								<tr>
									<td height="10">&nbsp;</td>
								</tr>
								<tr>

								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="10">&nbsp;</td>
		</tr>
		<tr>
			<td height="50" align="center" valign="middle"><jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>

	</table>
</body>
${addmsg}
</html>
