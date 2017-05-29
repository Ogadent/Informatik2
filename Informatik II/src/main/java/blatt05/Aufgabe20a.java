package blatt05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Aufgabe20a extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Aufgabe20a.fxml"));
		BorderPane root = loader.load();
		Aufgabe20aController controller = loader.getController();
		Scene scene = new Scene(root);
		controller.setScene(scene);
		primaryStage.setScene(scene);
		primaryStage.setTitle(getClass().getSimpleName());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
