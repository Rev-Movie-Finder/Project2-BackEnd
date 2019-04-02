package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.model.Favorites;
import com.revature.model.User;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		User user = new User();
		user.setUserId(1);
		user.setFirstName("Abbi");
		user.setLastName("Brader");
		user.setUsername("wewjjwjw");
		
		
		Favorites fs = new Favorites();
		fs.setF_id(1);
		fs.setMovie_id(1);
		
//		List<Favorites> fList = new ArrayList<Favorites>();
//		fList.add(fs);
		
		//user.setFavs(fList);
		List<Favorites> someList = user.getFavs();
		someList.add(fs);
		
		System.out.println("printi guser" + user);
		UserDaoImpl udl = new UserDaoImpl();
		System.out.println(udl.createUser(user));
		
		
		//sds
		
		
		
		
		
		
		

	}

}
