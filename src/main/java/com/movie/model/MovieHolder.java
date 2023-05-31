package com.movie.model;

import java.util.ArrayList;

import com.movie.command.UICommand;

public class MovieHolder {

	private static MovieHolder instance;
	private Movie theCurrentMovie;
	
	private MovieHolder() {
	}

	public static synchronized MovieHolder getInstance() {
		if (MovieHolder.instance == null) {
			MovieHolder.instance = new MovieHolder();
		}
		return MovieHolder.instance;
	}
	
	private ArrayList<UICommand> commands = new ArrayList<UICommand>();
	
	public void addCommand(UICommand command) {
		this.commands.add(command);
	}

	public void clearCommands() {
		this.commands.clear();
	}
	
	public void setTheCurrentMovie(Movie theCurrentMovie) {
		this.theCurrentMovie = theCurrentMovie;
		for (UICommand uiCommand : commands) {
			uiCommand.execute();
		}
	}

}
