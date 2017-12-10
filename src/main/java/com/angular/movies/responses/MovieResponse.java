package com.angular.movies.responses;

import com.angular.movies.models.Movie;

public class MovieResponse extends GenericResponse {

	private Movie movie;
	
	public MovieResponse(Boolean isError, String message) {
		super(isError, message);
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
}
