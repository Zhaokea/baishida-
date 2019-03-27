package com.qushida.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

import com.baishida.po.Meal;
import com.baishida.po.Menu;
import com.baishida.po.ShoppingCar;
import com.baishida.service.MealService;
import com.baishida.service.MenuService;
import com.baishida.service.impl.MealServiceImpl;
import com.baishida.service.impl.MenuServiceImpl;

/**
 * Servlet implementation class ShoppingCarServlet
 */
public class ShoppingCarServlet extends HttpServlet {

	private MealService mealService = new MealServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		switch (action) {
		case "add":
			add(request,response);
			break;
		case "removeAll":
			removeAll(request,response);
			break;
		case "removeOne":
			removeOne(request,response);
			break;
		default:
			break;
		}

		
	}
	


	//添加
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session中获取购物车信息
		HttpSession session = request.getSession();
		
		List<ShoppingCar> carList = (List<ShoppingCar>) session.getAttribute("carList");

		//数据存到session中
		//数据格式:list<?>
		//获取要加入的商品的信息->构建成shoppingcar的一个对象，-》mealId，name，price，num
		
		//id
		int mealId = Integer.parseInt(request.getParameter("mealId"));
		boolean flag = true;
		
		if (carList==null) {
			//无购物
			carList = new ArrayList<>();
		
		}else{
			//遍历购物车-》得到购物车的每个条目，若条目的菜品Id为将添加的菜品mealId，则数目加一
			for(ShoppingCar carItem:carList){
				//购物车中存在此商品
				//carItem
				if (carItem.getMealId()==mealId) {
					int sums = carItem.getSums();
					carItem.setSums(sums+1);
					flag=false;
					break;
				}
			}
		}
		
		
		if(flag){
		//调用menuSercice中select方法得到此菜品所有信息
		Meal meal = mealService.selectById(mealId);
		//菜名
		String name = meal.getName();
		//价格
		String price = meal.getPrice();
		//构建一个条目信息(调用构造函数)
		ShoppingCar shoppingCar = new ShoppingCar(mealId, name, Float.parseFloat(price), 1);
		
		carList.add(shoppingCar);

		}

		//把新的数据设置到session中
		session.setAttribute("carList", carList);
		request.getRequestDispatcher("/qiantai/index.jsp").forward(request, response);
		
	}

	//删除一条
	private void removeOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//获取来源--from
		String from = request.getParameter("from");
		
		String path =request.getContextPath()+"/qiantai/index.jsp";//将来要重定向的路径
		
		if (from!=null) {
			path =request.getContextPath()+"/qiantai/shoppingcar.jsp";//将来要重定向的路径
			
		}
		//得到要删除条目的id
		int  mealId = Integer.parseInt(request.getParameter("mealId"));
		
		//获取session
		HttpSession session = request.getSession();
		
		//从session中获取购物车信息
		List<ShoppingCar> carList = (List<ShoppingCar>)session.getAttribute("carList");
		
		//遍历购物信息，根据商品id找到要删除的条目
		for(ShoppingCar carItem:carList){
			//由条目carItem得到条目id
			if (mealId==carItem.getMealId()) {
				//当前条目为要删除的
				carList.remove(carItem);
				break;
			}
		}
		
		//将新的购物车设置到新的session域中

		response.sendRedirect(path);
	}
	
	
	
	//清空
	private void removeAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//得到session
		HttpSession session = request.getSession();
		//移除session中的carList
		session.removeAttribute("carList");
		
		response.sendRedirect(request.getContextPath()+"/qiantai/index.jsp");
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
















