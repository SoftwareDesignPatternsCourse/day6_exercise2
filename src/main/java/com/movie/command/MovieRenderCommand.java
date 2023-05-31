package com.movie.command;

import com.movie.model.Movie;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MovieRenderCommand implements UICommand {

	
	private ImageView moviePoster;
	private Label movieLabel;
	private Movie theMovie;

	public MovieRenderCommand(ImageView moviePoster, Label movieLabel, Movie theMovie) {
		this.moviePoster = moviePoster;
		this.movieLabel = movieLabel;
		this.theMovie = theMovie;
	}

	@Override
	public void execute() {
		System.out.println("Testing");
		this.movieLabel.setText("The name of the movie is: " + this.theMovie.getTitle() + " was released in: " + this.theMovie.getYear());
		String imageUrl = this.theMovie.getPoster();
		Image image = new Image(imageUrl);
        
        // Set the loaded image to the ImageView
        this.moviePoster.setImage(image);
	}
	
}
