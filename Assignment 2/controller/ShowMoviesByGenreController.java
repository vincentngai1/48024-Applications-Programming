package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ShowMoviesByGenreController extends Controller<Kiosk>{
	
	@FXML private ListView<Genre> listbyGenre;
	@FXML private TableView<Movie> tablebyGenre;
	
	public final Kiosk getKiosk() {
		return model;
	}
	
	public final Catalogue getCatalogue() {
		return model.getCatalogue();
	}
	
	private Genre typeofGenre(){
		return listbyGenre.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	private void listMovie(ActionEvent event) {
		Genre genre = typeofGenre();
		if (genre != null){
			tablebyGenre.setItems(getKiosk().getCatalogue().getMoviesInGenre(genre));
		}
	}
	
	@FXML
	  private void close() {
		  stage.close();  
	  }

}
