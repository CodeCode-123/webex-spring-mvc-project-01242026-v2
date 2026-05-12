package com.code.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.code.mvc.dao.IItemOrderDetailsDao;
import com.code.mvc.entity.ItemOrderDetails;

@Repository
public class ItemOrderDetailsDaoImpl implements IItemOrderDetailsDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(ItemOrderDetails itemOrderDetails) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//create the itemOrderDetails and save to the database
		session.save(itemOrderDetails);
		return itemOrderDetails.getItemOrderId();
	}

	@Override
	public int update(ItemOrderDetails itemOrderDetails) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//update the itemOrderDetails and save to the database
		session.merge(itemOrderDetails);		
		return itemOrderDetails.getItemOrderId();
	}

	@Override
	public int delete(ItemOrderDetails itemOrderDetails) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//get the id of itemOrderDetails, and retrieve the object from the database
		int id = itemOrderDetails.getItemOrderId();
		ItemOrderDetails dbItemOrderDetails = session.get(ItemOrderDetails.class, id);
		//if not found, return 0
		if (dbItemOrderDetails == null) {
			return 0;
		}
		//if found, delete the object and return 1
		session.remove(dbItemOrderDetails);
		return 1;
	}

	@Override
	public int delete(int id) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve the object from the database
		ItemOrderDetails itemOrderDetails = session.get(ItemOrderDetails.class, id);
		//if not found, return 0
		if (itemOrderDetails == null) {
			return 0;
		}
		//if found, delete the object and return 1
		session.remove(itemOrderDetails);
		return 1;
	}

	@Override
	public List<ItemOrderDetails> getAll() {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve all the objects from the database and return
		return session.createQuery("FROM ItemOrderDetails", ItemOrderDetails.class).getResultList();
	}

	@Override
	public List<ItemOrderDetails> getByOrderId(int id) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve the object from the database and return the objects
		return session.createQuery("SELECT i FROM ItemOrderDetails i WHERE i.itemOrder.orderId=:data", ItemOrderDetails.class)
				      .setParameter("data", id)
				      .getResultList();
	}

	@Override
	public ItemOrderDetails getById(int id) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve the object from the database and return
		return session.get(ItemOrderDetails.class, id);
	}

}
