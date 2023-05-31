import java.io.IOException;
import java.net.URISyntaxException;

import com.movie.api.ApiResponse;
import com.movie.api.MovieApiRequestBuilder;
import com.movie.command.ActorRenderCommand;
import com.movie.command.MovieRenderCommand;
import com.movie.model.ApiMovieResponseAdapter;
import com.movie.model.MovieHolder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MovieAppController {

	private static final String apiKey = "679bbbe8";

	@FXML
    private ToggleGroup displayToggle;
    
    @FXML
    private RadioButton movieRadioButton;
    
    @FXML
    private RadioButton actorRadioButton;

	@FXML
	private StackPane alarmPanelHot;

	@FXML
	private StackPane alarmPanelCold;
	
	@FXML
	private ImageView posterView;

	
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

	
	private String getSelection() {
		RadioButton selectedRadioButton = (RadioButton) displayToggle.getSelectedToggle();
        if (selectedRadioButton != null) {
            System.out.println("Selected Radio Button: " + selectedRadioButton.getText());
            
            
            if (selectedRadioButton == movieRadioButton) {
                return "movie";
            } 
            if (selectedRadioButton == actorRadioButton) {
                return "actor";
            } 
        }
        return null;
	}
	
	private void getMovie(String movieName) {
		try {
			MovieApiRequestBuilder movieApiRequestBuilder = new MovieApiRequestBuilder();
			movieApiRequestBuilder.addApiKey(apiKey);
			movieApiRequestBuilder.addMovie(movieName);
			ApiResponse response = movieApiRequestBuilder.build().get();
			ApiMovieResponseAdapter adapter = new ApiMovieResponseAdapter(response);
			MovieHolder.getInstance().clearCommands();
			if (getSelection().equalsIgnoreCase("movie")) {
				MovieHolder.getInstance().addCommand(new MovieRenderCommand(this.posterView, this.movieName, adapter ));
			} else {
				MovieHolder.getInstance().addCommand(new ActorRenderCommand( this.movieName, adapter ));
			}
			MovieHolder.getInstance().setTheCurrentMovie(adapter);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
