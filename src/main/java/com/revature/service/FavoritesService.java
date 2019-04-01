package com.revature.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.model.Favorites;

import com.revature.util.HibernateUtil;

public class FavoritesService {


	public List<Favorites> getAllFavorites() {
		Session s = HibernateUtil.getSession();
		List<Favorites> favorites = s.createCriteria(Favorites.class).list();
		s.close();
		return favorites;
	}


	public Favorites getFavoritesById(int id) {
		
		
//		Session s = HibernateUtil.getSession();
//
//		User u = (User) s.get(User.class,);
//		s.close();
//		System.out.println("------------------pring user form dap" + u);
//		return u;
		
	return null;
	}

//	
//	public Favorites createFavorites(Favorites fav) {
//		Session s = HibernateUtil.getSession();
//		Transaction tx = s.beginTransaction();
//		s.save(fav);
//		tx.commit();
//		s.close();
//		
//		return getUserByUsername(fav.getUsername());
//	}
//
//
//
//
//	public boolean deleteFavorites(Favorites change) {
//		boolean operation =false;
//		Session session = HibernateUtil.getSession();
//		Transaction tx = null;
//		Favorites favorites = null;
//		
//		try {
//			tx = session.beginTransaction();
//			
//			favorites = (Favorites)session.get(Favorites.class, change);
//			
//			session.delete(favorites);
//			
//			tx.commit();
//			operation =true;
//		}catch(HibernateException e){
//			e.printStackTrace();
//			tx.rollback();			
//		}finally {
//			session.close();
//		}
//		return operation;
//		
//	}
//
//	
//	
//	
	
	
	
	
	
	

}
