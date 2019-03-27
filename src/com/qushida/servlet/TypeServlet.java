package com.qushida.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.el.sql.UpdateTag;

import com.baishida.po.Type;
import com.baishida.service.TypeService;
import com.baishida.service.impl.TypeServiceImpl;
import com.sun.xml.internal.bind.v2.runtime.Name;
import com.sun.xml.internal.ws.resources.AddressingMessages;

import jdk.nashorn.internal.ir.BreakableNode;

/**
 * Servlet implementation class TypeServlet
 */
public class TypeServlet extends HttpServlet {
	
	//调用业务层的方法(全局)
	private TypeService typeService = new TypeServiceImpl() ;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//获取具体请求
		String action = request.getParameter("action");
		switch(action) {
		case "getAllType":
			getAllType(request,response);
			break;
			
		case "addType":
			addType(request,response);
			break;
			
		case "selectById":
			selectById(request,response);
			break;
			
		case "update":
			update(request,response);
			break;
		case "deleteType":
			deleteType(request,response);
			break;
		case "forMenuAdd":
			forMenuAdd(request,response);
			break;
		case "forMenuUpdate":
			forMenuUpdate(request,response);
			break;
		default:
			break;
		}
	}
	//修改菜单时需用到类别
	private void forMenuUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有类别
		List<Type> typeList = typeService.getAllType();
		request.setAttribute("typeList", typeList);
		//转发到菜单添加页面
		request.getRequestDispatcher("admin/menus_update.jsp").forward(request, response);;
				
	}

	//添加菜单时需用到类别
	private void forMenuAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有类别
		List<Type> typeList = typeService.getAllType();
		request.setAttribute("typeList", typeList);
		//转发到菜单添加页面
		request.getRequestDispatcher("admin/menus_add.jsp").forward(request, response);;
		
	}


	//删除
	private void deleteType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		
		int i = typeService.deleteType(id1);
		
		if (i>0){
			String deletemsg = "<script>alert('删除成功')</script>";
			request.setAttribute("deletemsg", deletemsg);
			getAllType(request, response);
		}else{
			String deletemsg = "<script>alert('删除失败')</script>";
			request.setAttribute("deletemsg", deletemsg);
			getAllType(request, response);
		}
	}



	//更新
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取更新的数据
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		
		//把获取的数据放到对象里
		Type type = new Type(id1,name);
		
		//调用业务层方法
		int i = typeService.update(type);
		//对i进行判断
		if(i>0){
			//更新成功
			String updatemsg = "<script>alert('更新成功')</script>";
			request.setAttribute("updatemsg", updatemsg);
			getAllType(request, response);
			
		}else{
			//更新失败
			String updatemsg = "<script>alert('更新失败')</script>";
			request.setAttribute("updatemsg", updatemsg);
			getAllType(request, response);
		}
	}

	//根据ID查询
	private void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取待修改的类别id
		String id = request.getParameter("id");
		//把String型的id转换为int
		int id1 = Integer.parseInt(id);
		
		//调用service里的查询
		Type type = typeService.selectById(id1);
		
		//把type放到request中
		request.setAttribute("type", type);
		
		//转发到更新页面
		request.getRequestDispatcher("admin/type_update.jsp").forward(request, response);
		

		
	}

	//添加
	private void addType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用业务层的方法(使用全局)
		//获取页面的类别名称
		String name = request.getParameter("name");
		
		int i = typeService.addType(name);
		if (i>0){
			//添加成功
			String addmsg = "<script>alert('添加成功')</script>";
			request.setAttribute("addmsg", addmsg);
			
			getAllType(request, response);
		}else{
//设为doGet局部全局response.setContentType("text/html;charset=utf-8");
			//添加失败
			response.getWriter().write("<script>alert('添加失败，重新添加');window.location.href='admin/type_add.jsp'</script>");
		}
		
	}

	private void getAllType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//调用业务层的方法(局部)
//		TypeService typeService = new TypeServiceImpl() ;
		
		List<Type> list = typeService.getAllType();
		
		//把查询到的类别列表放到reuest域中
		request.setAttribute("typelist", list);//"名字"，值
		
		//转发到显示类别的页面type.jsp
		request.getRequestDispatcher("admin/type.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}














