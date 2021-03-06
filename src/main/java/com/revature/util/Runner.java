package com.revature.util;

import com.revature.dao.MovieDao;
import com.revature.dao.MovieDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.model.Movie;
import com.revature.model.User;
import org.apache.log4j.Logger;

public class Runner {

	private static Logger log = Logger.getRootLogger();
	
	public static void main(String[] args) {
		
		UserDao ud = new UserDaoImpl();
		MovieDao md = new MovieDaoImpl();
		
		User user1 = new User("shimjay1@gmail.com", "magikarp", "123");
		User user2 = new User("hello@gmail.com", "yo", "123");
		User user3 = new User("Person@gmail.com", "friend", "!!!");
		User user4 = new User("FriendofPerson@gmail.com", "yuppers", "ah!ha");
		User user5 = new User("dudeman@gmail.com", "duders", "gotem");
		
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
