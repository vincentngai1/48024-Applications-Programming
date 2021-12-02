package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.*;

public class ShowAvailableMoviesController extends Controller<Kiosk>{
	
	@FXML private TableView<Movie> avaliableMovie;
	
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
