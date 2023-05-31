import java.io.IOException;
import java.net.URISyntaxException;

import com.movie.api.ApiResponse;
import com.movie.api.MovieApiRequestBuilder;

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
			System.out.println(response.responseBody());
			System.out.println(getSelection());
			showImage();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showImage() {
		String imageUrl = "https://m.media-amazon.com/images/M/MV5BOTA5NjhiOTAtZWM0ZC00MWNhLThiMzEtZDFkOTk2OTU1ZDJkXkEyXkFqcGdeQXVyMTA4NDI1NTQx._V1_SX300.jpg";
		Image image = new Image(imageUrl);
        
        // Set the loaded image to the ImageView
        this.posterView.setImage(image);
	}

}
