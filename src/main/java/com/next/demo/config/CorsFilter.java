package com.next.demo.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class CorsFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Access-Control-Allow-Origin: 指定授权访问的域
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000"); // 此优先级高于@CrossOrigin配置

		// Access-Control-Allow-Methods: 授权请求的方法（GET, POST, PUT, DELETE，OPTIONS等)
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

		response.addHeader("Access-Control-Allow-Headers", "Content-Type");

		response.addHeader("Access-Control-Max-Age", "1800");// 30 min

		response.setHeader("Access-Control-Allow-Credentials", "true");
		String method = request.getMethod();
		String url = request.getRequestURI().substring(request.getContextPath().length());
		HttpSession session = request.getSession();
		Object object = session.getAttribute("user");
		String sessionId = request.getRequestedSessionId();
		if ("OPTIONS".equals(method) || url.indexOf("/login") != -1 || object != null) {
			filterChain.doFilter(request, response);
		} else {
			
		}
		filterChain.doFilter(request, response);
	}
}