package com.hp.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/11/10 16:02
 */
public class LogFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//获取初始化参数
		String site = filterConfig.getInitParameter("Site");
		//输出初始化参数
		System.out.println("网站名称： "+site);
	}

	@Override
	public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain chain) throws IOException, ServletException {
         //输出站点名称
		System.out.println("站点网址：http://www.runoob.com");
		//把请求传回过滤链
		chain.doFilter(Request,Response);
	}

	@Override
	public void destroy() {
		/**
		 * 在Filter实例被Web 容器从服务移除之前调用
		 */
	}
}
