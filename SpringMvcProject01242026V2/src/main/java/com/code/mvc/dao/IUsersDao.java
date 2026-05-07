package com.code.mvc.dao;

import java.util.List;

import com.code.mvc.entity.Users;

public interface IUsersDao {
	//create the method for the users
	int addUser(Users users);
	int updateUser(Users users);
	int deleteUser(Users users);
	int deleteUser(int userId);
	Users getUserById(int userId);
	Users getUserAuthentication(String emailId, String password);
	List<Users> searchUser(String keyword);
	List<Users> getAll();
}
