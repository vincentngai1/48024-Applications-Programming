package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class RemoveCustomerController extends Controller<Kiosk>{

	@FXML private TableView<Customer> removeCustomer;
	
	public final Kiosk getKiosk() {
		return model;
	}
	
	public final Catalogue getCatalogue() {
		return model.getCatalogue();
	}
	public Customer getselectedCustomer() {
		return removeCustomer.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	public void removeselectedCustomer() {
		getKiosk().removeCustomer(getselectedCustomer());
	}
	
	@FXML
	  private void close() {
		  stage.close();  
	  }

}
