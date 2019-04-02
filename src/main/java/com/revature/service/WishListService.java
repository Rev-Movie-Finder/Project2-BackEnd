package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.revature.dao.UserDaoImpl;
import com.revature.dao.WishListDaoImpl;
import com.revature.model.WishList;



@Service
public class WishListService {
	WishListDaoImpl wl = new WishListDaoImpl();

    
    
	


	public List<WishList> getWishListsByUserId(int id) {
		// TODO Auto-generated method stub
		
		
		return wl.getWishListByUserId(id);
	}

	
	public WishList create(WishList obj) {
		
		return wl.createWishList(obj);
	
	}



	
	public boolean deleteWishList(WishList user) {
		// TODO Auto-generated method stub
		return wl.deleteWishList(user);
	}
	

	

	
	
	
}