package com.hp.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;
import java.sql.*;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/11/15 17:08
 */
@WebServlet(name = "AcesseDatabase",value ="/AccessDatabase")
public class AcesseDatabase extends HttpServlet {
	//JDBC 驱动名及数据库URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/testdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER ="root";
	static final String PASS = "123456";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn =null;
		Statement stmt =null;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "Servlet Mysql 测试 - 菜鸟教程";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n");
		try {
			//注册JDBC 驱动器
			Class.forName(JDBC_DRIVER);
			//打开一个连接
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			//执行SQL 查询
			stmt = conn.createStatement();
			String sql= "SELECT id, name, url FROM websites";
			ResultSet rs = stmt.executeQuery(sql);
			//展开结果集数据库
			while(rs.next()){
				//通过字段检索
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");
				//输出数据
				out.println("ID: "+id);
				out.println(",站点名称： "+name);
				out.println(",站点URL: "+url);
				out.println("<br/>");
			}
			out.println("</body></html>");
			//完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			//处理JDBC 错误
			e.printStackTrace();
		}catch(Exception e){
			//处理Class.forName错误
			e.printStackTrace();
		}finally {
			try{
				if(stmt!=null){
					stmt.close();}
			}catch(SQLException se2){
			}
			try{
				if(conn!=null){
					conn.close();}
			}catch(SQLException se){
				se.printStackTrace();
			}
		}

	}
}
