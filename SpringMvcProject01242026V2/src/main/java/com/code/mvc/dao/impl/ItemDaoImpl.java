package com.code.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.mvc.dao.IItemDao;
import com.code.mvc.entity.Item;

@Repository
public class ItemDaoImpl implements IItemDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(Item item) {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//save item to the database and return;
		session.save(item);
		return item.getItemId();
	}

	@Override
	public int update(Item item) {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//update item to the database and return;
		session.merge(item);
		return item.getItemId();
	}

	@Override
	public int delete(Item item) {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//get item id
		int id = item.getItemId();
		//retrieve item from the database
		Item dbItem = session.get(Item.class, id);
		//if item was not found in the database, return 0
		if (dbItem == null) {
			return 0;
		}
		//if item was found in the database, delete the item and return 1
		session.remove(dbItem);
		return 1;
	}

	@Override
	public int delete(int id) {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve item from the database
		Item dbItem = session.get(Item.class, id);
		//if item was not found in the database, return 0
		if (dbItem == null) {
			return 0;
		}
		//if item was found in the database, delete the item and return 1
		session.remove(dbItem);
		return 1;
	}

	@Override
	public List<Item> getAll() {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve all items from the database and return;
		return session.createQuery("FROM Item", Item.class).getResultList();
	}

	@Override
	public Item getById(int id) {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve item from the database and return;
		return session.get(Item.class, id);
	}

	@Override
	public List<Item> getItemByCategoryName(String categoryName) {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve all the items from the database by categoryName and return;
		return session.createQuery("FROM Item i WHERE i.category.categoryName=:data", Item.class)
				.setParameter("data", categoryName)
				.getResultList();
	}

	@Override
	public List<Item> getItemByCategoryId(int categoryId) {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve all the items from the database by category id and return;
		return session.createQuery("FROM Item i WHERE i.category.categoryId=:data", Item.class)
				.setParameter("data", categoryId)
				.getResultList();
	}
}
