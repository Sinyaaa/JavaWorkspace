package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MonApplication extends Application {
	@Override
	public void start(Stage stage) {
		try {
			BorderPane root = new BorderPane();
			Label label = new Label("Hello World");
			
			Scene scene = new Scene(root,200,100);
			
			root.setCenter(label);
			
			stage.setScene(scene);
			stage.setTitle("Fiche 1 Exercice 1");
			stage.setOnCloseRequest(x->Platform.exit());
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void lancer(String[] args) {
		MonApplication.launch(args);
		
	}

}
