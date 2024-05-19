package application.Boundary;

import java.io.IOException;

import application.Main;
import application.Controller.CreatePropertyController;
import application.Controller.UpdatePropertyController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpdatePropertyBoundary {
	
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
    private Button updatePropertyBtn,backBtn;

    @FXML
    private TextField typeTextField;
    
    @FXML
    private TextField idTextField;
	
	
	public void updateProperty(ActionEvent event) throws IOException{
		UpdatePropertyController.updateProperty(Integer.parseInt(idTextField.getText()),locationTextField.getText(),Integer.parseInt(roomTextField.getText()), typeTextField.getText(),
				conditionTextField.getText(),Double.parseDouble(priceTextField.getText()), agentTextField.getText(), "Agent", sellerTextField.getText(), "Seller", statusTextField.getText());
		
		Alert reviewAlert = new Alert(Alert.AlertType.INFORMATION);
		reviewAlert.setTitle("Update Dialog");
		reviewAlert.setContentText("You have updated the listing, go back to see changes!");
		reviewAlert.setHeaderText("PropertyListing Updated!");
		reviewAlert.showAndWait();
	}
	
	
	public void backToManageScene(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("AgentManageListing.fxml");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
