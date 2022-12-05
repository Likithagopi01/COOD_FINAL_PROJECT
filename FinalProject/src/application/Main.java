package application;
	

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import edu.northeastern.models.Manager;
import edu.northeastern.service.ManagerService;
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


    public static void main(String[] args) throws Exception {
        launch(args);
//    	ManagerService ms = new ManagerService();
//		Manager manager = ms.login("admin@acap.com", "admin@123");
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a", Locale.ENGLISH);
//		String dateInString1 = "11-Dec-2022 01:30:00 PM";
//		String dateInString2 = "12-Dec-2022 12:30:00 AM";
//		String dateInString3 = "13-Dec-2022 10:30:00 AM";
//		String dateInString4 = "13-Dec-2022 01:30:00 PM";
//		Date date1 = (Date) formatter.parse(dateInString1);
//		Date date2 = (Date) formatter.parse(dateInString2);
//		Date date3 = (Date) formatter.parse(dateInString3);
//		Date date4 = (Date) formatter.parse(dateInString4);
//		ms.createTicket("Boston", "Mumbai", 20, "QT-619","Qatar" , 500, date1, date2, "Blue123");
////		ms.createTicket("Mumbai", "Boston", 20, "QT-916","Qatar" , 500, date1, date2, "Blue123");
//		ms.createTicket("Mumbai", "Hyderabad", 20, "IN-200","Indigo" , 500, date1, date2, "Blue12345");
////		ms.createTicket("Seattle", "Hyderabad", 20, "NY-200","Blue" , 500, date3, date4, "Blue12346");

    }
}
