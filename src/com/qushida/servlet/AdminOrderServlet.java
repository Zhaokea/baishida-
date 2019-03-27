package com.qushida.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baishida.po.OrderCriteria;
import com.baishida.service.OrderService;
import com.baishida.service.impl.OrderServiceImpl;
import com.baishida.util.Page;
import com.baishida.vo.OrderInfo;


/**
 * Servlet implementation class OrderServlet
 */
public class AdminOrderServlet extends HttpServlet {

	private OrderService orderService = new OrderServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		//自动调用名称为action的方法且参数为HttpServletRequest, HttpServletResponse
		
		try {
			Method method = getClass().getDeclaredMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			//Method method = getClass().getDeclaredMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		//	method.invoke(this, request,response);
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
		
		//上述方法代替以下switch语句
//		switch (action) {
//		case "getAllOrderByPage":
//			getAllOrderByPage(request,response);
//			break;
//		case "deleteOrder":
//			deleteOrder(request,response);
//			break;
//		case "updateOrder":
//			updateOrder(request,response);
//			break;
//		case "queryOrderByPage":
//			queryOrderByPage(request,response);
//			break;
//		default:
//			break;
//		}
		
		
	}


	//分页查询订单
	protected  void getAllOrderByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//声明分页所需变量:curPage,pageNumber
		
		String curPage = request.getParameter("curPage");
		if (curPage==null||"".equals(curPage)){
			curPage = "1";
		}
		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber==null||"".equals(pageNumber)){
			pageNumber = "3";
		}
		
		Page page = new Page();
		page.setCurPage(Integer.parseInt(curPage));
		page.setPageNumber(Integer.parseInt(pageNumber));
		
		Page pageCurrent = orderService.queryOrderByPage(page,null);
		request.setAttribute("pageCurrent", pageCurrent);
		request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
		
	}

	
	//取消订单
		protected void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//获取订单id
			String orderId = request.getParameter("orderId");
			//调用方法
			boolean updateRes = orderService.deleteOrderById(Integer.parseInt(orderId));
			String deleteMsg = "<script>alert('取消成功')</script>";
			if (updateRes) {
				//配送成功
				deleteMsg = "<script>alert('取消成功')</script>";
			}
		//设置到request域中
			request.setAttribute("deleteMsg", deleteMsg);
			getAllOrderByPage(request, response);
			
		}
		
		//修改订单
		protected void updateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//获取订单id
			String orderId = request.getParameter("orderId");
			//调用方法
			boolean updateRes = orderService.updateOrderById(Integer.parseInt(orderId));
			String updateMsg = "<script>alert('修改成功')</script>";
			if (updateRes) {
				//配送成功
				updateMsg = "<script>alert('修改成功')</script>";
			}
		//设置到request域中
			request.setAttribute("updateMsg", updateMsg);
			getAllOrderByPage(request, response);
			
		}

	
	//根据条件分页查询订单
	private void queryOrderByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取查询信息
				String userId = request.getParameter("userid");
				String menuName = request.getParameter("menuname");
				String date = request.getParameter("date");
				
				//构建查询条件的对象OrderCriteria
				
				OrderCriteria criteria = new OrderCriteria();
				if(userId!=null&&!"".equals(userId.trim())){
					criteria.setUserId(Integer.parseInt(userId));
				}
				criteria.setMenuName(menuName);
				criteria.setDate(date);
				
				// 1.curPage
				String curPage = request.getParameter("curPage");
				if (curPage == null || "".equals(curPage)) {
					curPage = "1";
				}
				// 2.pageNumber
				String pageNumber = request.getParameter("pageNumber");
				if (pageNumber == null || "".equals(pageNumber)) {
					pageNumber = "1";
				}
				
				// Page->curPage,pageNumber
				Page page = new Page();
				page.setCurPage(Integer.parseInt(curPage));
				page.setPageNumber(Integer.parseInt(pageNumber));
				// 调用OrderService-》queryOrderByPage(Page)
				Page pageCurrent = orderService.queryOrderByPage(page,criteria);

				request.setAttribute("pageCurrent", pageCurrent);
				request.setAttribute("criteria", criteria);
				// 请求转发到admin/order.jsp
				request.getRequestDispatcher("/admin/order_search.jsp").forward(request, response);
		
	}	
	
	//本日销售额统计
	protected void sumOrderByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//声明分页所需变量:curPage,pageNumber
		
				String curPage = request.getParameter("curPage");
				if (curPage==null||"".equals(curPage)){
					curPage = "1";
				}
				String pageNumber = request.getParameter("pageNumber");
				if (pageNumber==null||"".equals(pageNumber)){
					pageNumber = "3";
				}
				
				Page page = new Page();
				page.setCurPage(Integer.parseInt(curPage));
				page.setPageNumber(Integer.parseInt(pageNumber));
				
				Page orderByPage = orderService.sumOrderByPage(page);
				request.setAttribute("orderByPage", orderByPage);
				request.getRequestDispatcher("/admin/order_statistic.jsp").forward(request, response);
				
				
//		OrderInfo orderByPage = orderService.sumOrderByPage();
//		request.setAttribute("orderByPage", orderByPage);
//		
//		request.getRequestDispatcher("admin/order_statistic.jsp").forward(request, response);
//		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}













