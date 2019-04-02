package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.model.Movie;
import com.revature.util.HibernateUtil;

@Component
public class MovieDaoImpl implements MovieDao {
	
	
	public List<Movie> getAllMovies() {
		Session s = HibernateUtil.getSession();
		List<Movie> events = null;
		
		try {
			events = s.createCriteria(Movie.class).list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return events;
	}

	
	public Movie getMovieById(Integer id) {
		Session s = HibernateUtil.getSession();
		Movie u = null;
		
		try{
			u = (Movie) s.get(Movie.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return u;
	}

	
	public boolean createMovie(Movie movie) {
		boolean created = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		try {
			s.save(movie);
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

	
	public boolean deleteMovieById(Integer id) {
		boolean deleted = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();;
		
		try {
			s.delete(s.get(Movie.class, id));
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
