package com.revature.util;

import com.revature.dao.MovieDao;
import com.revature.dao.MovieDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.model.Movie;
import com.revature.model.User;

public class Runner {

	public static void main(String[] args) {
		
		UserDao ud = new UserDaoImpl();
		MovieDao md = new MovieDaoImpl();
		
		User user1 = new User("shimjay1@gmail.com", "magikarp", "123");
		User user2 = new User("hello@gmail.com", "yo", "123");
		
		Movie movie1 = new Movie(100);
		Movie movie2 = new Movie(101);
	
		md.createMovie(movie1);
		md.createMovie(movie2);
		
		user1.addFavoriteMovies(movie1);
		user1.addWishList(movie2);
		user2.addFavoriteMovies(movie1);
		
		ud.createUser(user1);
		ud.createUser(user2);
		
	}

}
