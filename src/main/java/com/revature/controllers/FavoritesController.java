package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.exceptions.UserNotFoundException;

import com.revature.service.FavoritesService;
import com.revature.service.UserService;

@CrossOrigin
@Controller
public class FavoritesController {
	
	@Autowired
	FavoritesService fService;
	
	@GetMapping("/favorites")
	@ResponseBody
	public List<User> getUsers(@RequestParam(value="id",required=false)Integer id){
		if(id!=null) {
			
			System.out.println("----------------->in /user");
			User c = uService.getById(id);
			if(c == null) {
				throw new UserNotFoundException();
			} else {
				ArrayList<User> users = new ArrayList<User>();
				users.add(c);
				return users;
			}
		}
		return uService.getAll();
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/update/")
//	@ResponseBody
	
	
	
	
	@PutMapping(value="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User updateUser( @RequestBody User user) {
		
		
		System.out.println("printig out iddddddddd---->>>" +user);
		
		User u =uService.update(user);
	
		if(u == null) {
			// throw an exception associated with a 404 response status
			throw new UserNotFoundException();
		}
		return user;
	}
	

	
	@PostMapping("/new")
	@ResponseBody
	public User returnNewUserPage( @RequestBody User user) {
		
		 System.out.println("in /new");
			 
		return  uService.create(user);
	}
	
	
	@PostMapping("/validate")
	@ResponseBody
	public List <User> loginValidation( @RequestBody User user) {
		
		
		 System.out.println("in /validation");
	
 
		 
		 
		return  uService.validateLogin(user);
		
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public boolean deleteUserAccount( @RequestBody User user) {
		
		
		 System.out.println("in /validation");
	 
 
		 
		 
		return uService.deleteUser(user);
		
	}
	

}
