package com.code.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.code.mvc.entity.Category;
import com.code.mvc.entity.Item;
import com.code.mvc.service.ICategoryService;
import com.code.mvc.service.IItemService;

@Controller
@RequestMapping("/admin/item")
public class ItemController {
	@Autowired
	private IItemService iItemService;
	@Autowired
	private ICategoryService iCategoryService;
	
	//root mapping
	@RequestMapping("/")
	public ModelAndView getRoot(Model model) {
		//retrieve all items from the database
		List<Item> items = iItemService.getAll();
		//add attribute to the model and return
		model.addAttribute("items", items);
		return new ModelAndView("manageproduct", "", model);
	}
	
	@RequestMapping("/add")
	public ModelAndView addItem(Model model) {
		//retrieve all categories from the database
		List<Category> categories = iCategoryService.getAll();
		//add attributes of categories and item, return
		model.addAttribute("categories", categories);
		model.addAttribute("item", new Item());
		return new ModelAndView("addproduct", "", model);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveItem(@ModelAttribute("item") Item item,
			@RequestParam("photo") CommonsMultipartFile photo, Model model) throws Exception {
		try {
			//if photo is not null, item setImagedata to be photo
			//assume only upload one file/photo
			if (photo != null) {
				item.setImagedata(photo.getBytes());
			}
			//add or update item to the database
			if (item.getItemId() == 0) {
				iItemService.add(item);
			} else {
				iItemService.update(item);
			}
		} catch(Exception ex) {
			model.addAttribute("errmsg", ex.getMessage());
			return new ModelAndView("error", "", model);
		}
		//return the view
		return new ModelAndView("redirect:/admin/item/");
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView getEditItem(@PathVariable("id") int id, Model model) throws Exception {
		//retrieve all categories from the database, and add attribute to the model
		List<Category> categories = iCategoryService.getAll();
		model.addAttribute("categories", categories);
		//retrieve item by id
		Item item = iItemService.getById(id);
		if (item == null) {
			throw new Exception("Not Found");
		}
		//add attributes to the model and return
		//model.addAttribute("category", item.getCategory());
		model.addAttribute("item", item);
		return new ModelAndView("editproduct", "", model);
	}
	
	@RequestMapping(value="/editproduct", method=RequestMethod.POST)
	public ModelAndView saveEditItem(@ModelAttribute("item") Item item, 
			@RequestParam("photo") CommonsMultipartFile[] photo, Model model) {
		try {
			//if photo is not null, item set Imagedata to be photo
			if(photo != null && photo.length > 0) {
				for (CommonsMultipartFile fileup: photo) {
					item.setImagedata(fileup.getBytes());
				}
			}
			//add or update item
			if(item.getItemId() == 0) {
				iItemService.add(item);
			} else {
				iItemService.update(item);
			}
		} catch(Exception ex) {
		    model.addAttribute("errmsg", ex.getMessage());
		    return new ModelAndView("error", "", model);
		}
		//return redirect to view
		return new ModelAndView("redirect:/admin/item/");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteItem(@PathVariable("id") int id) throws Exception {
		//retrieve item from the database by id
		Item item = iItemService.getById(id);
		//if not found, throw exception
		if (item == null) {
			throw new Exception("Not Found");
		}
		//if found, delete by id and return
		iItemService.delete(id);
		return new ModelAndView("redirect:/admin/item/");
	}
	
	@RequestMapping(value="/image/{id}")
	public void getImage(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
		Item item = iItemService.getById(id);
		if (item != null && item.getImagedata() != null) {
			response.setContentType("image/jpeg");
			response.getOutputStream().write(item.getImagedata());
			response.getOutputStream().flush();
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
