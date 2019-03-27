package com.qushida.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baishida.po.Notice;
import com.baishida.service.NoticeService;
import com.baishida.service.impl.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeServlet
 */
public class NoticeServlet extends HttpServlet {

    //调用业务层的方法
	private NoticeService noticeService = new NoticeServiceImpl();
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//获取具体请求
		String action = request.getParameter("action");
		switch(action) {
		case "getAllNotice":
			getAllNotice(request,response);
			break;
		case "deleteNotice":
			deleteNotice(request,response);
			break;
		case "addNotice":
			addNotice(request,response);
			break;
		case "selectNoticeById":
			selectNoticeById(request,response);
			break;
		default:
			break;
		}
		
	}
	
	//用户获取通告详情
	private void selectNoticeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id2 = request.getParameter("id");
		int id1 = Integer.parseInt(id2);
		
		Notice notices = noticeService.selectNoticeById(id1);
		
		request.setAttribute("notices", notices);
		request.getRequestDispatcher("qiantai/notice.jsp").forward(request, response);
		
		
	}

	//添加
	private void addNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取添加页面的通告name
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		//使用有参构造封装
		Notice notice = new Notice(0, name, content, null);
		int i = noticeService.addNotice2(notice);
		
		
//		//使用无参构造封装
//		Notice notice2 = new Notice();
//		notice2.setName(name);
//		notice2.setContent(content);
//		int i = noticeService.addNotice2(notice2);
		
		
//		//直接传参
//		int i = noticeService.addNotice(name, content);
		
		if(i>0){
			//添加成功
			String addmsg = "<script>alert('添加成功')</script>";
			request.setAttribute("addmsg", addmsg);
			
			getAllNotice(request, response);
		}else{
			//添加失败
			response.getWriter().write("<script>alert('添加失败，请重新添加');window.location.href='admin/notice_add.jsp'</script>");
		}
	}
				
		
		


	//删除
	private void deleteNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		
		int i = noticeService.deleteNotice(id1);
		
		if(i>0){
			
			String deletemsg= "<script>alert('删除成功')</script>";
			request.setAttribute("deletemsg", deletemsg);
			getAllNotice(request, response);
		}else{
			String deletemsg="<script>alert('删除失败')</script>";
			request.setAttribute("deletemsg", deletemsg);
			getAllNotice(request, response);
		}
		
	}


	//获取所有的通告
	private void getAllNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Notice> list = noticeService.getAllNotice();
		//把查询到的列表放到request域中
		request.setAttribute("noticelist", list);
		
		//转发到显示通告的页面notice.jsp
		request.getRequestDispatcher("admin/notice.jsp").forward(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
