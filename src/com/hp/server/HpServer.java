package com.hp.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/9/22 9:34
 */
public class HpServer {
	public static void main(String[] args)  {
		try {
			ServerSocket server = new ServerSocket(8888);
			Socket client =server.accept();
			System.out.println("访问开始了");
			OutputStream outputStream = client.getOutputStream();
			InputStream inputStream = new FileInputStream("E:\\idea-workspace\\JdBuys\\web\\index.html");
			int len =0;
			byte[] bytes=new byte[1024];
			while((len = inputStream.read(bytes))!=-1){
				outputStream.write(bytes,0,len);
				outputStream.flush();
			}
			System.out.println("服务器结束了");
			inputStream.close();
			outputStream.close();
			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {

		}
	}
}
