package view;

import com.jfoenix.controls.JFXButton;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MenuController {
	
	
	@FXML
	private JFXButton btViewCust;

	@FXML
	private JFXButton btAddCust;

	@FXML
	private JFXButton btSearch;
	
	@FXML
	private JFXButton btTradeVisit;
	
	private Main main= new Main();
	
	//-------------------------------------------------------------------------------------------------------
	
	public void addCustomer(){
		
	main.showAddCustomer();	
	
	
	}
	
	public void viewCust(){
	    // get a handle to the stage
	    Stage stage = (Stage) btViewCust.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	public void searchCustomer(){
		
		main.showSearchCustomer();
	}
	
	public void tradeVisitAnalysis(){
		
		main.showTradeVisitsAnalysis();
	}
	
	
	

}
