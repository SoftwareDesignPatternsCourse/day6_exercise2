package com.movie.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.client.utils.URIBuilder;

public class MovieApiRequestBuilder {

	
	private String apiKey;
	private String movie;
	
	public void addApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public void addMovie(String movie) {
		this.movie = movie;
	}
	
	public ApiRequest build() throws URISyntaxException, IOException {
		URIBuilder ub = new URIBuilder(
				"http://www.omdbapi.com/");
		ub.addParameter("t", this.movie);
		ub.addParameter("apikey", this.apiKey);


		// Create URL object with the API endpoint
		URL url = new URL(ub.toString());
		return new MovieApiRequest(url);
		
	}
	
}
