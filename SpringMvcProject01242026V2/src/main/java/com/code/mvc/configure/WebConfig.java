package com.code.mvc.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.code.mvc.component.AdminInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("error");
		registry.addInterceptor(adminInterceptor);
		    
		// already defined in the AdminInterceptor, do not repeat to define
//		        .addPathPatterns("/admin/**")
//		        .excludePathPatterns(
//		        		"/admin/login",
//		        		"/admin/login/",
//		        		"/admin/authentication",
//		        		"/admin/logout",
//		        		"/css/**", "/js/**", "/images/**");
	}

}
