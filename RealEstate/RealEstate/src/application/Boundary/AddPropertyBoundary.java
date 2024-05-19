package application.Boundary;

import java.io.IOException;

import com.sun.prism.PixelFormat.DataType;

import application.Main;
import application.Controller.CreatePropertyController;
import application.Entity.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPropertyBoundary {
	
	@FXML
    private TextField agentTextField;

    @FXML
    private TextField conditionTextField;

    @FXML
    private TextField statusTextField;

    @FXML
    private TextField locationTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField roomTextField;

    @FXML
    private TextField sellerTextField;

    @FXML
    private Button submitPropertyBtn,backBtn;

    @FXML
    private TextField typeTextField;
    
  
	
			
	
	
	public void submitProperty(ActionEvent event) throws IOException{
		CreatePropertyController.createProperty(locationTextField.getText(),Integer.parseInt(roomTextField.getText()), typeTextField.getText(),
				conditionTextField.getText(),Double.parseDouble(priceTextField.getText()), agentTextField.getText(), "Agent", sellerTextField.getText(), "Seller", statusTextField.getText());

		Alert reviewAlert = new Alert(Alert.AlertType.INFORMATION);
		reviewAlert.setTitle("Submit Dialog");
		reviewAlert.setContentText("You have created a new listing, go back to see changes!");
		reviewAlert.setHeaderText("PropertyListing Created!");
		reviewAlert.showAndWait();
		
	}
	
	
	public void backToManageScene(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("AgentManageListing.fxml");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
