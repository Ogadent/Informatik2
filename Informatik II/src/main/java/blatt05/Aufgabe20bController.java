package blatt05;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class Aufgabe20bController implements Initializable {

	@FXML
	private CheckBox closeable;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setStage(Stage stage) {
		stage.setOnCloseRequest(e -> {
			if (!closeable.isSelected()) {
				e.consume();
			}
		});
	}
}
