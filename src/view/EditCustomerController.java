package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import dao.CustomerDao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Customer;

public class EditCustomerController {
	
    @FXML
    private JFXTextField idCust;

    @FXML
    private JFXTextField firstNameCust;

    @FXML
    private JFXTextField lastNameCust;
    
    @FXML
    private JFXTextField addressCust;

    @FXML
    private JFXTextField postalCodeCust;

    @FXML
    private JFXTextField cityCust;

    @FXML
    private JFXTextField phoneNumberCust;

    @FXML
    private JFXTextField emailAddressCust;

    @FXML
    private JFXButton btFermer;

    @FXML
    private JFXButton btValider;
	@FXML
	private Stage dialogStage;
  //----------------------------------------------------------------------------------------------------


	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	//----------------------------------------------------------------------------------------------------
	public void setCustomer(Customer cust) {
		
	idCust.setText(cust.idCust());
	firstNameCust.setText(cust.firstName());
	lastNameCust.setText(cust.lastName());
	addressCust.setText(cust.address());
	postalCodeCust.setText(cust.postalCode());
	cityCust.setText(cust.city());
	phoneNumberCust.setText(cust.phoneNumber());
	emailAddressCust.setText(cust.emailAddress());
	
	
		
	}
	
	//-----------------------------------------------------------------------------------------------------
	public void updateCustomer(){
		
	CustomerDao cdao= new CustomerDao();
	
	String id=idCust.getText();
	String firstName=firstNameCust.getText();
	String lastName=lastNameCust.getText();
	String address= addressCust.getText();
	String postalCode= postalCodeCust.getText();
	String city= cityCust.getText();
	String phoneNumber= phoneNumberCust.getText();
	String email= emailAddressCust.getText();
	
	Customer customer= new Customer(id, firstName, lastName, address, postalCode, city, phoneNumber, email);
	cdao.updateCustomer(customer);
	Boolean ok= cdao.updateCustomer(customer);
	if (ok){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("The customer has been updated");
		alert.setHeaderText(null);
		alert.setContentText("The chosen customer has been updated successfully");

		alert.showAndWait();
		
	}
		
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------
	public void closeWindow(){
		
	dialogStage.close();
	
		
	}



}
