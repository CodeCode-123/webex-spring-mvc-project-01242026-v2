package com.code.mvc.dao;

import java.util.List;

import com.code.mvc.entity.ItemOrder;

public interface IItemOrderDao {
	int add(ItemOrder itemOrder);
	int update(ItemOrder itemOrder);
	int delete(ItemOrder itemOrder);
	int delete(int id);
	//create some method to get the ItemOrder
	List<ItemOrder> getAll();
	ItemOrder getById(int id);
}
