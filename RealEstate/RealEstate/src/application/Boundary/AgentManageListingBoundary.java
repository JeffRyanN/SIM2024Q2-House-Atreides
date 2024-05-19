package application.Boundary;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.Controller.RemovePropertyController;
import application.Controller.ViewPropertyListingsController;
import application.Entity.IdPass;
import application.Entity.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AgentManageListingBoundary implements Initializable {

	private Stage stage;
	private Scene scene;

	@FXML
	private TableColumn<Property, String> agentColumn;
	@FXML
	private TableColumn<Property, String> conditionColumn;
	@FXML
	private TableColumn<Property, Integer> idColumn;
	@FXML
	private TableColumn<Property, String> locationColumn;
	@FXML
	private TableColumn<Property, Double> priceColumn;
	@FXML
	private TableColumn<Property, Integer> roomColumn;
	@FXML
	private TableColumn<Property, String> sellerColumn;
	@FXML
	private TableColumn<Property, String> typeColumn;
	@FXML
	private TableView<Property> table;

	@FXML
	private TextField searchTextField;

	@FXML
	private Label typeDetailLabel;
	@FXML
	private Button updatePropertyBtn, searchPropertyBtn, backBtn, addPropertyBtn, removePropertyBtn;

	ObservableList<Property> array1 = ViewPropertyListingsController.retriveData();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// TODO Auto-generated method stub
		idColumn.setCellValueFactory(new PropertyValueFactory<Property, Integer>("propertyId"));

		typeColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("propertyType"));

		roomColumn.setCellValueFactory(new PropertyValueFactory<Property, Integer>("room"));

		locationColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("location"));

		conditionColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("condition"));

		priceColumn.setCellValueFactory(new PropertyValueFactory<Property, Double>("price"));

		agentColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("agent"));

		sellerColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("seller"));
		this.table.setItems(array1);

	}

	public void rowClicked(MouseEvent event) {
		Property clickedUser = table.getSelectionModel().getSelectedItem();
		IdPass.id = clickedUser.getPropertyId();
		typeDetailLabel.setText(String.valueOf(clickedUser.getPropertyType()));
	}

	public void searchTable(String type) {
		ObservableList<Property> searchList = FXCollections.observableArrayList();
		for (Property property : array1) {
			if (property.getCondition().equals(type)) {
				searchList.add(property);
			}
		}
		table.setItems(searchList);
	}

	public void searchButtonAction(ActionEvent event) throws IOException {
		String type = searchTextField.getText().toString().trim();
		searchTable(type);
	}

	public void switchToHomepageScene(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("afterLoginAgent.fxml");
	}

	public void changeToAddScene(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("addProperty.fxml");
	}

	public void changeToUpdateScene(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("updateProperty.fxml");
	}

	public void removeProperty(ActionEvent event) throws IOException {
		
		try {
		Property propertyToDelete = table.getSelectionModel().getSelectedItem();
		RemovePropertyController.removePropertyListing(propertyToDelete.getPropertyId());

		ObservableList<Property> allProperty, selectedProperty;
		allProperty = table.getItems();
		selectedProperty = table.getSelectionModel().getSelectedItems();
		selectedProperty.forEach(allProperty::remove);}
		catch(Exception e){
			Alert reviewAlert = new Alert(Alert.AlertType.ERROR);
			reviewAlert.setTitle("ERROR DIALOG");
			reviewAlert.setContentText("You have not selected a listing to delete!! Click on a row in the table below!");
			reviewAlert.setHeaderText("NO SELECTION!");
			reviewAlert.showAndWait();
		}
	}

}
