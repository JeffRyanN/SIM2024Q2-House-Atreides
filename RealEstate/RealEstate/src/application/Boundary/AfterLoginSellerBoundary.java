package application.Boundary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AfterLoginSellerBoundary {
	
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private Label agentName , agentID, agentAgency, agentRating;
	@FXML
	private Button myListingBtn, rateAgentBtn, logoutBtn;
	
	
	public void switchToRateAgentScene(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("rateAgentMenuSeller.fxml");
	}
	
	public void switchToMyListingScene(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("SellerListing.fxml");
	}
	
	public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}
	
	//logout button script
//	public void switchToLoginPage(ActionEvent event) throws IOException{
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("logout.fxml"));
//		root = loader.load();
//		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
//		
//	}

}
