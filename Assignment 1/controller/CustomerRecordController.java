package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.*;

public class CustomerRecordController extends Controller<Kiosk>{
	  @FXML private Text addcustomerText;
	  @FXML private TextField setNumber;
	  @FXML private TableView<Movie> rentedMovies;
	  @FXML private TableView<Movie> rentingHistory;
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
			addcustomerText.setText(getSelected().toString());
			rentedMovies.setItems(getSelected().currentlyRented());
			rentingHistory.setItems(getSelected().rentingHistory());
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
