package blatt05;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Aufgabe19bController implements Initializable {

	@FXML
	private TextArea textArea;
	
	@FXML
	private Button button;
	
	private Stage stage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textArea.managedProperty().bind(textArea.visibleProperty());
	}

	@FXML
	public void bemerkung() {
		if (textArea.isVisible()) {
			button.setText("Bemerkung");
		} else {
			button.setText("Keine Bemerkung");
		}
		textArea.setVisible(!textArea.isVisible());
		stage.sizeToScene();
	}
	
	public void setScene(Stage stage) {
		this.stage = stage;
	}
}
