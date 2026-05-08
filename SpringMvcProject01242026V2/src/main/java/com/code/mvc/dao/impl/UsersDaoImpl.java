package com.code.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.mvc.dao.IUsersDao;
import com.code.mvc.entity.Users;

@Repository
public class UsersDaoImpl implements IUsersDao{
	//add the dependency
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int addUser(Users users) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//save the object, use transaction in the service class
		session.save(users);
		return users.getId();
	}

	@Override
	public int updateUser(Users users) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//save the object
		session.merge(users);
		return users.getId();
	}

	@Override
	public int deleteUser(Users users) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//delete the object
		if (session.get(Users.class, users.getId()) == null) {
			// if not found in the database, return 0
			return 0;
		}
		// if found in the database, remove the object and return 1
		session.remove(users);
		return 1;
	}

	@Override
	public int deleteUser(int userId) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
        // retrieve the users from the database by userId
		Users users = session.get(Users.class, userId);
		//delete the object by Id
		if (users == null) {
			// if not found in the database, return 0
			return 0;
		}
		// if found in the database, remove the object and return 1
		session.remove(users);
		return 1;
	}

	@Override
	public Users getUserById(int userId) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//return the object retrieved from the database
		return session.get(Users.class, userId);
	}

	@Override
	public Users getUserAuthentication(String emailId, String password) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//create the query
		String hql = "SELECT u FROM Users u WHERE u.emailId=:email AND u.password=:pwd";
		//retrieve the object
		List<Users> lstusers = session.createQuery(hql, Users.class)
				      .setParameter("email", emailId)
				      .setParameter("pwd", password)
				      .getResultList();
		//don't return single result, if not found will throw exception
		if (lstusers.size() > 0) {
			return lstusers.get(0);
		}
		return null;
	}

	@Override
	public List<Users> searchUser(String keyword) {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//create the query
		String hql="SELECT u FROM Users u WHERE u.firstName LIKE %:kwd1% OR u.lastName LIKE %:kwd2%";
		//retrieve the object
		return session.createQuery(hql, Users.class)
				      .setParameter("kwd1", keyword)
				      .setParameter("kwd2", keyword)
				      .getResultList();
	}

	@Override
	public List<Users> getAll() {
		//create the session object
		Session session = sessionFactory.getCurrentSession();
		//retrieve the objects
		return session.createQuery("FROM Users", Users.class).getResultList();
	}

}
