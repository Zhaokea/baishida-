package com.qushida.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baishida.po.Advice;
import com.baishida.po.Notice;
import com.baishida.service.AdviceService;
import com.baishida.service.impl.AdviceServiceImpl;


public class AdviceServlet extends HttpServlet {
	private AdviceService adviceService=new AdviceServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		switch (action) {
		case "selectAdviceById":
			selectAdviceById(request,response);
			break;

		default:
			break;
		}
	}

	private void selectAdviceById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		if (id!=null&&!"".equals(id)) {
		int id1 = Integer.parseInt(id);
		//调用service里面的查询
		Advice advice = adviceService.selectAdviceById(id1);
		//把type放入request域
		request.setAttribute("advice", advice);
		//转发到更新页面
		request.getRequestDispatcher("qiantai/advice.jsp").forward(request, response);}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
