package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
 


@Component
@Entity
public class WishList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private int w_id;
	
	private int movie_id;
    
	
	private int user_id;
	
	
	public WishList() {
		super();
		// TODO Aut-generated constructor stub
	}


	public int getW_id() {
		return w_id;
	}


	public void setW_id(int w_id) {
		this.w_id = w_id;
	}


	public int getMovie_id() {
		return movie_id;
	}


	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	@Override
	public String toString() {
		return "WishList [w_id=" + w_id + ", movie_id=" + movie_id + ", user_id=" + user_id + "]";
	}

	
	
	
}
