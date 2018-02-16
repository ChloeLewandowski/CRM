package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;

import application.Main;
import dao.CustomerDao;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import model.Customer;

public class HomePageController {

	@FXML
	private TableView <Customer> tbCust;
	private Main main;

	@FXML
	private TableColumn<Customer, String> clIdCust;
	@FXML
	private TableColumn<Customer, String> clFirstNameCust;
	@FXML
	private TableColumn<Customer, String> clLastNameCust;
	@FXML 
	private Label firstName;
	@FXML
	private Label lastname;
	@FXML
	private Label address;
	@FXML
	private Label postalcode;
	@FXML
	private Label city;
	@FXML 
	private Label phonenumber;
	@FXML
	private Label email;
	@FXML
	private JFXButton btDelete;
	@FXML
	private JFXButton btAdd;
	@FXML
	private Button test;
	@FXML
	private Button testDelete;
	@FXML
	private JFXHamburger hbMenu;
	@FXML
	private JFXDrawer drawer;
	@FXML
	private AnchorPane root;
	@FXML
	private Label lbNumCpte;

	public static AnchorPane rootP;
	//--------------------------------------------------------------------------------------------------	

	public void setMainApp(Main main) {
		this.main = main;

	}

	//--------------------------------------------------------------------------------------------------	

	public void displayCustList(){

		CustomerDao custdao= new CustomerDao();
		ArrayList<Customer>listcustomer= new ArrayList();
		listcustomer=custdao.returnCustList();
		tbCust.setStyle("  -fx-background-color: white;  -fx-background-insets: 0, 1, 2;-fx-text-fill: -fx-selection-bar-text;");
		

		ObservableList<Customer> data= FXCollections.observableArrayList(listcustomer);
		tbCust.setItems(data);


		clIdCust.setCellValueFactory(cellData -> cellData.getValue().getIdCust());
		clFirstNameCust.setCellValueFactory(cellData -> cellData.getValue().getFirstNameCust());
		clLastNameCust.setCellValueFactory(cellData->cellData.getValue().getLastNameCust());




		tbCust.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> displayCustDetails(newValue));
	}





	public void displayCustDetails(Customer newValue){

		firstName.setText(newValue.firstName());
		lastname.setText(newValue.lastName());
		address.setText(newValue.address());
		postalcode.setText(newValue.postalCode());
		city.setText(newValue.city());
		phonenumber.setText(newValue.phoneNumber());
		email.setText(newValue.emailAddress());
		lbNumCpte.setText(newValue.idCust());

	}


	//--------------------------------------------------------------------------------------------------	


	private void handleDeleteCust(){

		CustomerDao cdao=new CustomerDao();
		int selectedIndex = tbCust.getSelectionModel().getSelectedIndex();

		if (selectedIndex >=0)
		{

			Customer cust= tbCust.getItems().get(selectedIndex);
			String idCust = cust.idCust();
			cdao.deleteCust(idCust);
			tbCust.getItems().remove(selectedIndex);
		}

		//rien n'a été sélectionné, on le notifie à l'utilisateur
		else {
			Main main= new Main();
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(main.getPrimaryStage());
			alert.setTitle("No Customer selected");
			alert.setHeaderText("None of the customers from the list have been selected");
			alert.setContentText("Please first select a customer to remove");

			alert.showAndWait();
		}

	}


	//------------------------------------------------------------------------------------------------------------------------------		



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
	
	//------------------------------------------------------------------------------------------------------------------------------------

	public void handleDeleteCustom(){

		CustomerDao cdao=new CustomerDao();
		int selectedIndex = tbCust.getSelectionModel().getSelectedIndex();

		if (selectedIndex >=0)
		{

			Customer cust= tbCust.getItems().get(selectedIndex);
			String idCust = cust.idCust();
			cdao.deleteCust(idCust);
			tbCust.getItems().remove(selectedIndex);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("The customer has been deleted");
			alert.setHeaderText(null);
			alert.setContentText("The chosen customer has been removed successfully");

			alert.showAndWait();
		}

		//rien n'a été sélectionné, on le notifie à l'utilisateur
		else {
			Main main= new Main();
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(main.getPrimaryStage());
			alert.setTitle("No Customer selected");
			alert.setHeaderText("None of the customers from the list have been selected");
			alert.setContentText("Please first select a customer to remove");

			alert.showAndWait();
		}


	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------
	
	public void handleEditDialog(){
		
		Customer selectedCust = tbCust.getSelectionModel().getSelectedItem();
		if (selectedCust != null) {

			main.EditCustomer(selectedCust);

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(main.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Customer Selected");
			alert.setContentText("Please select a custmer in the table before editing.");

			alert.showAndWait();
		}


	}

}








