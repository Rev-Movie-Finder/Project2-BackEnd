package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDao {
	
	public List<User> getAllUsers();
	public User getUserById(Integer id);
	public boolean createUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUserById(Integer id);

}
