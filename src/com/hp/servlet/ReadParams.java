package com.hp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/11/4 16:35
 */
@WebServlet("/ReadParams")
public class ReadParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title="读取所有表单参数";
		String docType =
				"<!doctype html public \"-//w3c//dtd html 4.0 " +
						"transitional//en\">\n";
		out.println(docType +
				"<html>\n" +
				"<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n" +
				"<table width=\"100%\" border=\"1\" align=\"center\">\n" +
				"<tr bgcolor=\"#949494\">\n" +
				"<th>参数名称</th><th>参数值</th>\n"+
				"</tr>\n");
		Enumeration paraNames = request.getParameterNames();
		while(paraNames.hasMoreElements()){
			String paramName = (String) paraNames.nextElement();
			out.print("<tr><td>"+paramName+"</td>\n");
            String[] paramValues = request.getParameterValues(paramName);
            //读取单个值的数据
			if(paramValues.length == 1){
				String paramValue = paramValues[0];
				if(paramValue.length() == 0){
					out.print("<td><i>没有值</i></td>");
				}else{
					out.println("<td>"+paramValue+"</td>");
				}
			}else{
				//读取多个值的数据
				out.println("<td><ul>");
				for (int i = 0; i < paramValues.length; i++) {
					out.println("<li>"+paramValues[i]);
				}
				out.println("</ul></td>");
			}
			out.print("</tr>");
		}
		out.println("\n</table>\n</body></html>");
	}
}
