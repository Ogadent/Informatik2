package blatt05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Aufgabe17b extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = FXMLLoader.load(getClass().getResource("Aufgabe17b.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle(getClass().getSimpleName());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
