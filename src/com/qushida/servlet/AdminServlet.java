package com.qushida.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.descriptor.web.LoginConfig;

import com.baishida.po.Admin;
import com.baishida.service.AdminService;
import com.baishida.service.MenuService;
import com.baishida.service.impl.AdminServiceImpl;
import com.baishida.service.impl.MenuServiceImpl;
import com.baishida.util.Page;
import com.sun.corba.se.spi.orbutil.fsm.Action;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	
	private AdminService adminService = new AdminServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//编码格式
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//获取前台的请求类型action
		String action = request.getParameter("action");
		switch(action){
		case "login":		//若action的值是login，则....
			login(request,response);
			break;
		case "logout":		//若action的值是logout，则....
			logout(request,response);
			break;
		case "updateAdmin":		//若action的值是logout，则....
			updateAdmin(request,response);
			break;
		default:
			break;
		
		}
	}

	private void updateAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		
		int i = adminService.updateAdmin(name, pwd, id1);
		
		if (i>0) {
			//更新成功
//			String updatemsg = "<script>alert('更新成功')</script>";
//			request.setAttribute("updatemsg", updatemsg);
			response.getWriter().write("<script>alert('更新成功'),window.parent.location.href='admin/index.jsp'</script>");

					
		}else{
			//更新失败
//			String updatemsg = "<script>alert('更新失败')</script>";
//			request.setAttribute("updatemsg", updatemsg);
			response.getWriter().write("<script>alert('更新失败'),window.parent.location.href='admin/index.jsp'</script>");

		}
		
	}

	//退出
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 移除session域中存放的当前用户的信息
		//获取session
		request.getSession().removeAttribute("admin");  //链式编程 XX.XX.XX
		//跳转到登陆页
		response.getWriter().write("<script>window.parent.location.href='admin/index.jsp'</script>");
		
	}


	//登陆
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//获取页面中的参数：用户名和密码
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		// 调用业务
		
		Admin admin = adminService.login(name, pwd);
		//对返回值admin进行判断，若不为null，则说明在数据库中存在此管理员，那么登陆成功，反正登录失败
		if(admin!=null){
			HttpSession session = request.getSession();
			
			//登陆成功  在主页面显示菜单信息
			
			MenuService menuService = new MenuServiceImpl();
			Page page = new Page();
			page.setCurPage(1);
			page.setPageNumber(3);
			Page pageCurrent = menuService.getMenuByPage(page);
			
			//把获取到得菜单首页放到session域中
			session.setAttribute("pageCurrent", pageCurrent);
			
			
			//把登陆成功后的管理员放到session域中
			
			session.setAttribute("admin", admin);//"名字"，值
			
			//重定向到登陆成功后的主页面
			response.sendRedirect(request.getContextPath()+"/admin/main.jsp");//抛出异常、
		}else{
			//设置响应的编码格式
			response.setContentType("text/html;charset=utf-8");
			//输出提示信息：输出一个alert（对话框）,并用windows.location.href="/index.jsp" 当前页面打开index页面
			response.getWriter().write("<script>alert('错误，请重新登录');window.location.href='admin/index.jsp'</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}









