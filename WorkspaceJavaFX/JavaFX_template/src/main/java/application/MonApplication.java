package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MonApplication extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/vues/Vue.fxml"));
			Scene scene = new Scene(root,600,600);
			stage.setScene(scene);
			stage.setTitle("Chaines");
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
