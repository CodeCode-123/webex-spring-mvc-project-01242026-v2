package com.code.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.code.mvc.entity.Users;
import com.code.mvc.service.IUserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	//add dependency
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping("/")
	public ModelAndView getRoot(Model model) {
		//get all the users
		List<Users> lstusers = iUserService.getAll();
		//add attribute to the model
		model.addAttribute("lstusers", lstusers);
		return new ModelAndView("dashboard","",model);	
	}
	
	@RequestMapping("/registration")
	public ModelAndView getRegistration(Model model) {
		model.addAttribute("users", new Users());
		// return the view
		return new ModelAndView("registration2", "", model);
	}
	
	@RequestMapping(value="/save1", method=RequestMethod.POST)
	public ModelAndView save1Registration(@ModelAttribute("users") Users users, Model model) {
		System.out.println(users.toString());
		// set values to the model object
		users.setRole("Admin");
		model.addAttribute("users", users);
		//save the object
		iUserService.addUser(users);
		// redirect to the dashboard
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveRegistration(HttpServletRequest request, Model model) {
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		String country = request.getParameter("country");
		String gender = request.getParameter("gender");
		List<String> langs = new ArrayList<>();
		if (request.getParameter("lang1") != null) {
			langs.add(request.getParameter("lang1"));
		}
		if (request.getParameter("lang2") != null) {
			langs.add(request.getParameter("lang2"));
		}
		if (request.getParameter("lang3") != null) {
			langs.add(request.getParameter("lang3"));
		}
		String languages = "";
		if (langs.size() > 0) {
			languages = String.join(",", langs);
		}
		String emailId = request.getParameter("email-id");
		String password = request.getParameter("password");
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Country: " + country);
		System.out.println("Gender: " + gender);
		System.out.println("Languages: " + languages);
		// set values to the model object
		model.addAttribute("name", firstName+" "+lastName);
		model.addAttribute("country", country);
		// return the view
		return new ModelAndView("confirm","",model);
	}

}
