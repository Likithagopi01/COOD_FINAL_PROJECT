package application;

import edu.northeastern.tableModels.ItineraryTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class AdminAddController{


	    @FXML
	    private TableColumn<ItineraryTable, String> col_arrive;

	    @FXML
	    private TableColumn<ItineraryTable, String> col_depart;

	    @FXML
	    private TableColumn<ItineraryTable, String> col_from;

	    @FXML
	    private TableColumn<ItineraryTable, String> col_id;

	    @FXML
	    private TableColumn<ItineraryTable, String> col_to;

	    @FXML
	    private TextField filterField;

	    @FXML
	    private TableColumn<ItineraryTable, String> mode;

	    @FXML
	    private TableView<ItineraryTable> table_users;

	    @FXML
	    private TextField txt_arrive;

	    @FXML
	    private TextField txt_depart;

	    @FXML
	    private TextField txt_from;

	    @FXML
	    private TextField txt_id;

	    @FXML
	    private TextField txt_mode;

	    @FXML
	    private TextField txt_to;

	    @FXML
	    void Add_trips(ActionEvent event) {

      //admin adds the trip
	    	
	    }

	    @FXML
	    void getSelected(MouseEvent event) {

	    }

	    @FXML
	    void search_mode(KeyEvent event) {

	    }

	}

