package com.qushida.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baishida.po.Order;
import com.baishida.po.OrderCriteria;
import com.baishida.po.ShoppingCar;
import com.baishida.po.Type;
import com.baishida.po.User;
import com.baishida.service.OrderService;
import com.baishida.service.impl.OrderServiceImpl;
import com.baishida.util.Page;

public class UserOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService = new OrderServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取前台的请求类型
		String action = request.getParameter("action");
		switch (action) {
		case "addOrder":
			addOrder(request, response);
			break;
		case "queryOrderByPage":
			queryOrderByPage(request, response);
			break;
		
		default:
			break;
		}
	}

	

	protected void queryOrderByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// 获取参数信息
		HttpSession session = request.getSession();
		User user = (User) request.getSession().getAttribute("user");

		String menuName = request.getParameter("menuname");
		String date = request.getParameter("date");
	    String delivery = request.getParameter("delivery");
		// 构建查询条件的对象OrderCriteria
		OrderCriteria criteria = new OrderCriteria();
		if (user != null) {
			criteria.setUserId(user.getId());
			criteria.setMenuName(menuName);
			criteria.setDate(date);
			if (delivery!=null&&!"".equals(delivery)) {
				criteria.setDelivery(Integer.parseInt(delivery));
			}
			// 1.curPage
			String curPage = request.getParameter("curPage");
			if (curPage == null || "".equals(curPage)) {
				curPage = "1";
			}

			// 2.pageNumber
			String pageNumber = request.getParameter("pageNumber");
			if (pageNumber == null || "".equals(pageNumber)) {
				pageNumber = "3";
			}

			// Page-->curPage,pageNumber
			Page page = new Page();
			page.setCurPage(Integer.parseInt(curPage));
			page.setPageNumber(Integer.parseInt(pageNumber));

			// 调用OrderService-->queryOrderByPage(Page)
			Page pageCurrent = orderService.queryOrderByPage(page, criteria);
			System.out.println("?????????????????????????????"+pageCurrent.getData());
			request.setAttribute("pageCurrent", pageCurrent);
			request.setAttribute("criteria", criteria);

			// 请求转发到admin/order.jsp
			request.getRequestDispatcher("/qiantai/order.jsp").forward(request, response);
		} else {
			// 未登录
			out.write("<script>alert('登陆之后再来哦');window.location.href='qiantai/login.jsp'</script>");
		}

	}

	public void addOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		// 用户是否登陆
		User user = (User) session.getAttribute("user");
		if (user == null) {
			// 未登录
			out.write("<script>alert('登陆之后再来哦');window.location.href='qiantai/login.jsp'</script>");

		} else {
			// 已登录
			// 获取session中购物车的列表
			List<ShoppingCar> carList = (List<ShoppingCar>) session.getAttribute("carList");

			//
			int userId = user.getId();
			boolean result = orderService.addOrder(carList, String.valueOf(userId));
			if (result) {
				session.removeAttribute("carList");
				out.write("<script>alert('下单成功');window.location.href='qiantai/index.jsp'</script>");

			} else {
				out.write("<script>alert('下单失败');window.location.href='qiantai/index.jsp'</script>");

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
