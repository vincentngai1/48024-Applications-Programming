
package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Catalogue;
import model.Customer;
import model.Kiosk;
import model.Movie;

public class ReturnMovieController extends Controller<Kiosk>{
	@FXML private Text returnText;
	@FXML private TextField setNumber;
	@FXML private TableView<Movie> returnMovies;
	@FXML private Button readingcustomerRecord;
	@FXML private Button rentselectedMovie;
	
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
			  returnMovies.setItems(getSelected().currentlyRented());
				 				
			}
		  }
		catch (Exception e) 
			{
			returnText.setText("Error");
			}
		 }

	  @FXML
	  	private void initialize() {
			setNumber.textProperty().addListener((o, oldText, newText) ->
			readingcustomerRecord.setDisable(newText == null));
			returnMovies.getSelectionModel().selectedItemProperty().addListener((o, old, now) ->
			rentselectedMovie.setDisable(getselectedMovie() == null));			
			}
	  
	  @FXML
	  	public Customer getSelected() {
		  return model.getCustomer(Integer.parseInt(setNumber.getText()));	
			}
	  @FXML
	  	public Movie getselectedMovie() {
	  		return returnMovies.getSelectionModel().getSelectedItem();
			}
			
	  	@FXML
	  	public void rentselectedMovie() {
	  		model.getCatalogue().returnMovieFromCustomer(getselectedMovie(),getSelected());
	  		returnText.setText("Movie Rented.");
	  		rentselectedMovie.setDisable(true);
	  		returnMovies.getSelectionModel().clearSelection();
			}
	     
	  
	  	@FXML
	  	private void close() {
		  stage.close();  
	  }

}
