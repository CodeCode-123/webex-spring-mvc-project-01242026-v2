package com.code.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.code.mvc.entity.Category;
import com.code.mvc.entity.Item;
import com.code.mvc.model.Cart;
import com.code.mvc.model.CartCollection;
import com.code.mvc.service.ICategoryService;
import com.code.mvc.service.IItemService;

@Controller
public class HomeController {
	@Autowired
	private ICategoryService iCategoryService;
	@Autowired
	private IItemService iItemService;

	@RequestMapping(value="/")
	public ModelAndView test(Model model) throws IOException{
		//get all the categories
		List<Category> categories = iCategoryService.getAll();
		//get all the items
		List<Item> items = iItemService.getAll();
		//add objects to the model
		model.addAttribute("categories", categories);
		model.addAttribute("items", items);
		return new ModelAndView("home", "", model);
	}
	
	//request the cart by id
	@RequestMapping("/item/cart/{id}")
	public ModelAndView addToCart(@PathVariable("id") int id, Model model, HttpSession session) {
		//get the item by id;
		Item item = iItemService.getById(id);
		//if retrieved item is not null, create a new cart
		if (item != null) {
			Cart cart = new Cart();
			cart.setCategoryId(item.getCategory().getCategoryId());
			cart.setCategoryName(item.getCategory().getCategoryName());
			cart.setItemId(id);
			cart.setItemName(item.getItemName());
			cart.setPrice(item.getItemPrice());
			//set the default item number to be 1
			cart.setQty(1);
			//add cart to my collection
			//we create the object of the collection and put it into the session
			CartCollection cartCollection = (CartCollection) session.getAttribute("cartCollection");
			if (cartCollection == null) {
				cartCollection = new CartCollection();
			}
			cartCollection.addToCart(cart);
			session.setAttribute("cartCollection", cartCollection);
			model.addAttribute("totalAmount", cartCollection.getTotalAmount());
			model.addAttribute("carts", cartCollection.getAll());
			return new ModelAndView("carts", "", model);
		}
		return new ModelAndView("redirect:/");
	}
	
	//request the cart by id
	@RequestMapping(value="/item/cart/update", method=RequestMethod.POST)
	public ModelAndView updateCart(HttpServletRequest request, Model model, HttpSession session) {
		int id = Integer.parseInt(request.getParameter("itemId"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		//check cartCollection
		CartCollection cartCollection = (CartCollection) session.getAttribute("cartCollection");
		if (cartCollection == null) {
			cartCollection = new CartCollection();
		}
		Cart cart = cartCollection.getCartById(id);
		if (cart != null) {
			cart.setQty(qty);
			//update the cart
			cartCollection.updateCart(cart);
			session.setAttribute("cartCollection", cartCollection);
			model.addAttribute("totalAmount", cartCollection.getTotalAmount());
			model.addAttribute("carts", cartCollection.getAll());
			return new ModelAndView("carts", "", model);
		}
		return new ModelAndView("redirect:/");
	}
	
	//delete the cart by id
	@RequestMapping("/item/cart/delete/{id}")
	public ModelAndView deleteCartById(@PathVariable("id") int id, HttpSession session, Model model) {
		CartCollection cartCollection = (CartCollection) session.getAttribute("cartCollection");
		if (cartCollection == null) {
			cartCollection = new CartCollection();
		}
		cartCollection.deleteFromCart(id);
		session.setAttribute("cartCollection", cartCollection);
		model.addAttribute("totalAmount", cartCollection.getTotalAmount());
		model.addAttribute("carts", cartCollection.getAll());
		return new ModelAndView("carts", "", model);
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
