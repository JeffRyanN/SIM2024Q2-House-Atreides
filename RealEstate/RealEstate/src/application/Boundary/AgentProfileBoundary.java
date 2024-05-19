package application.Boundary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JButton;

import org.controlsfx.control.Rating;

import application.Main;
import application.Controller.AgentProfileController;
import application.Controller.ViewPropertyListingsController;
import application.Entity.AccountPass;
import application.Entity.Property;
import application.Entity.Review;
import application.Entity.Seller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AgentProfileBoundary implements Initializable {
	private Stage stage;
	private Scene scene;
	@FXML
	private Button homepageSceneButton;
	@FXML
	private Label agentName, ratingNumericLabel;
	@FXML
	private Rating ratingStars;
	@FXML
	private TableView<Review> reviewTable;
	@FXML
	private TableColumn<Review, String> nameCol,profileCol,reviewCol;
	@FXML
	private TableColumn<Review, Integer> ratingCol;
	
	ObservableList<Review> array1 = AgentProfileController.fetchReviews(AccountPass.userName, AccountPass.profile);

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		agentName.setText(AccountPass.userName);
		ratingNumericLabel.setText(String.valueOf(AgentProfileController.getAvgRatings()));
		ratingStars.setRating(AgentProfileController.getAvgRatings());
		
		ratingCol.setCellValueFactory(new PropertyValueFactory<Review,Integer>("star"));
		reviewCol.setCellValueFactory(new PropertyValueFactory<Review,String>("review"));
		nameCol.setCellValueFactory(new PropertyValueFactory<Review,String>("username2"));
		profileCol.setCellValueFactory(new PropertyValueFactory<Review,String>("profile2"));
		
		reviewTable.setItems(array1);
	}

	public void switchToHomepageScene(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("afterLoginAgent.fxml");
	}

}

