package com.code.mvc.service;

import java.util.List;

import com.code.mvc.entity.Users;

public interface IUserService {
	//create the method for the users
	public int addUser(Users users);
	public int updateUser(Users users);
	public int deleteUser(Users users);
	public int deleteUser(int userId);
	public Users getUserById(int userId);
	public Users getUserAuthentication(String emailId, String password);
	public List<Users> searchUser(String keyword);
	public List<Users> getAll();
}
