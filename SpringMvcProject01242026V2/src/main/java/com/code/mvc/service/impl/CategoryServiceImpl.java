package com.code.mvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.code.mvc.dao.ICategoryDao;
import com.code.mvc.entity.Category;
import com.code.mvc.service.ICategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private ICategoryDao iCategoryDao;

	@Override
	public int add(Category category) {
		return iCategoryDao.add(category);
	}

	@Override
	public int update(Category category) {
		return iCategoryDao.update(category);
	}

	@Override
	public int delete(Category category) {
		return iCategoryDao.delete(category);
	}

	@Override
	public int delete(int id) {
		return iCategoryDao.delete(id);
	}

	@Override
	public List<Category> getAll() {
		return iCategoryDao.getAll();
	}

	@Override
	public Category getById(int id) {
		return iCategoryDao.getById(id);
	}

	@Override
	public Category getCategoryByName(String catname) {
		return iCategoryDao.getCategoryByName(catname);
	}

	@Override
	public List<Category> search(String catname) {
		return iCategoryDao.search(catname);
	}

}
