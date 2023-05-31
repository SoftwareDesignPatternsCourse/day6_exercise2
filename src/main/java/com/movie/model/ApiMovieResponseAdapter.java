package com.movie.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.api.ApiResponse;

public class ApiMovieResponseAdapter implements Movie {
	
	private MovieModel implementation;

	public ApiMovieResponseAdapter(ApiResponse apiResponse) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		this.implementation = objectMapper.readValue(apiResponse.responseBody(), MovieModel.class);
		
	}

	@Override
	public String getTitle() {
		return this.implementation.getTitle();
	}

	@Override
	public String getYear() {
		return this.implementation.getYear();
	}

	@Override
	public String getRated() {
		return this.implementation.getRated();
	}

	@Override
	public String getActors() {
		return this.implementation.getActors();
	}

	@Override
	public String getPlot() {
		return this.implementation.getPlot();
	}

	@Override
	public String getPoster() {
		return this.implementation.getPoster();
	}

}
