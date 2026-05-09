package com.code.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.code.mvc.dto.UsersDto;
import com.code.mvc.entity.Users;
import com.code.mvc.service.IUsersService;

@Controller
@RequestMapping("/admin/users")
public class UsersController {
	//add dependency
	@Autowired
	private IUsersService iUsersService;
	
	@RequestMapping("/")
	public ModelAndView getRoot(Model model) {
		//get all the users
		List<Users> lstusers = iUsersService.getAll();
		//add attribute to the model
		model.addAttribute("lstusers", lstusers);
		return new ModelAndView("manageusers","",model);	
	}
	
	@RequestMapping("/registration")
	public ModelAndView getRegistration(Model model) {
		model.addAttribute("users", new Users());
		// return the view
		return new ModelAndView("registration1", "", model);
	}
	
	@RequestMapping(value="/save1", method=RequestMethod.POST)
	public ModelAndView save1Registration(@ModelAttribute("users") Users users,
			@RequestParam CommonsMultipartFile[] imagefile) {
		System.out.println(users.toString());
		if (imagefile != null && imagefile.length > 0) {
			for (CommonsMultipartFile fileup: imagefile) {
				//System.out.println("File Name: " + fileup.getOriginalFilename());
				//convert image to bytes
				users.setImagedata(fileup.getBytes());
			}
		}
		// set values to the model object
		users.setRole("Admin");
		//save the object
		iUsersService.addUser(users);
		// redirect to the dashboard
		return new ModelAndView("redirect:/admin/users/");
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView getEditRegistration(@PathVariable("id") int id, Model model) throws Exception {
		//get the users with the id
		Users users = iUsersService.getUserById(id);
		if (users == null) {
			throw new Exception("Not Found");
		}
		UsersDto usersDto = new UsersDto();
		//copy properties from users to usersDto, copy null values by default
		BeanUtils.copyProperties(users, usersDto);
		model.addAttribute("users", usersDto);
		return new ModelAndView("editregistration", "", model);
	}
	
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
	public ModelAndView saveEditRegistration(@ModelAttribute("users") UsersDto usersDto, 
			@RequestParam CommonsMultipartFile imagefile) throws Exception {
		int id = usersDto.getId();
		Users users = iUsersService.getUserById(id);
		if (users == null) {
			throw new Exception("Not Found");
		}
        //assume only upload one file/photo
		if (imagefile != null) {
			users.setImagedata(imagefile.getBytes());
		}
		//don't use BeanUtils.copyProperties() as the null values (email, password) will be copied by default
		users.setCountry(usersDto.getCountry());
		users.setFirstName(usersDto.getFirstName());
		users.setGender(usersDto.getGender());
		users.setLanguage(usersDto.getLanguage());
		users.setLastName(usersDto.getLastName());
		//save the updated users to the database
		iUsersService.updateUser(users);
		return new ModelAndView("redirect:/admin/users/");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteRegistration(@PathVariable("id") int id) throws Exception {
		//retrieve users from the database
		Users users = iUsersService.getUserById(id);
		//throw exception if the users is not found
		if (users == null) {
			throw new Exception("Not Found");
		}
		//delete the users and return the dashboard
		iUsersService.deleteUser(id);
		return new ModelAndView("redirect:/admin/users/");
	}
	
	//get the image
	@RequestMapping(value="/image/{id}")
	public void getImage(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
		Users users = iUsersService.getUserById(id);
		if (users != null && users.getImagedata() != null) {
			response.setContentType("image/jpeg");
			response.getOutputStream().write(users.getImagedata());
			response.getOutputStream().flush();
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}

	}
	
}
