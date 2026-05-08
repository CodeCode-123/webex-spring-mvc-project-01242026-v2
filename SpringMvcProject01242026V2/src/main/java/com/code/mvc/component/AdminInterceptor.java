package com.code.mvc.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, 
			                 HttpServletResponse response, 
			                 Object handler) throws Exception {
		String uri = request.getRequestURI();                //e.g. /SpringMvcProject01242026V2/admin/category
		String contextPath = request.getContextPath();       //e.g. /SpringMvcProject01242026V2
		String path = uri.substring(contextPath.length());   //e.g. /admin/category
		System.out.println("REQUEST URI: " + uri + " | PATH: " + path);
		// 1) If it's NOT under /admin, let it pass (this fixes / and any public URLs)
		if (!path.startsWith("/admin")) {
			return true;
		}
		// 2) Allow login/auth URLs to pass without session check
		if (path.equals("/admin/login") ||
			path.equals("/admin/login/") ||
			path.equals("/admin/authentication") ||
			path.equals("/admin/users/registration") ||
			path.equals("/admin/logout")) {
			return true;
		}
		// 3) Now check admin session
		//request.getSession(false); retrieve an existing HttpSession 
		//without automatically creating a new one
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("adminusers") != null) {
			return true;
		}
		// 4) Not logged in -> redirect to admin login
		response.sendRedirect(contextPath + "/admin/login");
		return false;	
	}

}
