package com.movie.command;

import com.movie.model.Movie;

import javafx.scene.control.Label;

public class ActorRenderCommand implements UICommand {

	private Label actorsLabel;
	private Movie theMovie;
	
	
	public ActorRenderCommand(Label actorsLabel, Movie theMovie) {
		super();
		this.actorsLabel = actorsLabel;
		this.theMovie = theMovie;
	}


	@Override
	public void execute() {
		System.out.println("Testing");
		this.actorsLabel.setText(this.theMovie.getActors());

	}

}
