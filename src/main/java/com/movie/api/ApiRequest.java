package com.movie.api;

import java.io.IOException;

public interface ApiRequest {
	public ApiResponse get() throws RuntimeException, IOException;
}
