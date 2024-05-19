package application.Boundary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import org.controlsfx.control.Rating;

import application.Entity.Agent;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class MyAgentBoundary {
	private Stage stage;
	private Scene scene;
	@FXML
	private Label agentName, agentAgency, agentRating;
	@FXML
	private Button backbtn, rateAgentBtn, reviewAgentBtn;
	@FXML
	private ImageView sellerListingImage;
	@FXML
	private Rating rateAgent;
	@FXML
	private TextArea reviewText;
	
	
	public void displayInfo(String name, String agency) {
		//displays agent info from database
		agentName.setText(name);
		agentAgency.setText(agency);
		
	}
	
	public void handleRating(ActionEvent event) throws IOException{
		//rateAgent.getRating(); This return the rating of the user input rating, push to database
		Alert ratingAlert = new Alert(Alert.AlertType.INFORMATION);
		ratingAlert.setTitle("Submit Dialog");
		ratingAlert.setContentText("You have rated your agent!");
		ratingAlert.setHeaderText("Rate Agent");
		ratingAlert.showAndWait();
		
	}
	
	public void handleReview(ActionEvent event) throws IOException{
		//reviewText.getText(); This return the review of the seller, push to database
		Alert reviewAlert = new Alert(Alert.AlertType.INFORMATION);
		reviewAlert.setTitle("Submit Dialog");
		reviewAlert.setContentText("You have reviewed your agent!");
		reviewAlert.setHeaderText("Write a review for your agent!");
		reviewAlert.showAndWait();
	}
	
	public void switchToHomepageScene(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SellerHomepage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	

	
	

}
