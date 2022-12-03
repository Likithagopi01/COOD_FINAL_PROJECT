package application;

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
    
    private String adminUName;
    private String adminPW;
    
 
	public void initialize(URL arg0, ResourceBundle arg1) {

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
				AdminController adminController = new AdminController();
		    	m.changeScene("AdminView.fxml", adminController);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

    }

}
