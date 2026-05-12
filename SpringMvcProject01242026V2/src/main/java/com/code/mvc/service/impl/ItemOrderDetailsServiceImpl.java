package com.code.mvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.mvc.dao.IItemOrderDetailsDao;
import com.code.mvc.entity.ItemOrderDetails;
import com.code.mvc.service.IItemOrderDetailsService;

@Service
@Transactional
public class ItemOrderDetailsServiceImpl implements IItemOrderDetailsService {
	@Autowired
	private IItemOrderDetailsDao iItemOrderDetailsDao;

	@Override
	public int add(ItemOrderDetails itemOrderDetails) {
		return iItemOrderDetailsDao.add(itemOrderDetails);
	}

	@Override
	public int update(ItemOrderDetails itemOrderDetails) {
		return iItemOrderDetailsDao.update(itemOrderDetails);
	}

	@Override
	public int delete(ItemOrderDetails itemOrderDetails) {
		return iItemOrderDetailsDao.delete(itemOrderDetails);
	}

	@Override
	public int delete(int id) {
		return iItemOrderDetailsDao.delete(id);
	}

	@Override
	public List<ItemOrderDetails> getAll() {
		return iItemOrderDetailsDao.getAll();
	}

	@Override
	public List<ItemOrderDetails> getByOrderId(int id) {
		return iItemOrderDetailsDao.getByOrderId(id);
	}

	@Override
	public ItemOrderDetails getById(int id) {
		return iItemOrderDetailsDao.getById(id);
	}
}
