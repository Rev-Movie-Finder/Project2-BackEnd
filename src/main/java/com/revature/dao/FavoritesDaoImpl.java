package com.revature.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.model.Favorites;
import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class FavoritesDaoImpl {


	


	public List <Favorites> getFavoritesByUserId(int id) {
		
		
//		Session s = HibernateUtil.getSession();
//
//		Favorites u = (Favorites) s.get(Favorites.class,id);
//		s.close();
//		System.out.println("------------------pring user form dap" + u);
//		return u;
		
		Session s = HibernateUtil.getSession();		
		Criteria crit = s.createCriteria(User.class);
		crit.add(Restrictions.eq("user_id",id ));
		List list = crit.list();
		s.close();
		Iterator itr = list.iterator();
		Favorites user = new Favorites ();
		List <Favorites> fvList = new ArrayList<Favorites>();
		System.out.println("<<<<<<<beforeloop>>>>>>>>");
		while (itr.hasNext()) {
			Favorites fvl = (Favorites) itr.next();
			fvList.add(fvl);
			System.out.println("<<<<<<<inloop>>>>>>>>" + fvl.getMovie_id());
			
			
		
		}
		
		
		
		return fvList;
		

	}

	
	public Favorites createFavorites(Favorites fav) {
	System.out.println("------>" + fav);
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(fav);
		tx.commit();
		s.close();
		
		return fav;
	}




	public boolean deleteFavorites(Favorites change) {
		boolean operation =false;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Favorites fav = null;
		
		try {
			tx = session.beginTransaction();
			
			fav = (Favorites)session.get(Favorites.class, change);
			
			session.delete(fav);
			
			tx.commit();
			operation =true;
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();			
		}finally {
			session.close();
		}
		return operation;
		
	}

//	
//	public Favorites getFavoritesByUsername(String username) {
//		// TODO Auto-generated method stub
//		
//		Session s = HibernateUtil.getSession();		
//		Criteria crit = s.createCriteria(User.class);
//		crit.add(Restrictions.eq("username",username ));
//		List list = crit.list();
//		s.close();
//		Iterator itr = list.iterator();
//		User user = new User ();
//		
//		while (itr.hasNext()) {
//			user = (User) itr.next();}
//		
//		
//		
//		return user;
//		
//		
//		}
	
	
	
		
		
		
		
		
		
		
		
	
	
	

}
