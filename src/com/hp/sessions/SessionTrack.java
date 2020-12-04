package com.hp.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/11/16 10:40
 */
@WebServlet(name = "SessionTrack",value = "/SessionTrack")
public class SessionTrack extends HttpServlet {

	private static final long serialVersionUID = -7333084806451991320L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request,response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //如果不存在session 会话，则创建一个session 对象
		HttpSession session = request.getSession();
		//获取 session 创建时间
		Date createTime = new Date(session.getCreationTime());
		//获取该网页的最后一个次访问时间
		Date lastAccessTime = new Date(session.getLastAccessedTime());

		//设置日期输出的格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String title = "Servlet session 实例 - 菜鸟教程";
		Integer visitCount = new Integer(0);
		String visitCountKey = new String("visitCount");
		String userIDKey = new String("userID");
		String userID = new String("fzk");
		if(session.getAttribute(visitCountKey) == null){
			session.setAttribute(visitCountKey,new Integer(0));
		}
        // 检查网页上是否有新的访问者
		if(session.isNew()){
			title = "Servlet Session 实例 - 菜鸟教程";
			session.setAttribute(userIDKey,userID);
		}else{
			visitCount = (Integer) session.getAttribute(visitCountKey);
			visitCount++;
			userID =(String) session.getAttribute(userIDKey);
		}
		session.setAttribute(visitCountKey,visitCount);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String docType = "<!DOCTYPE html>\n";
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n" +
				"<h2 align=\"center\">Session 信息</h2>\n" +
				"<table border=\"1\" align=\"center\">\n" +
				"<tr bgcolor=\"#949494\">\n" +
				"  <th>Session 信息</th><th>值</th></tr>\n" +
				"<tr>\n" +
				"  <td>id</td>\n" +
				"  <td>" + session.getId() + "</td></tr>\n" +
				"<tr>\n" +
				"  <td>创建时间</td>\n" +
				"  <td>" +  df.format(createTime) +
				"  </td></tr>\n" +
				"<tr>\n" +
				"  <td>最后访问时间</td>\n" +
				"  <td>" + df.format(lastAccessTime) +
				"  </td></tr>\n" +
				"<tr>\n" +
				"  <td>用户 ID</td>\n" +
				"  <td>" + userID +
				"  </td></tr>\n" +
				"<tr>\n" +
				"  <td>访问统计：</td>\n" +
				"  <td>" + visitCount + "</td></tr>\n" +
				"</table>\n" +
				"</body></html>");

	}
}
