package com.hp.email;



import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/12/4 11:06
 */
@WebServlet(name = "SendEmail",value = "/SendEmail")
public class SendEmail extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             //收件人的电子邮件ID
		String to = "fanzhikang2004@163.com";
		// 发件人的电子邮件
		String from ="fanzhikang2004@126.com";
		//假设您是从本地主机发送电子邮件
		String host ="localhost";
		//获取系统属性
		Properties properties = System.getProperties();
		//设置邮件服务器
		properties.setProperty("mail.smtp.host",host);
		//获取默认的Session对象
		Session session =Session.getDefaultInstance(properties);
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
             //创建一个默认的MimeMessage对象
			MimeMessage message = new MimeMessage(session);
			//设置 From: header field of  the header
			message.setFrom(new InternetAddress(from));
			//设置 To: header field of the header
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			//设置 Subject: header field
			message.setSubject("This is the Subject line !");
			//现在设置实际消息
			message.setText("This is actual message");
			//发送消息
			Transport.send(message);
			String title = "发送电子邮件";
			String res = "成功发送消息。。。";
			String docType= "<!DOCTYPE html>\n";
			out.println(docType+
					"<html>\n"+
					"<head><title>"+title+"</title></head>\n"+
					"<body bgcolor=\"#f0f0f0\">\n"+
					"<h1 align=\"center\">"+title+"</h1>\n"+
					"<p align=\"center\">"+res+"</p>\n"+
					"</body></html>");

		}catch (MessagingException mex){
			mex.printStackTrace();
		}

	}
}
