package com.code.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class CartCollection {
	//collection
	List<Cart> items = new ArrayList<>();
	
	//create some methods, add item to cart
	public int addToCart(Cart item) {
		//item not added
		int flag = 0;
		boolean result = checkDuplicatedItem(item);
		//if not duplicated, add item and flag changed to 1
		if (result==false) {
			items.add(item);
			flag=1;
		}
		return flag;
	}
	
	private boolean checkDuplicatedItem(Cart item) {
		for (Cart item2: items) {
			if (item2.getItemId() == item.getItemId()) {
				return true;
			}
		}
		return false;
	}
	
	//update item in the cart
	public boolean updateCart(Cart item) {
		for (Cart item2: items) {
			if (item2.getItemId() == item.getItemId()) {
				//update the qty
				item2.setQty(item.getQty());
				return true;
			}
		}
		//not found, and return false;
		return false;
	} 
	
	//delete item from cart by itemId
	public boolean deleteFromCart(int itemId) {
		for (Cart item2: items) {
			//if found by itemId, remove it, and return
			if (item2.getItemId() == itemId) {
				//remove the item2 not the id, 
				//otherwise the array list will remove item by index
				items.remove(item2);
				return true;
			}
		}
		//if not found return false;
		return false;
	}
	
	//get cart by Id
	public Cart getCartById(int itemId) {
		for (Cart item2: items) {
			//if found, return the item
			if (item2.getItemId() == itemId) {
				return item2;
			}
		}
		//if not found return null
		return null;
	}
	
	//get all carts
	public List<Cart> getAll() {
		return items;
	}
	
	//get total qty of items
	public int getTotalItem() {
		return items.size();
	}
	
	//get total amount/price of carts
	public double getTotalAmount() {
		double totalAmount = 0;
		for (Cart item2: items) {
			totalAmount += item2.getAmount();
		}
		return totalAmount;
	}
}
