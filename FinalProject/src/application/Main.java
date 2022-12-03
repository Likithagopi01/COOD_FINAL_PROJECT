package application;
	

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application{
	private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{    	
    	stg=primaryStage;
    	SplashController splashController = new SplashController();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SplashPage.fxml"));
		fxmlLoader.setController(splashController);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    public void changeScene(String fxml, Object controller) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
		fxmlLoader.setController(controller);
		Parent root = fxmlLoader.load();
        stg.getScene().setRoot(root);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
