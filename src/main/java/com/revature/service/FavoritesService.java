package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.FavoritesDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.model.Favorites;


@Service
public class FavoritesService {
	FavoritesDaoImpl fd = new FavoritesDaoImpl();

    
    
	


	public List<Favorites> getFavoritesByUserId(int id) {
		// TODO Auto-generated method stub
		
		
		return fd.getFavoritesByUserId(id);
	}

	
	public Favorites create(Favorites obj) {
		
		return fd.createFavorites(obj);
	
	}



	
	public boolean deleteFavorites(Favorites user) {
		// TODO Auto-generated method stub
		return fd.deleteFavorites(user);
	}
	

	

	
	
	
}