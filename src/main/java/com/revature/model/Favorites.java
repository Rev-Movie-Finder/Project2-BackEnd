package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
 

@Entity
public class Favorites {

	@Id
	@Column(name="f_id")
    private int movieId;
    
	public Favorites() {
		super();
		// TODO Aut-generated constructor stub
	}

	public Favorites(int movieId) {
		super();
		this.movieId = movieId;
	}



	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	@Override
	public String toString() {
		return "Favorites [movieId=" + movieId + "]";
	}
	
	
	
	
	
}
