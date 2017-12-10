package com.angular.movies.responses;

import java.util.List;

import com.angular.movies.models.Movie;

public class MoviesResponse extends GenericResponse{

	private List<Movie> movies;
	
	public MoviesResponse(Boolean isError, String message) {
		super(isError, message);
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	} 

}
