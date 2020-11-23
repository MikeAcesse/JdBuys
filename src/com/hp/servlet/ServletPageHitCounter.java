package com.hp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/11/13 14:07
 */
@WebServlet(name = "ServletPageHitCounter",value="/PageHitCounter")
public class ServletPageHitCounter extends HttpServlet {
	private static final long serialVersionUID = 567762030577293290L;
	private int hitCount;

	@Override
	public void init() throws ServletException {
		//重置点击计数器
		hitCount  = 0;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doGet(request,response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //增加 hitCount
		hitCount++;
		PrintWriter out = response.getWriter();
		String title = "总点击量";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType+
		        "<html>\n"+
		        "<head><title>"+title+"</title></head>\n"+
		        "<body bgcolor=\"f0f0f0\">\n"+
		        "<h1 align=\"center\">"+title+"</h1>\n"+
		        "<h2 align=\"center\">"+hitCount+"</h2>\n"+
		        "</body></html>"
		        );
	}

	@Override
	public void destroy() {
		//这一步是可选的，但是如果需要，您可以把 hitCount 的值写入到数据库
	}
}
