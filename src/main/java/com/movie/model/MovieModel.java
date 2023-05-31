package com.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieModel implements Movie {
	@JsonProperty("Title")
	private String Title;
	@JsonProperty("Year")
	private String Year;
	@JsonProperty("Rated")
	private String Rated;
	@JsonProperty("Actors")
	private String Actors;
	private String Plot;
	@JsonProperty("Poster")
	private String Poster;
	@Override
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	@Override
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	@Override
	public String getRated() {
		return Rated;
	}
	public void setRated(String rated) {
		Rated = rated;
	}
	@Override
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	@Override
	public String getPlot() {
		return Plot;
	}
	public void setPlot(String plot) {
		Plot = plot;
	}
	@Override
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		Poster = poster;
	}
	
}
