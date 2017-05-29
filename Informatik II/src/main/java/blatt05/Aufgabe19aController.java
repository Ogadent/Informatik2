package blatt05;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Aufgabe19aController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {	
	}
	
	@FXML
	public void close() {
		Platform.exit();
	}
}
