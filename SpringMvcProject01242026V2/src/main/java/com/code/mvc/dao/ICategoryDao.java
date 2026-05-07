package com.code.mvc.dao;

import java.util.List;

import com.code.mvc.entity.Category;

public interface ICategoryDao {
	//declare the methods
	int add(Category category);
	int update(Category category);
	int delete(Category category);
	int delete(int id);
	//create some methods to get
	List<Category> getAll();
	Category getById(int id);
	Category getCategoryByName(String catname);
	List<Category> search(String catname);
}
