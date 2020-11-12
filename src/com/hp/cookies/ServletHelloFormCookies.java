package com.hp.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/11/12 15:08
 */
@WebServlet(name = "ServletHelloFormCookies", value = "/hellocookies")
public class ServletHelloFormCookies extends HttpServlet {

	private static final long serialVersionUID = -6844764237324348411L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//为名字和姓氏创建cookie
		Cookie name = new Cookie("name", URLEncoder.encode(request.getParameter("name"), "UTF-8")); //中文转码
		Cookie url = new Cookie("url", request.getParameter("url"));
		// 为两个cookie 设置过期日期为24小时后
		response.addCookie(name);
		response.addCookie(url);
		//设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String title = "设置 Cookie 实例";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n" +
				"<ul>\n" +
				"  <li><b>站点名：</b>："
				+ URLDecoder.decode(request.getParameter("name"),"UTF-8") + "\n</li>" +
				"  <li><b>站点 URL：</b>："
				+ request.getParameter("url") + "\n</li>" +
				"</ul>\n" +
				"</body></html>");
	}

}
