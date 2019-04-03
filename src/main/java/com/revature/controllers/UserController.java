package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.MovieDao;
import com.revature.dao.MovieDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.model.Movie;
import com.revature.model.User;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserDao ud = new UserDaoImpl();
	@Autowired
	MovieDao md = new MovieDaoImpl();
	
	@GetMapping
    public List<User> getAllUsers(){
		return ud.getAllUsers();
    }
	
	@GetMapping(value="/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		User user = ud.getUserById(id);
		return user;
	}
	
	@PostMapping
	public boolean createUser(@RequestBody User user){
		List<User> users = ud.getAllUsers();
		for(User u : users) {
			if(u.getId() == user.getId()) {
				return false;
			}
		}
		return ud.createUser(user);
	}

	@PostMapping(value = "/create")
	public Object createUserAlternative(@RequestBody User user) {

		if (user.getUsername() == null)
			return "please provide username";
		if (user.getPassword() == null)
			return "please provide password";
		if (user.getUsername().length() < 3)
			return "Characters for username must be greater than 3";
		if (user.getPassword().length() < 3)
			return "Characters for password must be greater than 3";

		List<User> users = ud.getAllUsers();

		for (User u : users) {
			if ((u.getUsername().equals(user.getUsername()))) {
				users.clear();
				return users;
			}

		}

		return ud.createUserWithReturn(user);
	}
	
	@PostMapping(value = "/login")
	public Object login(@RequestBody User user) {

		if (user.getUsername().toLowerCase() == null || user.getUsername().toLowerCase().equals(""))
			return "please provide username";
		if (user.getUsername().length() < 3)
			return "Characters for username must be greater than 3";

		List<User> users = ud.getAllUsers();

		for (User u : users) {
			if ((u.getUsername().toLowerCase().equals(user.getUsername().toLowerCase()))) {
				
				if ((u.getPassword().equals(user.getPassword()))) {
				       return u;
				
				}
			}

		}

		return "Wrong Password or username";
	}
	
	@PostMapping(value="/{id}/favorite")
	public boolean addFavoriteToUser(@PathVariable("id") Integer id, @RequestBody Movie movie){
		List<User> users = ud.getAllUsers();
		User user = ud.getUserById(id);
		if(user != null) {
			for(User u : users) {
				if(u.getId() == user.getId()) {
					List<Movie> movies = md.getAllMovies();
					for(Movie m : movies) {
						if(m.getId().equals(movie.getId())) {
							user.addFavoriteMovies(movie);
							return ud.updateUser(user);
						}
					}
					md.createMovie(movie);
					user.addFavoriteMovies(movie);
					return ud.updateUser(user);
				}
			}
		}
		return false;
	}
	
	@PostMapping(value="/{id}/wish")
	public boolean addWishToMovie(@PathVariable("id") Integer id, @RequestBody Movie movie){
		List<User> users = ud.getAllUsers();
		User user = ud.getUserById(id);
		if(user != null) {
			for(User u : users) {
				if(u.getId() == user.getId()) {
					List<Movie> movies = md.getAllMovies();
					for(Movie m : movies) {
						if(m.getId().equals(movie.getId())) {
							user.addWishList(movie);
							return ud.updateUser(user);
						}
					}
					md.createMovie(movie);
					user.addWishList(movie);
					return ud.updateUser(user);
				}
			}
		}
		return false;
	}
	
	@PutMapping("/{id}")
	public boolean updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		List<User> users = ud.getAllUsers();
		for(User u : users) {
			if(u.getId() == id) {
				user.setId(id);
				return ud.updateUser(user);
			}
		}
		return false;
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable("id") Integer id) {
		List<User> users = ud.getAllUsers();
		for(User u : users) {
			if(u.getId() == id) {
				return ud.deleteUserById(id);
			}
		}
		return false;
	}
	

}
