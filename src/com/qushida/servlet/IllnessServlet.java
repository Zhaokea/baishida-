package com.qushida.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baishida.po.Meal;
import com.baishida.po.Notice;
import com.baishida.po.Type;
import com.baishida.service.MealService;
import com.baishida.service.MenuService;
import com.baishida.service.impl.MealServiceImpl;
import com.baishida.service.impl.MenuServiceImpl;
import com.baishida.util.Page;

/**
 * Servlet implementation class IllnessServlet
 */
public class IllnessServlet extends HttpServlet {

	private MealService mealService = new MealServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//获取具体请求
		String action = request.getParameter("action");
		switch(action) {
		case "searchByFname":
			searchByFname(request,response);
			break;
		case "selectById":
			selectById(request,response);			
			break;
		default:
			break;
		}
	
	
	}


	
	
	
	
	private void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		
		Meal meal = mealService.selectById(id1);
		request.setAttribute("meal", meal);
		//转发到菜单添加页面
		request.getRequestDispatcher("qiantai/meal.jsp").forward(request, response);
	
	}






	private void searchByFname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
				
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
				
				
				String fname = request.getParameter("fname");
				
				
				Page fnamepage = mealService.getMealByPageFname(page,fname);
				
				
				int fname1 = Integer.parseInt(fname);
				HttpSession session = request.getSession();
				session.setAttribute("fname1",fname1);
			//将数据设置到请求域request中

			request.setAttribute("fnamepage", fnamepage);
			//请求转发到qiantai/index.jsp
			request.getRequestDispatcher("/qiantai/index.jsp").forward(request, response);
	}






	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
