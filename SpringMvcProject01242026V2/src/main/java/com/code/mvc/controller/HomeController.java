package com.code.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	@RequestMapping(value="/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	@RequestMapping("/authentication")
	public ModelAndView loginAuthentication(HttpServletRequest request, Model model) {
		//request has method getParameter(<name of form element> returns the value as string)
		String username=request.getParameter("uname");
		String password=request.getParameter("upass");
		System.out.println("User Name: " + username);
		System.out.println("Password: " + password);
		//check user is admin password is 1234
		if (username.equals("Admin") && password.equals("1234")) {
			model.addAttribute("uname", username);
			return new ModelAndView("dashboard", "", model);
		}
		String msg = "Invalid User name & Password";
		model.addAttribute("errmsg", msg);
		return new ModelAndView("login", "", model);
	}
}
