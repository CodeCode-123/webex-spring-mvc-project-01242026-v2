package com.code.mvc.dao;

import java.util.List;

import com.code.mvc.entity.ItemOrderDetails;

public interface IItemOrderDetailsDao {
	int add(ItemOrderDetails itemOrderDetails);
	int update(ItemOrderDetails itemOrderDetails);
	int delete(ItemOrderDetails itemOrderDetails);
	int delete(int id);
	List<ItemOrderDetails> getAll();
	List<ItemOrderDetails> getByOrderId(int id);
	ItemOrderDetails getById(int id);
}
