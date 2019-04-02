package com.revature.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.model.User;
import com.revature.model.WishList;
import com.revature.util.HibernateUtil;

public class WishListDaoImpl {


	


	public List <WishList> getWishListByUserId(int id) {
		
		
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
		WishList user = new WishList ();
		List <WishList> fvList = new ArrayList<WishList>();
		System.out.println("<<<<<<<beforeloop>>>>>>>>");
		while (itr.hasNext()) {
			WishList fvl = (WishList) itr.next();
			fvList.add(fvl);
			System.out.println("<<<<<<<inloop>>>>>>>>" + fvl.getMovie_id());
			
			
		
		}
		
		
		
		return fvList;
		

	}

	
	public WishList createWishList(WishList wish) {
	System.out.println("------>" + wish);
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(wish);
		tx.commit();
		s.close();
		
		return wish;
	}




	public boolean deleteWishList(WishList change) {
		boolean operation =false;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		WishList fav = null;
		
		try {
			tx = session.beginTransaction();
			
			fav = (WishList)session.get(WishList.class, change);
			
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
