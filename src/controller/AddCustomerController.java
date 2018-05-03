package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import application.Main;
import dao.ClientDao;
import dao.EtatClientDao;
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
import model.Client;


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
	
	@FXML
	private JFXComboBox <String>etatClient;
	
	@FXML
	private JFXTextArea informations; 
	
	EtatClientDao edao= new EtatClientDao();

	Main main;

	@FXML
	private Stage dialogStage;
	// ----------------------------------------------------------------------------------------------------

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
	public void initialiseComboBox(){
	
		etatClient.getItems().addAll(edao.retournerLibelleEtat());
		
	}

	// --------------------------------------------------------------------------------------------------

	public void setMainApp(Main main) {
		this.main = main;

	}

	// ----------------------------------------------------------------------------------------------------
	public void initialize() {
		// rootP = root;

		try {
			VBox box = FXMLLoader.load(getClass().getResource("../view/MenuView.fxml"));
			drawer.setSidePane(box);
			drawer.open();
		} catch (IOException ex) {
			Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
		}

		HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hbMenu);
		transition.setRate(-1);
		hbMenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			transition.setRate(transition.getRate() * -1);
			transition.play();

			if (drawer.isShown()) {
				drawer.close();
			} else
				drawer.open();
		});
	}

	// ---------------------------------------------------------------------------------------------------

	public void AddToDbCust() {

		ClientDao custDao = new ClientDao();

		Integer id = null;
		String prenom = ztFirstName.getText();
		String nom = ztLastName.getText();
		String adresse = ztAddress.getText();
		String codePostal = ztPostalCode.getText();
		String ville = ztCity.getText();
		String numTel = ztPhoneNumber.getText();
		String email = ztEmailAddress.getText();
		String informations= this.informations.getText();
		Integer idEtat=(edao.retournerIdEtat(etatClient.getValue()));

		Client cust = new Client(id, prenom, nom, adresse, codePostal, ville, numTel, email, informations,idEtat);
		custDao.ajouterCli(cust);
		Boolean ok = custDao.ajouterCli(cust);

		if (ok) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Le client a bien été ajouté");
			alert.setHeaderText(null);
			alert.setContentText("Le client et ses informations ont bien été crées dans la base client");

			alert.showAndWait();

		}

	}

	// -----------------------------------------------------------------------------------------------------------------
	public void refreshFields() {

		ztFirstName.setText("");
		ztLastName.setText("");
		ztAddress.setText("");
		ztPostalCode.setText("");
		ztCity.setText("");
		ztPhoneNumber.setText("");
		ztEmailAddress.setText("");
		etatClient.setValue(null);
		informations.setText("");
	}

	// ---------------------------------------------------------------------------------------------------------------

}
