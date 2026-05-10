package com.code.mvc.model;

//This class is not saved to the database, only saved in the HttpSession
public class Cart {
	private int itemId;
	private String itemName;
	private int categoryId;
	private String categoryName;
	private double price;
	private double amount;
	private int qty;
	
	public Cart() {
		this.price=0;
		this.amount=0;
		this.qty=0;
	}

	public Cart(int itemId, String itemName, int categoryId, String categoryName, double price, double amount,
			int qty) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.price = price;
		this.amount = amount;
		this.qty = qty;
	}
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		calculateAmount();
		return amount;
	}

	public void setAmount(double amount) {
		calculateAmount();
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	private void calculateAmount() {
		this.amount=this.price * this.qty;
	}
}
