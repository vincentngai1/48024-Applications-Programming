package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.*;
import javafx.scene.text.Text;

public class FavouriteMoviesController  extends Controller<Kiosk>{
	  @FXML private TextField setNumber;
	  @FXML private TableView<Movie> favouriteMovies;
	  @FXML private Text addcustomerText;
	  @FXML private Button readingcustomerRecord;
	  
	  public final Kiosk getKiosk() {
	        return model;
	    }
	  public final Catalogue getCatalogue() {
		  return model.getCatalogue();
	  }
	  
	  @FXML
		public void readingcustomerRecord() {
		  try {
		  if (getSelected() !=null) 
			{
				favouriteMovies.setItems(getSelected().favouriteMovies());
	  
			}
		  }
		  catch (Exception e) 
			{
				addcustomerText.setText("Error");
			}
	  }
	  
		@FXML
		 private void initialize() {
			setNumber.textProperty().addListener((o, oldText, newText) ->
			readingcustomerRecord.setDisable(newText == null));
			}
	  
	 @FXML
		public Customer getSelected() {
			return model.getCustomer(Integer.parseInt(setNumber.getText()));
					
	 }
	@FXML
	  private void close() {
		  stage.close();  
	  }

}
