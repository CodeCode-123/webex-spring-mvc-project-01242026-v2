package com.code.mvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.mvc.dao.IUserDao;
import com.code.mvc.entity.Users;
import com.code.mvc.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao iUserDao;

	@Override
	public int addUser(Users users) {
		// TODO Auto-generated method stub
		return iUserDao.addUser(users);
	}

	@Override
	public int updateUser(Users users) {
		// TODO Auto-generated method stub
		return iUserDao.updateUser(users);
	}

	@Override
	public int deleteUser(Users users) {
		// TODO Auto-generated method stub
		return iUserDao.deleteUser(users);
	}

	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		return iUserDao.deleteUser(userId);
	}

	@Override
	public Users getUserById(int userId) {
		// TODO Auto-generated method stub
		return iUserDao.getUserById(userId);
	}

	@Override
	public Users getUserAuthentication(String emailId, String password) {
		// TODO Auto-generated method stub
		return iUserDao.getUserAuthentication(emailId, password);
	}

	@Override
	public List<Users> searchUser(String keyword) {
		// TODO Auto-generated method stub
		return iUserDao.searchUser(keyword);
	}

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return iUserDao.getAll();
	}

}
