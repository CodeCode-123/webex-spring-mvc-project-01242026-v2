package com.code.mvc.service;

import java.util.List;
import com.code.mvc.entity.ItemOrderDetails;

public interface IItemOrderDetailsService {
	int add(ItemOrderDetails itemOrderDetails);
	int update(ItemOrderDetails itemOrderDetails);
	int delete(ItemOrderDetails itemOrderDetails);
	int delete(int id);
	List<ItemOrderDetails> getAll();
	List<ItemOrderDetails> getByOrderId(int id);
	ItemOrderDetails getById(int id);
}
