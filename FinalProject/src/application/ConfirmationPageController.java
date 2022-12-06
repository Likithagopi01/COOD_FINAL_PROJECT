package application;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import edu.northeastern.models.BusTicket;
import edu.northeastern.models.Customer;
import edu.northeastern.models.FlightTickets;
import edu.northeastern.models.Itinerary;
import edu.northeastern.models.TrainTickets;
import edu.northeastern.models.TravelTickets;
import edu.northeastern.tableModels.ItineraryTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class ConfirmationPageController implements Initializable{
    @FXML
    private TableColumn<ItineraryTable, String> arrivCol;

    @FXML
    private TableColumn<ItineraryTable, Double> costCol;

    @FXML
    private TableColumn<ItineraryTable, String> departCol;

    @FXML
    private TableColumn<ItineraryTable, String> fromCol;

    @FXML
    private TableView<ItineraryTable> itineraryTable;

    @FXML
    private TableColumn<ItineraryTable, String> toCol;
    
    @FXML
    private TableColumn<ItineraryTable, String> carrierCol;
    
    @FXML
    private TableColumn<ItineraryTable, String> routeCol;


    @FXML
    private TableColumn<ItineraryTable, String> typeCol;
    
    @FXML
    private Button back;
	
	Itinerary itinerary;
	ArrayList<TravelTickets> routes;
	Customer customer;

	private ArrayList<ArrayList<TravelTickets>> allTickets;
	
	public ConfirmationPageController(Itinerary itinerary, ArrayList<TravelTickets> routes, Customer customer,
			ArrayList<ArrayList<TravelTickets>> allTickets) {
		this.routes=routes;
		this.itinerary=itinerary;
		this.allTickets=allTickets;
		this.customer=customer;
	}


	@FXML
    void goBack(ActionEvent event) throws IOException {
		Main main = new Main();
		SearchResultsController searchResultsController=new SearchResultsController(allTickets, customer);
		main.changeScene("SearchResult.fxml", searchResultsController);
    }

	@FXML
    void goToPayment(ActionEvent event) throws IOException {
		Main main = new Main();
		PaymentController paymentController = new PaymentController(customer, routes, itinerary);
		main.changeScene("PaymentPage.fxml", paymentController);
    }
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		arrivCol.setCellValueFactory(new PropertyValueFactory<>("arrival"));
		costCol.setCellValueFactory(new PropertyValueFactory<>("cost"));
		departCol.setCellValueFactory(new PropertyValueFactory<>("departure"));
		arrivCol.setCellValueFactory(new PropertyValueFactory<>("arrival"));
		fromCol.setCellValueFactory(new PropertyValueFactory<>("from"));
		toCol.setCellValueFactory(new PropertyValueFactory<>("to"));
		typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
		routeCol.setCellValueFactory(new PropertyValueFactory<>("travelId"));
		carrierCol.setCellValueFactory(new PropertyValueFactory<>("carrier"));
			
		for(TravelTickets ticket:this.routes) {
			ItineraryTable itinerary = new ItineraryTable();
			itinerary.setFrom(ticket.getFromLocation().getLocationName());
			itinerary.setTo(ticket.getToLocation().getLocationName());
			itinerary.setDeparture(ticket.getDepartureTime().toString());
			itinerary.setArrival(ticket.getArrivalTime().toString());
			itinerary.setCost(ticket.getCost());
			
			itinerary.setTravelId(ticket.getTicketID());
			if(ticket instanceof BusTicket) {
				itinerary.setType("Bus");
				itinerary.setCarrier(ticket.getCarrier());
				BusTicket newTicket = (BusTicket) ticket;
				itinerary.setTravelId(newTicket.getBusNo());
			}
			else if(ticket instanceof TrainTickets) {
				itinerary.setType("Train");
				itinerary.setCarrier(ticket.getCarrier());
				TrainTickets newTicket = (TrainTickets) ticket;
				itinerary.setTravelId(newTicket.getTrainNo());
			}
			else {
				itinerary.setType("Flight");
				FlightTickets newTicket = (FlightTickets) ticket;
				itinerary.setCarrier(newTicket.getCarrier());
				itinerary.setTravelId(newTicket.getFlightNo());
			}
			itineraryTable.getItems().add(itinerary);
		}
		
	}

}
