package blatt05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Aufgabe18b extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = FXMLLoader.load(getClass().getResource("Aufgabe18b.fxml"));
		Scene scene = new Scene(root, 200, 200);
		primaryStage.setScene(scene);
//		warum aufgabe18d?
		primaryStage.setTitle("Aufgabe18d");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
