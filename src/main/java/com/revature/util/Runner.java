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
		
		User user1 = new User("tester1@gmail.com", "tester1", "123");
		User user2 = new User("tester2@gmail.com", "tester2", "123");
		User user3 = new User("tester3@gmail.com", "tester3", "!!!");
		User user4 = new User("tester4@gmail.com", "tester4", "ah!ha");
		User user5 = new User("tester5@gmail.com", "tester5", "gotem");
		
		Movie movie1 = new Movie(100);
	
		md.createMovie(movie1);;
		
		user1.addFavoriteMovies(movie1);
		user2.addFavoriteMovies(movie1);
		
		ud.createUser(user1);
		ud.createUser(user2);
		ud.createUser(user3);
		ud.createUser(user4);
		ud.createUser(user5);
		
	}

}
