package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import dao.ClientDao;
import dao.EtatClientDao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Client;

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
    private JFXTextArea informations;
    
    @FXML
    private JFXComboBox <String>etatClient= new JFXComboBox<String>();
    
    @FXML
    private Label idClient;

    @FXML
    private JFXButton btFermer;

    @FXML
    private JFXButton btValider;
    
	@FXML
	private Stage dialogStage;
	
	EtatClientDao edao= new EtatClientDao();
  //----------------------------------------------------------------------------------------------------


	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	//----------------------------------------------------------------------------------------------------
	public void setCustomer(Client cli) {
		
	idClient.setText(cli.idClient().toString());
	firstNameCust.setText(cli.prenomClient());
	lastNameCust.setText(cli.nomClient());
	addressCust.setText(cli.adresseClient());
	postalCodeCust.setText(cli.codePostal());
	cityCust.setText(cli.villeClient());
	phoneNumberCust.setText(cli.numeroTelClient());
	emailAddressCust.setText(cli.emailClient());
	informations.setText(cli.informationsClient());
	
	 etatClient.getItems().addAll(edao.retournerLibelleEtat());
	 etatClient.setValue(edao.afficherLibelleEtat(cli.idEtat()));
	
	
		
	}
	
	//-----------------------------------------------------------------------------------------------------
	public void updateCustomer(){
		
	ClientDao cdao= new ClientDao();
	Integer idCli= (Integer.parseInt(idClient.getText()));
	String firstName=firstNameCust.getText();
	String lastName=lastNameCust.getText();
	String address= addressCust.getText();
	String postalCode= postalCodeCust.getText();
	String city= cityCust.getText();
	String phoneNumber= phoneNumberCust.getText();
	String email= emailAddressCust.getText();
	String informations= this.informations.getText();
	String idEtat= etatClient.getValue();
	
	
	Client customer= new Client(idCli,firstName, lastName, address, postalCode, city, phoneNumber, email, informations,edao.retournerIdEtat(idEtat));
	cdao.updateCustomer(customer);
	Boolean ok= cdao.updateCustomer(customer);
	if (ok){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Le client a été modifié");
		alert.setHeaderText(null);
		alert.setContentText("Le client sélectionné a bien été modifié");

		alert.showAndWait();
		
	}
		
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------
	public void closeWindow(){
		
	dialogStage.close();
	
		
	}



}
