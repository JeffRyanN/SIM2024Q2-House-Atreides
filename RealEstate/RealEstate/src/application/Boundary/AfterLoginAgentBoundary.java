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

public class AfterLoginAgentBoundary {
	private Stage stage;
	private Scene scene;
	@FXML
	private Button agentSceneBtn, agentManageBtn, logOutBtn;
	
	
	
	public void switchToProfileScene(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("AgentProfile.fxml");
	}
	
	public void switchToManageScene(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("AgentManageListing.fxml");
	}
	
	public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}
	
	
	
	
}
