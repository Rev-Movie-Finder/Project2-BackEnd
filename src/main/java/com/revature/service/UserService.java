package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.UserDaoImpl;
import com.revature.model.User;

@Service
public class UserService {
    UserDaoImpl ud = new UserDaoImpl();

    
    
	public List<User> getAll() {
		
		return ud.getAllUsers();
	}


	public User getById(int id) {
		// TODO Auto-generated method stub
		
		
		return ud.getUserById(id);
	}

	
	public User create(User obj) {
		
		return ud.createUser(obj);
	}

	public User update(User obj) {
		return ud.updateUser(obj);
		 
	}

	
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return ud.deleteUser(user);
	}
	
	public User getByUserName(String username) {
		
		
		return ud.getUserByUsername(username);
	}
	
	public List <User> validateLogin (User user){
		
		 return ud.validateUser(user);
		
	}
	
	
	
}