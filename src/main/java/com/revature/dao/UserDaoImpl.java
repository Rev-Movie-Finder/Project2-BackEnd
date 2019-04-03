package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

@Component
public class UserDaoImpl implements UserDao {
	
	
	public List<User> getAllUsers() {
		Session s = HibernateUtil.getSession();
		List<User> events = null;
		
		try {
			events = s.createCriteria(User.class).list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return events;
	}

	
	public User getUserById(Integer id) {
		Session s = HibernateUtil.getSession();
		User u = null;
		
		try{
			u = (User) s.get(User.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return u;
	}

	
	public boolean createUser(User user) {
		boolean created = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		try {
			s.save(user);
			tx.commit();
			created = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally{
			s.close();
		}
	
		return created;
	}
	public User createUserWithReturn(User user) {
		boolean created = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		try {
			s.save(user);
			tx.commit();
			created = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally{
			s.close();
		}
	
		return user;
	}

	
	public boolean updateUser(User change) {
		boolean changed = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		User u = null;
		
		try {
			u = (User) s.get(User.class, change.getId());
			
			if(change.getEmail() != null) {
				u.setEmail(change.getEmail());
			}
			if(change.getUsername() != null) {
				u.setUsername(change.getUsername());
			}
			if(change.getPassword() != null) {
				u.setPassword(change.getPassword());
			}
			if(change.getBirthday() != null) {
				u.setBirthday(change.getBirthday());
			}
			if(change.getFavoriteMovies() != null) {
				u.setFavoriteMovies(change.getFavoriteMovies());
			}
			if(change.getWishList() != null) {
				u.setWishList(change.getWishList());
			}
			
			s.save(u);
			tx.commit();
			changed = true;
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();			
		}finally {
			s.close();
		}
		
		return changed;
	}

	
	public boolean deleteUserById(Integer id) {
		boolean deleted = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();;
		
		try {
			s.delete(s.get(User.class, id));
			tx.commit();
			
			deleted = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		return deleted;
		
	}

}
