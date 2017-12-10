package com.angular.movies.responses;

public class GenericResponse {

	private Boolean isError;
	private String message;
	
	public GenericResponse(Boolean isError, String message) {
		this.isError = isError;
		this.message = message;
	}
	
	public Boolean getIsError() {
		return isError;
	}
	
	public void setIsError(Boolean isError) {
		this.isError = isError;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}
