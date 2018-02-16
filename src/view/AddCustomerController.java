package view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import application.Main;
import dao.CustomerDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Customer;

public class AddCustomerController {

	@FXML
	private AnchorPane root;

	@FXML
	private JFXHamburger hbMenu;

	@FXML
	private JFXDrawer drawer;

	@FXML
	private JFXButton btAdd;

	@FXML
	private JFXButton btCancel;

	
	@FXML
	private JFXTextField ztId;
	
	@FXML
	private JFXTextField ztFirstName;

	@FXML
	private JFXTextField ztLastName;

	@FXML
	private JFXTextField ztAddress;

	@FXML
	private JFXTextField ztPostalCode;
	
	@FXML
	private JFXTextField ztCity;

	@FXML
	private JFXTextField ztPhoneNumber;

	@FXML
	private JFXTextField ztEmailAddress;


	Main main;

	@FXML
	private Stage dialogStage;
  //----------------------------------------------------------------------------------------------------


	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	


	@FXML
	void handleDeleteCustom(ActionEvent event) {

	}

	@FXML
	void handleEditDialog(ActionEvent event) {

	}
	
	//--------------------------------------------------------------------------------------------------	

	public void setMainApp(Main main) {
		this.main = main;

	}


	//----------------------------------------------------------------------------------------------------
	public void initialize() {
		//        rootP = root;

		try {
			VBox box = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
			drawer.setSidePane(box);
			drawer.open();
		} catch (IOException ex) {
			Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
		}



		HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hbMenu);
		transition.setRate(-1);
		hbMenu.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
			transition.setRate(transition.getRate()*-1);
			transition.play();

			if(drawer.isShown())
			{
				drawer.close();
			}else
				drawer.open();
		});
	}

	//---------------------------------------------------------------------------------------------------
	
	public void AddToDbCust(){
		
		CustomerDao custDao= new CustomerDao();
		
		String id=null;
		String firstName=ztFirstName.getText();
		String lastName=ztLastName.getText();
		String address=ztAddress.getText();
		String postalCode=ztPostalCode.getText();
		String city=ztCity.getText();
		String phoneNumber=ztPhoneNumber.getText();
		String email=ztEmailAddress.getText();
		
		Customer cust= new Customer(id, firstName, lastName, address, postalCode, city, phoneNumber, email);
		custDao.addCustomer(cust);
		Boolean ok=custDao.addCustomer(cust);
		
		if(ok){
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("The customer has been created");
			alert.setHeaderText(null);
			alert.setContentText("The chosen customer has been created successfully");

			alert.showAndWait();
			
		}
		
	
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	public void refreshFields(){
		
		ztFirstName.setText("");
		ztLastName.setText("");
		ztAddress.setText("");
		ztPostalCode.setText("");
		ztCity.setText("");
		ztPhoneNumber.setText("");
		ztEmailAddress.setText("");
	}
	
	//---------------------------------------------------------------------------------------------------------------
	

}

