package blatt05;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aufgabe19cController implements Initializable {

	@FXML
	private Text text;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
	}

	public void setStage(Stage stage) {
		stage.focusedProperty().addListener((obs, oldVal, newVal) -> {
			if (newVal.booleanValue()) {
				text.setText("Aktiviert");
			} else {
				text.setText("Deaktiviert");
			}
		});
	}
}
