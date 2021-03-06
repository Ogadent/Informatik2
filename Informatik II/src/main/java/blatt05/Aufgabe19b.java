package blatt05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Aufgabe19b extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Aufgabe19b.fxml"));
		BorderPane root = loader.load();
		Aufgabe19bController controller = loader.getController();
		controller.setScene(primaryStage);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle(getClass().getSimpleName());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
