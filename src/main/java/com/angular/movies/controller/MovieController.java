package com.angular.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.angular.movies.models.Movie;
import com.angular.movies.models.MovieRepository;
import com.angular.movies.responses.GenericResponse;
import com.angular.movies.responses.MovieResponse;
import com.angular.movies.responses.MoviesResponse;

@RestController
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	
	@PostMapping(value = "/create/movie", produces = MediaType.APPLICATION_JSON_VALUE)
	MovieResponse createMovie(@RequestBody Movie movieRequest) {

		MovieResponse response = null;
		
		try {
			Movie movie = movieRepository.save(movieRequest);
			response = new MovieResponse(false, "Create movie ok");
			response.setMovie(movie);
		} catch(Exception e) {
			String errorMessage = "Create movie error: " + e.getMessage();
			response = new MovieResponse(true, errorMessage);
		}

		return response;

	}
	
	@DeleteMapping(value = "/delete/movie", produces = MediaType.APPLICATION_JSON_VALUE)
	GenericResponse deleteMovie(@RequestBody Movie movieRequest) {
		
		GenericResponse response = null;
		
		try {
			movieRepository.delete(movieRequest.getMovieId());
			response = new GenericResponse(false, "Delete movie ok");
		} catch (Exception e) {
			String errorMessage = "Delete movie error: " + e.getMessage();
			response = new GenericResponse(true, errorMessage);
		}
		
		return response;
		
	}
	
	@GetMapping(value = "/select/movie/byId/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	MovieResponse selectMovieById(@PathVariable(value = "movieId") Long movieId) {
		
		MovieResponse response = null;
		
		try {
			Movie movie = movieRepository.findByMovieId(movieId);
			if(movie == null) 
				throw new Exception("The movie " + movieId + " you want to get does not exist");
			response = new MovieResponse(false, "Select movie " + movieId + " by id ok");
			response.setMovie(movie);
		} catch (Exception e) {
			String errorMessage = "Select movie error: " + e.getMessage();
			response = new MovieResponse(true, errorMessage);
		}
		
		return response;
		
	}
	
	@GetMapping(value = "/select/movie/all", produces = MediaType.APPLICATION_JSON_VALUE)
	MoviesResponse selectMovieById() {
		
		MoviesResponse response = null;
		
		try {
			List<Movie> movies = movieRepository.findAll();
			response = new MoviesResponse(false, "Select all movie ok");
			response.setMovies(movies);
		} catch (Exception e) {
			String errorMessage = "Select all movies error: " + e.getMessage();
			response = new MoviesResponse(true, errorMessage);
		}
		
		return response;
		
	}
	
	@PutMapping(value = "/update/movie/", produces = MediaType.APPLICATION_JSON_VALUE)
	MovieResponse updateMovie(@RequestBody Movie movieRequest) {
		
		MovieResponse response = null;
		
		try {
			Movie movie = movieRepository.save(movieRequest);
			response = new MovieResponse(false, "Update movie ok");
			response.setMovie(movie);
		} catch (Exception e) {
			String errorMessage = "Update movie error: " + e.getMessage();
			response = new MovieResponse(true, errorMessage);
		}
		
		return response;
		
	}
	
}
