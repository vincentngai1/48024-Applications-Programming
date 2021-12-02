
package controller;


import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.*;

public class AddMovieController extends Controller<Kiosk>{
	@FXML private TextField titleName;
	@FXML private TextField yearName;
	@FXML private TextField genreName;
	@FXML private TextField priceName;
	@FXML private Text addmovieText;

	public final Kiosk getKiosk() { return model;}
	public final Catalogue getCatalogue() { return model.getCatalogue();}

	@FXML
	  private void addMovie(ActionEvent event) {
		String title = titleName.getText();
		int year = Integer.parseInt(yearName.getText());
		String genre = genreName.getText();
		int price = Integer.parseInt(priceName.getText());
		getCatalogue().addMovie(title, year, genre, price);
		addmovieText.setText("Movie added to Catalogue.");
	  }
	@FXML
	  private void close() {
		  stage.close();  
	  }
}
