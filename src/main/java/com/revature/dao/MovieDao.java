package com.revature.dao;

import java.util.List;

import com.revature.model.Movie;

public interface MovieDao {
	
	public List<Movie> getAllMovies();
	public Movie getMovieById(Integer id);
	public boolean createMovie(Movie movie);
	public boolean deleteMovieById(Integer id);

}
