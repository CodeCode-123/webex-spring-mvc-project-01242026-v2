package com.code.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.code.mvc.entity.Category;
import com.code.mvc.service.ICategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	private ICategoryService iCategoryService;
	
	@RequestMapping("/")
	public ModelAndView categoryRoot(Model model) {
		List<Category> categories = iCategoryService.getAll();
		model.addAttribute("categories", categories);
		return new ModelAndView("managecategory", "", model);
	}
	
	@RequestMapping("/add")
	public ModelAndView addCategory(Model model) {
		model.addAttribute("category", new Category());
		return new ModelAndView("addcategory", "", model);
	}
	
	@RequestMapping(value="/savecategory", method=RequestMethod.POST)
	public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
		iCategoryService.add(category);
		return new ModelAndView("redirect:/admin/category/");
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") int id, Model model) throws Exception {
		Category category = iCategoryService.getById(id);
		if (category == null) {
			throw new Exception("Not Found");
		}
		model.addAttribute("category", category);
		return new ModelAndView("editcategory", "", model);
	}
	
	@RequestMapping(value="/editcategory", method=RequestMethod.POST)
	public ModelAndView saveEditCategory(@ModelAttribute("category") Category category) {
		iCategoryService.update(category);
		return new ModelAndView("redirect:/admin/category/");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") int id) throws Exception {
		Category category = iCategoryService.getById(id);
		if (category == null) {
			throw new Exception("Not Found");
		}
		iCategoryService.delete(id);
		return new ModelAndView("redirect:/admin/category/");
	}
}
