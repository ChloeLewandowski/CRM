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
import dao.CommercialDao;
import dao.EtatClientDao;
import dao.ZoneDao;
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
import model.Commercial;


public class AjouterClientController {

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
	private JFXTextField prenom;

	@FXML
	private JFXTextField nom;

	@FXML
	private JFXTextField adresse;

	@FXML
	private JFXTextField codePostal;

	@FXML
	private JFXTextField ville;

	@FXML
	private JFXTextField numTel;

	@FXML
	private JFXTextField adresseMail;
	
	@FXML
	private JFXComboBox <String> etatClient;
	
	@FXML
	private JFXComboBox <String> zoneClient;
	
	@FXML
	private JFXComboBox <String> commercialResp;
	
	@FXML
	private JFXTextArea informations; 
	
	EtatClientDao edao= new EtatClientDao();
	ZoneDao zdao= new ZoneDao();
	CommercialDao cdao= new CommercialDao();

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
	//on alimente les combo box avec les données en base
	public void initialiseComboBox(){
	
		etatClient.getItems().addAll(edao.renvoyerLibelleEtat());
		zoneClient.getItems().addAll(zdao.renvoyerNomZones());
		commercialResp.getItems().addAll(cdao.renvoyerListeNoms());
		
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
		//on recupère les champs de chaque zone de saisie
		String prenom = this.prenom.getText();
		String nom = this.nom.getText();
		String adresse = this.adresse.getText();
		String codePostal = this.codePostal.getText();
		String ville = this.ville.getText();
		String numTel = this.numTel.getText();
		String email = adresseMail.getText();
		String informations = this.informations.getText();
		Integer idEtat = (edao.retournerIdEtat(etatClient.getValue()));
		Integer idZone = (zdao.retournerIdZone(zoneClient.getValue()));
		String commercialResp = this.commercialResp.getValue();
		
		//on vérifie que tous les champs sont bien remplis, sinon on affiche un message d'erreur
		if (prenom.isEmpty() || nom.isEmpty()|| adresse.isEmpty()|| codePostal.isEmpty() || ville.isEmpty() || numTel.isEmpty()
				|| email.isEmpty() || informations.isEmpty() || idEtat==null || idZone == null
				|| commercialResp == null) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Champs manquants");
			alert.setHeaderText(null);
			alert.setContentText("Veuillez remplir l'ensemble des champs puis réessayer");

			alert.showAndWait();
			
		} else {
			//on sépare le nom et le prénom du commercial en deux champs distincts
			String[] output = commercialResp.split(" ");
			//on recupère l'identifiant du commercial correspondant à ce nom et à ce prénom
			Integer idCommercial = cdao.renvoyerCodeCommerciaux(output[0], output[1]);
			//on crée un nouvel objet client avec l'ensemble des données récupérées  
			Client cust = new Client(1, prenom, nom, adresse, codePostal, ville, numTel, email, informations, idZone, idEtat, idCommercial);
			// on vérifie si l'insertion du nouveau client en base a bien eut lieu
			Boolean ok = custDao.ajouterCli(cust);

			if (ok) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Le client a bien été ajouté");
				alert.setHeaderText(null);
				alert.setContentText("Le client et ses informations ont bien été crées dans la base client");

				alert.showAndWait();

			}
		}

	}

	// -----------------------------------------------------------------------------------------------------------------
	public void refreshFields() {

		//on efface chaque saisie du formulaire 
		prenom.setText("");
		nom.setText("");
		adresse.setText("");
		codePostal.setText("");
		ville.setText("");
		numTel.setText("");
		adresseMail.setText("");
		etatClient.setValue(null);
		commercialResp.setValue(null);
		zoneClient.setValue(null);
		informations.setText("");
	}

	// ---------------------------------------------------------------------------------------------------------------

}
