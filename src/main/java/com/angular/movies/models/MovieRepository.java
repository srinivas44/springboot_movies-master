package com.angular.movies.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	public Movie findByMovieId(Long movieId);
	
}
