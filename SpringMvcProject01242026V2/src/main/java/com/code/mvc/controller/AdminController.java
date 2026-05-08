package com.code.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.code.mvc.entity.Users;
import com.code.mvc.service.IUsersService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	IUsersService iUsersService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("redirect:/admin/users/");
	}
	
	@RequestMapping("/login")
	public ModelAndView getLogin() {
		return new ModelAndView("adminlogin");
	}
	
	@RequestMapping(value="/authentication", method=RequestMethod.POST)
	public ModelAndView authenticationLogin(HttpServletRequest request, Model model, HttpSession session) {
		String username = request.getParameter("uname");
		String password = request.getParameter("upass");
		Users users = iUsersService.getUserAuthentication(username, password);
		if (users != null) {
			if (users.getRole().equals("Admin")) {
				//create the session object, and set attribute of adminusers
				session.setAttribute("adminusers", users);
				return new ModelAndView("redirect:/admin/");
			}
		}
		String msg = "Invalid Username or Password";
		model.addAttribute("errmsg", msg);
		return new ModelAndView("adminlogin", "", model);
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		//invalidate session and return login page
		session.invalidate();
		return new ModelAndView("redirect:/admin/login");
	}
}
