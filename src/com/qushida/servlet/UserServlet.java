package com.qushida.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.baishida.po.User;
import com.baishida.service.UserService;
import com.baishida.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//编码格式
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		switch (action) {
		case "login":
			login(request,response);
			break;
		case "logout":
			logout(request,response);
			break;
		case "adduser":
			adduser(request,response);
			break;
		case "update":
			update(request,response);
			break;
		default:
			break;
		}
		
	
	
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String card = request.getParameter("card");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		String id = request.getParameter("id");
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setRealname(realname);
		user.setSex(sex);
		user.setAge(age);
		user.setCard(card);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setCode(code);
		user.setId(Integer.parseInt(id));
		int i = userService.update(user);
		if(i>0){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.getWriter().write("<script>alert('修改成功！');window.parent.location.href='qiantai/center.jsp'</script>");
		}else{
			response.getWriter().write("<script>alert('修改失败！');window.parent.location.href='qiantai/center.jsp'</script>");
		}
	}
	
	
	
	
	private void adduser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String card = request.getParameter("card");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		
		User user = new User(0, name, pwd, realname, sex, age, card, address, phone, email, code, null);
		
		int i = userService.addUser(user);
		
		if (i>0) {
			//response.getWriter().write("<script>alert('添加成功')</script>");
			//response.getWriter().write("<script>window.parent.location.href='qiantai/index.jsp'</script>");
			
			String addmsg = "<script>alert('添加成功')</script>";
			request.setAttribute("addmsg", addmsg);
			login(request, response);
					
		}else{
			
			String addmsg = "<script>alert('添加失败')</script>";
			request.setAttribute("addmsg", addmsg);
			login(request, response);
		}
		
		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("user");
		response.getWriter().write("<script>window.parent.location.href='qiantai/index.jsp'</script>");
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String name=request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		
		User user = userService.logn(name, pwd);
		
		if (user!=null) {
			HttpSession session = request.getSession();
			//把登陆成功后的用户放到session域中
			session.setAttribute("user",user);
			response.sendRedirect(request.getContextPath()+"/qiantai/index.jsp");
		}else{//设置响应的编码格式
			response.setContentType("text/html;charset=utf-8");
			//输出提示信息：输出一个alert（对话框）,并用windows.location.href="/login.jsp" 当前页面打开index页面
			response.getWriter().write("<script>alert('错误，请重新登录');window.location.href='qiantai/login.jsp'</script>");

			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
