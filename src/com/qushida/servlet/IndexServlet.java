package com.qushida.servlet;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baishida.po.Notice;
import com.baishida.service.MealService;
import com.baishida.service.MenuService;
import com.baishida.service.NoticeService;
import com.baishida.service.impl.MealServiceImpl;
import com.baishida.service.impl.MenuServiceImpl;
import com.baishida.service.impl.NoticeServiceImpl;
import com.baishida.util.Page;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {

	private MealService mealService = new MealServiceImpl();
	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式，响应类型
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//分页查询所有菜品
		
			//调用menuService中的方法getMenuByPage(Page page)
		
			
			//获取当前页
			String curPage = request.getParameter("pageIndex");
			if(curPage==null||"".equals(curPage)){
				curPage="1";
				
			}
			
			//获取一页几条
			String pageNumber = request.getParameter("pageNumber");
			if(pageNumber==null||"".equals(pageNumber)){
				pageNumber="6";
			}
			//构建Page
			Page page = new Page();
			page.setCurPage(Integer.parseInt(curPage));
			page.setPageNumber(Integer.parseInt(pageNumber));
			
			page = mealService.getMealByPage(page);

		//	response.sendRedirect(request.getContextPath()+"/qiantai/index.jsp");
		
//		//将数据设置到请求域request中
//
		request.setAttribute("page", page);
//		//请求转发到qiantai/index.jsp
		request.getRequestDispatcher("/qiantai/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}










