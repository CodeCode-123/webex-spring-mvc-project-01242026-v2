package com.code.mvc.dao;

import java.util.List;

import com.code.mvc.entity.Item;

public interface IItemDao {
	int add(Item item);
	int update(Item item);
	int delete(Item item);
	int delete(int id);
	List<Item> getAll();
	Item getById(int id);
	List<Item> getItemByCategoryName(String categoryName);
	List<Item> getItemByCategoryId(int categoryId);
}
