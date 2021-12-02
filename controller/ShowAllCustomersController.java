package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ShowAllCustomersController extends Controller<Kiosk>{

	@FXML private TableView<Customer> removeCustomer;
	
	public final Kiosk getKiosk() {
		return model;
	}
	
	public final Catalogue getCatalogue() {
		return model.getCatalogue();
	}
	
	@FXML
	  private void close() {
		  stage.close();  
	  }

}
