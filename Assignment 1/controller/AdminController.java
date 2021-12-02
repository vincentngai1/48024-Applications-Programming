package controller;
import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.*;

public class AdminController extends Controller<Kiosk>{
    
	  public final Kiosk getKiosk() {
	        return model;
	    }
	  public final Catalogue getCatalogue() {
		  return model.getCatalogue();
	  }

	  @FXML
	  private void viewallCustomer() throws IOException {
		  ViewLoader.showStage(getKiosk(), "/view/ShowAllCustomers.fxml", "Show All Customers", new Stage());
	  }	  
	  @FXML
	  private void viewallMovie() throws IOException {
		  ViewLoader.showStage(getKiosk(), "/view/ShowAllMovies.fxml", "All Movies", new Stage());
	  }	
	  @FXML
	  private void addCustomer() throws IOException {
		  ViewLoader.showStage(getKiosk(), "/view/AddCustomer.fxml", "Add Customer", new Stage());
	  }	 
	  @FXML
	  private void addMovie() throws IOException {
		  ViewLoader.showStage(getKiosk(), "/view/AddMovie.fxml", "Add Movie", new Stage());
	  }	 
	  @FXML
	  private void removeCustomer() throws IOException {
		  ViewLoader.showStage(getKiosk(), "/view/RemoveCustomer.fxml", "Remove Customer", new Stage());
	  }	 
	  @FXML
	  private void removeMovie() throws IOException {
		  ViewLoader.showStage(getKiosk(), "/view/RemoveMovie.fxml", "Remove Movie", new Stage());
	  }
	  @FXML
	  private void close() {
		  stage.close(); 
	  }
	  
}
