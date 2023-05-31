package com.movie.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.api.ApiResponse;

public class MovieApiResponseAdapter implements Movie {

	
	private MovieModel internalMovie;

	public MovieApiResponseAdapter(ApiResponse apiResponse) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		// Deserialize the JSON into the ApiResponse class
		this.internalMovie = objectMapper.readValue(apiResponse.responseBody(), MovieModel.class);
		
	}
	
	
	public String getTitle() {
		return this.internalMovie.getTitle();
	}

	public String getYear() {
		return this.internalMovie.getYear();
	}

	public String getRated() {
		return this.internalMovie.getRated();
	}

	public String getActors() {
		return this.internalMovie.getActors();
	}

	public String getPlot() {
		return this.internalMovie.getPlot();
	}

}
