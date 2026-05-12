package com.code.mvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.mvc.dao.IItemOrderDao;
import com.code.mvc.entity.ItemOrder;
import com.code.mvc.service.IItemOrderService;

@Service
@Transactional
public class ItemOrderServiceImpl implements IItemOrderService {
	@Autowired
	private IItemOrderDao iItemOrderDao;

	@Override
	public int add(ItemOrder itemOrder) {
		return iItemOrderDao.add(itemOrder);
	}

	@Override
	public int update(ItemOrder itemOrder) {
		return iItemOrderDao.update(itemOrder);
	}

	@Override
	public int delete(ItemOrder itemOrder) {
		return iItemOrderDao.delete(itemOrder);
	}

	@Override
	public int delete(int id) {
		return iItemOrderDao.delete(id);
	}

	@Override
	public List<ItemOrder> getAll() {
		return iItemOrderDao.getAll();
	}

	@Override
	public ItemOrder getById(int id) {
		return iItemOrderDao.getById(id);
	}

}
