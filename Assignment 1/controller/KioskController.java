package controller;
import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.*;

public class KioskController extends Controller<Kiosk> {

  @FXML
  public void initialize() {

  }

  public final Kiosk getKiosk() {
        return model;
    }
  public final Catalogue getCatalogue() {
	  return model.getCatalogue();
  }
  @FXML
  private void Admin() throws IOException {
	  ViewLoader.showStage(getKiosk(), "/view/Admin.fxml", "Administration Menu", new Stage());
  }
  @FXML
  private void Catalogue() throws IOException {
	  ViewLoader.showStage(getKiosk(), "/view/Catalogue.fxml", "Explore Catalogue", new Stage());
  }
  @FXML
  private void customerRecord() throws IOException {
	  ViewLoader.showStage(getKiosk(), "/view/CustomerRecord.fxml", "Customer Record", new Stage());
  }
  @FXML
  private void topUp() throws IOException {
	  ViewLoader.showStage(getKiosk(), "/view/TopUpAccount.fxml", "Top-up Account", new Stage());
  }
  @FXML
  private void favouriteMovies() throws IOException {
	  ViewLoader.showStage(getKiosk(), "/view/FavouriteMovies.fxml", "Favourite Movies", new Stage());
  }
  @FXML
  private void close() {
	  Platform.exit();
  }
  
}
