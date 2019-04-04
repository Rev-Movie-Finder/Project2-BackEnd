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
	public List<User> getAllUsers() {
		return ud.getAllUsers();
	}

	@GetMapping(value = "/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		User user = ud.getUserById(id);
		return user;
	}

	@PostMapping
	public boolean createUser(@RequestBody User user) {
		List<User> users = ud.getAllUsers();
		for (User u : users) {
			if (u.getId().equals(user.getId())) {
				return false;
			}
		}
		return ud.createUser(user);
	}

	@PostMapping(value = "/{id}/favorite")
	public boolean addFavoriteToUser(@PathVariable("id") Integer id, @RequestBody Movie movie) {
		List<User> users = ud.getAllUsers();
		User user = ud.getUserById(id);
		if (user != null) {
			for (User u : users) {
				if (u.getId().equals(user.getId())) {
					List<Movie> movies = md.getAllMovies();
					for (Movie m : movies) {
						if (m.getId().equals(movie.getId())) {
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

	@PostMapping(value = "/{id}/wish")
	public boolean addWishToMovie(@PathVariable("id") Integer id, @RequestBody Movie movie) {
		List<User> users = ud.getAllUsers();
		User user = ud.getUserById(id);
		if (user != null) {
			for (User u : users) {
				if (u.getId().equals(user.getId())) {
					List<Movie> movies = md.getAllMovies();
					for (Movie m : movies) {
						if (m.getId().equals(movie.getId())) {
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
		for (User u : users) {
			if (u.getId().equals(id)) {
				user.setId(id);
				return ud.updateUser(user);
			}
		}
		return false;
	}

	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable("id") Integer id) {
		List<User> users = ud.getAllUsers();
		for (User u : users) {
			if (u.getId().equals(id)) {
				return ud.deleteUserById(id);
			}
		}
		return false;
	}

}
