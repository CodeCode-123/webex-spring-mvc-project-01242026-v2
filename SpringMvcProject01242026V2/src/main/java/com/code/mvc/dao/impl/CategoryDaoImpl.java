package com.code.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.mvc.dao.ICategoryDao;
import com.code.mvc.entity.Category;

@Repository
public class CategoryDaoImpl implements ICategoryDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(Category category) {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//save the category to the database and return
		session.save(category);
		return category.getCategoryId();
	}

	@Override
	public int update(Category category) {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//update the category to the database and return
		session.merge(category);
		return category.getCategoryId();
	}

	@Override
	public int delete(Category category) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//get the id of the category
		int id = category.getCategoryId();
		Category dbCategory = session.get(Category.class, id);
		//if the category cannot be found in the database, return 0
	    if (dbCategory == null) {
	    	return 0;
	    }
	    //if the category can be found in the database, delete the category and return 1
	    session.remove(dbCategory);
		return 1;
	}

	@Override
	public int delete(int id) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//if the category cannot be found in the database, return 0
		Category category = session.get(Category.class, id);
		if (category == null) {
			return 0;
		}
		//if the category can be found in the database, delete the category and return 1
		session.remove(category);
		return 1;
	}

	@Override
	public List<Category> getAll() {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//create HQL for query and retrieve categories from the database
	    return session.createQuery("FROM Category", Category.class).getResultList();
	}

	@Override
	public Category getById(int id) {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//return retrieved result
		return session.get(Category.class, id);
	}

	@Override
	public Category getCategoryByName(String catname) {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//create hql to retrieve category
		String hql="FROM Category c WHERE c.categoryName=:data";
		//retrieve category from the database and return
		return session.createQuery(hql, Category.class)
				      .setParameter("data", catname)
				      .getSingleResult();
	}

	@Override
	public List<Category> search(String catname) {
		//create session object
		Session session = sessionFactory.getCurrentSession();
		//create hql to retrieve categories
		String hql="FROM Category c WHERE c.categoryName LIKE %:data%";
		//retrieve categories from the database and return
		return session.createQuery(hql, Category.class)
				      .setParameter("data", catname)
				      .getResultList();
	}

}
