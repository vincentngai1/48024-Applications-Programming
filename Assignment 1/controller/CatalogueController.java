package controller;

import java.io.IOException;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.*;

public class CatalogueController extends Controller<Kiosk>{	
	
	  public final Kiosk getKiosk() {
	        return model;
	    }
	  public final Catalogue getCatalogue() {
		  return model.getCatalogue();
	  }
	  
	  @FXML
	  private void allMovies() throws IOException {
		  ViewLoader.showStage(getKiosk(), "/view/ShowAllMovies.fxml", "All Movies", new Stage());
	  }
	  @FXML
	  private void availableMovies() throws IOException {
		  ViewLoader.showStage(getKiosk(), "/view/ShowAvailableMovies.fxml", "Available Movies", new Stage());
	  }
	  @FXML
	  private void moviesbyGenre() throws IOException {
		  ViewLoader.showStage(getKiosk(), "/view/ShowMoviesByGenre.fxml", "Movies by Genre", new Stage());
	  }
	  @FXML
	  private void moviesbyYear() throws IOException {
		  ViewLoader.showStage(getKiosk(), "/view/ShowMoviesByYear.fxml", "Movies by Year", new Stage());
	  }
	  @FXML
	  private void rentaMovie() throws IOException {
		  ViewLoader.showStage(getKiosk(), "/view/RentMovie.fxml", "Rent a Movie", new Stage());
	  }
	  @FXML
	  private void returnaMovie() throws IOException {
		  ViewLoader.showStage(getKiosk(), "/view/ReturnMovie.fxml", "Return a Movie", new Stage());
	  }

	@FXML
	  private void close() {
		  stage.close();  
	  }
}

