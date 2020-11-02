package com.hp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/11/2 9:17
 */
public class HelloWorld extends HttpServlet {
	private String message;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应内容类型
		response.setContentType("text/html");
		//实际的逻辑是在这里
		PrintWriter out = response.getWriter();
		out.println("<h1>"+message+"</h1>");
		out.println("<div>"+"wangtao wo shi chengxuyuan"+"</div>");
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		message = "Hello Fanzhikang!";
	}
}
