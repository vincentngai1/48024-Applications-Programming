package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ShowMoviesByYearController extends Controller<Kiosk>{
	
	@FXML private ListView<Integer> listbyYear;
	@FXML private TableView<Movie> tablebyYear;
	
	public final Kiosk getKiosk() {
		return model;
	}
	
	public final Catalogue getCatalogue() {
		return model.getCatalogue();
	}
	
	private int getYear() {
		return listbyYear.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	private void listMovie() {
		int year = getYear();
		tablebyYear.setItems(getKiosk().getCatalogue().getMoviesByYear(year));
	}
	

	
	@FXML
	  private void close() {
		  stage.close();  
	  }

}
