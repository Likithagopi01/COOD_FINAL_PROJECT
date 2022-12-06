package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.northeastern.models.Customer;
import edu.northeastern.models.Manager;
import edu.northeastern.service.CustomerService;
import edu.northeastern.service.ManagerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AdminLoginController {

    @FXML
    private PasswordField adminPassword;

    @FXML
    private TextField adminUsername;

    @FXML
    private Button button;

    @FXML
    private Label wrongLogIn;
    
    @FXML
    private Button goBackButton;
    
    private String adminUName;
    private String adminPW;
    
 
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
    @FXML
    void goBack(ActionEvent event) throws IOException {
    	Main m = new Main();
    	SplashController splashController = new SplashController();
    	m.changeScene("SplashPage.fxml", splashController);
    }

    @FXML
    void signIn(ActionEvent event) {
    	this.adminUName = adminUsername.getText();
		this.adminPW = adminPassword.getText();
		if(event.getSource()==button) {
			ManagerService managerService = new ManagerService();
			try {
				Manager admin=managerService.login(this.adminUName, this.adminPW);
		    	Main m= new Main();
		    	AdminAddController adminAddController = new AdminAddController();
		    	m.changeScene("AdminAdd.fxml",adminAddController);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

    }

}
