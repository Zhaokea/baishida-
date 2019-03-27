package com.qushida.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baishida.dao.MenuDao;
import com.baishida.po.Meal;
import com.baishida.po.Menu;
import com.baishida.po.Type;
import com.baishida.service.MealService;
import com.baishida.service.MenuService;
import com.baishida.service.NoticeService;
import com.baishida.service.TypeService;
import com.baishida.service.impl.MealServiceImpl;
import com.baishida.service.impl.MenuServiceImpl;
import com.baishida.service.impl.NoticeServiceImpl;
import com.baishida.service.impl.TypeServiceImpl;
import com.baishida.util.Page;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.sun.corba.se.spi.orbutil.fsm.Action;

/**
 * Servlet implementation class MenuServlet
 */
public class MenuServlet extends HttpServlet {


	//调用业务层的方法
	private MenuService menuService = new MenuServiceImpl();
	private TypeService typeService = new TypeServiceImpl();
	private MealService mealService = new MealServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		switch (action) {
		case "getMenuByPage":
			getMenuByPage(request,response);			
			break;
		case "addMenu":
			addMenu(request,response);			
			break;
		case "deleteMenu":
			deleteMenu(request,response);			
			break;
		case "selectById":
			selectById(request,response);			
			break;
		case "update":
			update(request,response);			
			break;
		default:
			break;
		}
	}


	
	
	//修改
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取更新的数据
		//获取其他信息
		String name = request.getParameter("name");
		String fname = request.getParameter("typeid");
		String burden = request.getParameter("burden");
		String make = request.getParameter("brief");
		String price = request.getParameter("price");
		
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		//封装到menu对象;
		Meal meal= new Meal(id1, name, null, price, burden, make, fname, null);

		//调用业务层方法
		int i = menuService.update(meal);
		//对i进行判断
		if(i>0){
			//更新成功
			String updatemsg = "<script>alert('更新成功')</script>";
			request.setAttribute("updatemsg", updatemsg);
			getMenuByPage(request, response);
					
		}else{
			//更新失败
			String updatemsg = "<script>alert('更新失败')</script>";
			request.setAttribute("updatemsg", updatemsg);
			getMenuByPage(request, response);
		}
		
	}


	private void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		
		Meal meal = mealService.selectById(id1);
		request.setAttribute("menu", meal);
		
		//获取所有类别
		List<Type> typeList = typeService.getAllType();
		request.setAttribute("typeList", typeList);
		
		//转发到菜单添加页面
		request.getRequestDispatcher("admin/menus_update.jsp").forward(request, response);
	
	}


	//删除
	private void deleteMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		
		int i = menuService.deleteMenu(id1);
		if (i>0) {
			String deletemsg="<script>alert('删除成功')</script>";
			request.setAttribute("deletemsg", deletemsg);
			getMenuByPage(request, response);
		}else{
			response.getWriter().write("<script>alert('删除失败');window.location.href='admin/menus.jsp'</script>");
		}
		
	}

	//添加
	private void addMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//借助SmartUplosd工具类完成图片的上传
		
		//1.创建SmartUplosd对象
		SmartUpload smartUpload = new SmartUpload();
		//1.调用初始化方法完成初始化
		try {
			smartUpload.initialize(getServletConfig(), request, response);
			//3.上传的准备
			smartUpload.upload();
			//4.获取上传的文件及文件名（！！！！！！！！！！！）
			SmartFile file = smartUpload.getFiles().getFile(0);//获取下标为0的文件
			String fileName = file.getFileName();
			String imgpath = "img/"+fileName;
			
			//获取其他信息
			String name = smartUpload.getRequest().getParameter("name");
			String typeid = smartUpload.getRequest().getParameter("typeid");
			String burden = smartUpload.getRequest().getParameter("burden");
			String make = smartUpload.getRequest().getParameter("make");
			String price = smartUpload.getRequest().getParameter("price");
			
			
			//封装到menu对象
			//Menu menu = new Menu(0, name, typeid, burden, brief, price, null, price1, null, imgpath);
			Meal meal = new Meal(0, name, imgpath, price, burden, make, typeid, null);	
	        int i = mealService.addMeal(meal);
		
		if (i>0) {
			//将文件保存到指定目录下
			smartUpload.save("/img");
			
			
			String addmsg="<script>alert('添加成功')</script>";
			request.setAttribute("addmsg", addmsg);
			getMenuByPage(request, response);
			
		}else{
			response.getWriter().write("<script>alert('添加失败，请重新添加');window.location.href='TypeServlet?action=forMenuAdd'</script>");
//			String addmsg="<script>alert('添加失败，请重新添加')</script>";
//			request.setAttribute("addmsg", addmsg);
//			getMenuByPage(request, response);
		}
		} catch (Exception e) {//扩大捕捉的异常范围：ServletException——》Exception
			e.printStackTrace();
		}
		

	}


	private void getMenuByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//声明分页所需变量
		int curPage1 = 0;
		int pageNumber1 = 0;
		
		
		//获取分页所需数据
		String curPage = request.getParameter("curPage");//当前页
		String pageNumber = request.getParameter("pageNumber");//每页条数
		
		//对curPage进行判断：若为null，则为第一页，反之为curpage页
		if(curPage == null){
			curPage1 = 1;			
		}else {
			curPage1 = Integer.parseInt(curPage);
		}
		if(pageNumber == null){
			pageNumber1 = 4;//赋值几都可以
		}else {
			pageNumber1 = Integer.parseInt(pageNumber);
		}
		
		//将当前页和每页条数封装到怕page对象中
		Page page = new Page();
		page.setCurPage(curPage1);
		page.setPageNumber(pageNumber1);
		
		
		//创建service层对象
		MealService mealService = new MealServiceImpl();
		//调用方法
		Page pageCurrent = mealService.getMealByPage(page);
		//把从数据库查询到的数据放到reuest域中
		request.setAttribute("pageCurrent", pageCurrent);
		//转发到menus.jsp
		request.getRequestDispatcher("admin/menus.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

























