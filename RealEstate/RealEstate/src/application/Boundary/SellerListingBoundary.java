package application.Boundary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Controller.SellerController;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class SellerListingBoundary implements Initializable  {
	private Stage stage;
	private Scene scene;
	@FXML
	private Button backBtn;
	@FXML
	private Label viewCount, shortListCount;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SellerController sellerController = new SellerController();
		shortListCount.setText(String.valueOf(sellerController.getShortListCount()));
		viewCount.setText(String.valueOf(sellerController.getViewCount()));
	}
	
	

	public void switchToHomepageScene(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("afterLoginSeller.fxml");
	}



	
	
	

}
