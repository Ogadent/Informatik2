package blatt05;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class Aufgabe17bController implements Initializable {

	@FXML
	private ChoiceBox<String> visibilityBox;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		visibilityBox.getItems().addAll("private","public","protected");
		visibilityBox.getSelectionModel().select(0);
	}
}
