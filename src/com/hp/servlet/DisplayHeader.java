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
 * @date 2020/11/6 11:15
 */
@WebServlet(name = "DisplayHeader ",value = "/DisplayHeader")
public class DisplayHeader extends HttpServlet {
	//处理POST方法请求的方法
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "HTTP Header 请求实例";
		String docType="<!DOCTYPE html> \n";
		   out.println(docType+
			   "<html>\n"+
				   "<head><meta charset=\"utf-8\"><title>"+title+"</title></head>\n"+
				   "<body bgcolor=\"#f0f0f0\">\n"+
				   "<h1 align=\"center\">"+title+"</h1>\n"+
				   "<table width=\"100%\" border=\"1\" align = \"center\">\n"+
				   "<tr bgcolor=\"#949494\">\n"+
				   "<th>Header 名称</th><th>Head 值</th>\n"+
				   "</tr>\n");
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()){
          String paramName = (String) headerNames.nextElement();
          out.print("<tr><td>"+paramName+"</td>\n");
          String paramValue = request.getHeader(paramName);
          out.print("<td> "+paramValue+" </td></tr>\n");
		}
		out.println("</table>\n</body></html>");


	}
}
