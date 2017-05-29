package blatt05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aufgabe17a extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = FXMLLoader.load(getClass().getResource("Aufgabe17a.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle(getClass().getSimpleName());
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
