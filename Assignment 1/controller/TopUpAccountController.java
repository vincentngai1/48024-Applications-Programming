package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.*;


public class TopUpAccountController extends Controller<Kiosk> {
	@FXML private TextField idName;
	@FXML private TextField topupName;
	@FXML private Text addtopupText;
	
	public final Kiosk getKiosk() { return model;}
	public final Catalogue getCatalogue() { return model.getCatalogue();}
	
	@FXML
	private void topupAccount(ActionEvent event) {
		int Customer = Integer.parseInt(idName.getText());
		int topUpAmount = Integer.parseInt(topupName.getText());		
		getKiosk().topUpAccount(getKiosk().getCustomer(Customer), topUpAmount);
		addtopupText.setText("Transaction Complete");
	  }
	
	@FXML
	  private void close() {
		  stage.close();  
	  }

}
