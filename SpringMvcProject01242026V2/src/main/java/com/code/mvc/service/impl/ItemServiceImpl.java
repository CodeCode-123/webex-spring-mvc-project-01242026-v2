package com.code.mvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.code.mvc.dao.IItemDao;
import com.code.mvc.entity.Item;
import com.code.mvc.service.IItemService;

@Service
@Transactional
public class ItemServiceImpl implements IItemService {
	
	@Autowired
	private IItemDao iItemDao;

	@Override
	public int add(Item item) {
		return iItemDao.add(item);
	}

	@Override
	public int update(Item item) {
		return iItemDao.update(item);
	}

	@Override
	public int delete(Item item) {
		return iItemDao.delete(item);
	}

	@Override
	public int delete(int id) {
		return iItemDao.delete(id);
	}

	@Override
	public List<Item> getAll() {
		return iItemDao.getAll();
	}

	@Override
	public Item getById(int id) {
		return iItemDao.getById(id);
	}

	@Override
	public List<Item> getItemByCategoryName(String categoryName) {
		return iItemDao.getItemByCategoryName(categoryName);
	}

	@Override
	public List<Item> getItemByCategoryId(int categoryId) {
		return iItemDao.getItemByCategoryId(categoryId);
	}
}
