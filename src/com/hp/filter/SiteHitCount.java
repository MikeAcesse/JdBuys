package com.hp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/11/15 15:08
 */
@WebFilter(filterName = "SiteHitCount")
public class SiteHitCount implements Filter {
	private int hitCount;
	@Override
	public void destroy() {
		//这一步是可选的，但是如果需要，你可以把hitCount的值写入数据库
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       //把计数器的值增加1
		hitCount++;
		//输出计数器
		System.out.println("网站访问统计： "+hitCount);
		//把请求传回到过滤器链
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//重置点击计数器
		hitCount = 0;

	}

}
