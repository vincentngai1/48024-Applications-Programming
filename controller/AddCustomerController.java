
package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.*;


public class AddCustomerController extends Controller<Kiosk>{
	@FXML private TextField idName;
	@FXML private TextField nameName;
	@FXML private TextField balanceName;
	@FXML private Text addcustomerText;
	
	public final Kiosk getKiosk() { return model;}
	public final Catalogue getCatalogue() { return model.getCatalogue();}
	
	@FXML
	  private void addCustomer(ActionEvent event) {
		int id = Integer.parseInt(idName.getText());
		String name = nameName.getText();
		int balance = Integer.parseInt(balanceName.getText());
		getKiosk().addCustomer(id, name, balance);
		addcustomerText.setText("Customer added to Kiosk.");
	  }
	
	@FXML
	  private void close() {
		  stage.close();  
	  }

}
