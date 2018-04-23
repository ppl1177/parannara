package com.parannara.ProjectWeb2.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("sessionId");
		
		if (sessionId == null) {
			String path = request.getContextPath();
			response.sendRedirect(path+"/login");
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
}
