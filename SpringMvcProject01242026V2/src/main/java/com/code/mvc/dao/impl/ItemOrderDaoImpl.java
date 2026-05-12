package com.code.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.mvc.dao.IItemOrderDao;
import com.code.mvc.entity.ItemOrder;

@Repository
public class ItemOrderDaoImpl implements IItemOrderDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int add(ItemOrder itemOrder) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//create the object and save to the database
		session.save(itemOrder);
		return itemOrder.getOrderId();
	}

	@Override
	public int update(ItemOrder itemOrder) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//update the object and save to the database
		session.merge(itemOrder);
		return itemOrder.getOrderId();
	}

	@Override
	public int delete(ItemOrder itemOrder) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//get the orderId, and check it in the database
		int id = itemOrder.getOrderId();
		ItemOrder dbItemOrder = session.get(ItemOrder.class, id);
		if (dbItemOrder == null) {
			//if not found, return 0
			return 0;
		}
		//if found, delete the itemOrder and return 1;
		session.remove(dbItemOrder);
		return 1;
	}

	@Override
	public int delete(int id) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve the object from the database by id
		ItemOrder itemOrder = session.get(ItemOrder.class, id);
		//if not found, return 0
		if (itemOrder == null) {
			return 0;
		}
		//if found, return 1;
		session.remove(itemOrder);
		return 1;
	}

	@Override
	public List<ItemOrder> getAll() {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve all the itemOrders and return
		return session.createQuery("FROM ItemOrder", ItemOrder.class).getResultList();
	}

	@Override
	public ItemOrder getById(int id) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve the itemOrder by id and return
		return session.get(ItemOrder.class, id);
	}
}
