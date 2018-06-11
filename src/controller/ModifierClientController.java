package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import dao.ClientDao;
import dao.EtatClientDao;
import dao.ZoneDao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Client;

public class ModifierClientController {
	
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
    private JFXComboBox <String>zoneGeo= new JFXComboBox<String>();
    
    @FXML
    private Label idClient;
    
    @FXML
    private JFXTextField commercial;
    

    @FXML
    private JFXButton btFermer;

    @FXML
    private JFXButton btValider;
    
	@FXML
	private Stage dialogStage;
	
	EtatClientDao edao= new EtatClientDao();
	ZoneDao zdao= new ZoneDao();
  //----------------------------------------------------------------------------------------------------


	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	// ----------------------------------------------------------------------------------------------------
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
		zoneGeo.getItems().addAll(zdao.renvoyerNomZones());
		zoneGeo.setValue(zdao.renvoyerLibelle(cli.idZone()));
		etatClient.getItems().addAll(edao.renvoyerLibelleEtat());
		etatClient.setValue(edao.afficherLibelleEtat(cli.idEtat()));
		commercial.setText(cli.idCommercial().toString());

	}

	// -----------------------------------------------------------------------------------------------------
	public void updateCustomer() {
		
	ClientDao cdao= new ClientDao();
	//on recup�re chaque champs du formulaire
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
	String zonegeo= zoneGeo.getValue();
	Integer idCommercial= (Integer.parseInt(commercial.getText()));
	
	if ( firstName.equals("")|| lastName.equals("")|| address.equals("") || postalCode.equals("") || city.equals("")||
			phoneNumber.equals("") || email.equals("")|| informations.equals("") ||idEtat.equals("")|| zoneGeo.equals("")){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Champs vides");
		alert.setHeaderText(null);
		alert.setContentText("Aucun champs ne peuvent �tre laiss�s vide. Recommencer la saisie.");

		alert.showAndWait();
		
	}
	else{
	
	//on cr�e � partir de ces champs un nouveau client 
	Client customer= new Client(idCli,firstName, lastName, address, postalCode, city, phoneNumber, email ,
			informations,zdao.retournerIdZone(zonegeo),edao.retournerIdEtat(idEtat),idCommercial );
	//on le modifie en base de donn�es, et on v�rifie si la modification a bien eut lieu, si oui on le notifie � l'utilisateur
	Boolean ok= cdao.updateCustomer(customer);
	if (ok){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Le client a �t� modifi�");
		alert.setHeaderText(null);
		alert.setContentText("Le client s�lectionn� a bien �t� modifi�");

		alert.showAndWait();
		
	}
	}
		
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------
	public void closeWindow(){
		
	dialogStage.close();
	
		
	}



}
