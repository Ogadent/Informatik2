package blatt05;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;

public class Aufgabe20aController implements Initializable {

	@FXML
	private Label text;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setScene(final Scene scene) {
		scene.setOnKeyPressed(event -> {
			Font original = text.getFont();
			if (event.getCode() == KeyCode.MINUS) {
				text.setFont(Font.font(original.getName(), Math.max(1, original.getSize() - 1)));
			} else if (event.getCode() == KeyCode.PLUS) {
				text.setFont(Font.font(original.getName(), original.getSize() + 1));
			}
		});
	}
}
