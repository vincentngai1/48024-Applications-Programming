package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class RemoveMovieController extends Controller<Kiosk>{
	
	@FXML private TableView<Movie> removeMovie;
	
	public final Kiosk getKiosk() {
		return model;
	}
	
	public final Catalogue getCatalogue() {
		return model.getCatalogue();
	}
	
	public Movie getselectedMovie() {
		return removeMovie.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	public void removeselectedMovie() {
		model.getCatalogue().removeMovie(getselectedMovie());
	}
	
	@FXML
	  private void close() {
		  stage.close();  
	  }

}
