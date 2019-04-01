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
import com.revature.util.HibernateUtil;

public class UserDaoImpl {


	public List<User> getAllUsers() {
		Session s = HibernateUtil.getSession();
		List<User> users = s.createCriteria(User.class).list();
		s.close();
		return users;
	}


	public User getUserById(int id) {
		
		
//		Session s = HibernateUtil.getSession();
//
//		User u = (User) s.get(User.class,);
//		s.close();
//		System.out.println("------------------pring user form dap" + u);
//		return u;
		
	return null;
	}

	
	public User createUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		s.close();
		
		return getUserByUsername(user.getUsername());
	}


	public User updateUser(User change) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		User user = null;
		String passwordAmend  = new String(change.getPassword());
		String emailAmend = new String(change.getEmail());
		String avatarAmend = new String(change.getAvatar());
		
		try {
			tx = session.beginTransaction();
			user = (User)session.get(User.class, change);
			
			System.out.println("retireved user obj" + avatarAmend);
			
			if(change.getPassword() != null) {
				
				user.setPassword(passwordAmend);
				
			}	
			if(change.getEmail() != null) {
				user.setEmail(emailAmend);
			}	
			if(change.getAvatar() != null) {
				user.setAvatar(avatarAmend);
			}
		
			session.update(change);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();			
		}finally {
			session.close();
		} 
		return user;
		
	}


	public boolean deleteUser(User change) {
		boolean operation =false;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		User user = null;
		
		try {
			tx = session.beginTransaction();
			
			user = (User)session.get(User.class, change);
			
			session.delete(user);
			
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

	
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		
		Session s = HibernateUtil.getSession();		
		Criteria crit = s.createCriteria(User.class);
		crit.add(Restrictions.eq("username",username ));
		List list = crit.list();
		s.close();
		Iterator itr = list.iterator();
		User user = new User ();
		
		while (itr.hasNext()) {
			user = (User) itr.next();}
		
		
		
		return user;
		
		
		}
	
	
	
	public List <User> validateUser( User user) {
		
		List <User> userArray = new ArrayList<User>();

	     
		   
	      User foundUser = getUserByUsername(user.getUsername().toLowerCase());
	      
	     
	      
	        if ((foundUser.getUsername() != null) && (foundUser.getPassword().equals(user.getPassword())) ) {
	        	
	        	System.out.println("verified pass!!!");
	        	
	        	
	        	userArray.add(foundUser);
	        	return userArray;
	    	
	        }
	 
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}
	
	
	
	
	
	
	

}
