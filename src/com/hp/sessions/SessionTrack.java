package com.hp.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
	}
}
