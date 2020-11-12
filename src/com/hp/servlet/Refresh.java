package com.hp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/11/6 9:35
 */
@WebServlet(name = "Refresh",value = "/Refresh")
public class Refresh extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //设置刷新自动加载时间为5秒
		response.setIntHeader("Refresh",5);
		//设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");

		//使用默认时区和语言环境获取一个日历
		Calendar cale = Calendar.getInstance();
		//将Calendar 类型转换成Date类型
		Date tasktime = cale.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = df.format(tasktime);
		PrintWriter out = response.getWriter();
		String title = "自动刷新Header 设置";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n"+
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n" +
				"<p>当前时间是：" + nowTime + "</p>\n"+
		         "</body></html>\n");
	}
}
