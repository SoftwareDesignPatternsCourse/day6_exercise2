import java.io.IOException;
import java.net.URISyntaxException;

import com.movie.api.ApiResponse;
import com.movie.api.MovieApiRequestBuilder;
import com.movie.model.Movie;
import com.movie.model.MovieApiResponseAdapter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class MovieAppController {

	
	private static final String apiKey = "679bbbe8";
	
	@FXML
	private void printHelloWorld(ActionEvent event) {
		event.consume();
		System.out.println("Hello, World!");
		messageLabel.setText("Facux");

	}

	@FXML
	private StackPane alarmPanelHot;

	@FXML
	private StackPane alarmPanelCold;

	@FXML
	private void showAlarm(ActionEvent event) {
		event.consume();
		alarmPanelHot.setVisible(!alarmPanelHot.isVisible());
		alarmPanelCold.setVisible(!alarmPanelCold.isVisible());
	}

	@FXML
	private void findMovie(ActionEvent event) {
		event.consume();
		String movie = movieNameField.getText();
		if (movie.isBlank() || movie.isEmpty()) {
			messageLabel.setText("Please provide a movie");
			return;
		}
		messageLabel.setText(movie);
		this.getMovie(movie);
	}

	@FXML
	private TextField movieNameField;

	@FXML
	private Label messageLabel;
	
	@FXML
	private Label movieName;
	
	@FXML
	private Label movieActors;

	private void getMovie(String movieName) {
		try {
			MovieApiRequestBuilder movieApiRequestBuilder = new MovieApiRequestBuilder();
			movieApiRequestBuilder.addApiKey(apiKey);
			movieApiRequestBuilder.addMovie(movieName);
			ApiResponse response = movieApiRequestBuilder.build().get();
			Movie movie = new MovieApiResponseAdapter(response);
			this.display(movie);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void display(Movie movie) {
		this.movieActors.setText(movie.getActors());
		this.movieName.setText(movie.getTitle());
	}

}
