package com.movie.api;

public class MovieApiResponse implements ApiResponse {

	private int responseCode;
	private String responseBody;

	public MovieApiResponse(int responseCode, String responseBody) {
		super();
		this.responseCode = responseCode;
		this.responseBody = responseBody;
	}

	public int responseCode() {
		return this.responseCode;
	}

	public String responseBody() {
		return this.responseBody;
	}

}
