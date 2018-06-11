package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;

import application.Main;
import dao.ClientDao;
import dao.EtatClientDao;
import dao.ZoneDao;
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
import model.Client;

public class HomePageController {

	@FXML
	private TableView<Client> tbClient;
	private Main main;

	@FXML
	private TableColumn<Client, String> clPrenomClient;
	@FXML
	private TableColumn<Client, String> clNomClient;
	@FXML
	private JFXTextArea informations;
	@FXML
	private JFXTextField firstName;
	@FXML
	private JFXTextField lastName;
	@FXML
	private JFXTextField address;
	@FXML
	private JFXTextField postalCode;
	@FXML
	private JFXTextField city;
	@FXML
	private JFXTextField phoneNumber;
	@FXML
	private JFXTextField email;
	@FXML
	private JFXTextField etatClient;
	@FXML
	private JFXTextField zone;
	@FXML
	private JFXButton btDelete;
	@FXML
	private JFXButton btAdd;
	@FXML
	private Button test;
	@FXML
	private JFXButton supprimerClient;
	@FXML
	private JFXHamburger hbMenu;
	@FXML
	private JFXDrawer drawer;
	@FXML
	private AnchorPane root;
	@FXML
	private Label numCpte;

	EtatClientDao etdao = new EtatClientDao();
	ZoneDao zdao= new ZoneDao();

	public static AnchorPane rootP;
	// --------------------------------------------------------------------------------------------------

	public void setMainApp(Main main) {
		this.main = main;

	}
	
	

	// --------------------------------------------------------------------------------------------------

	public void afficherListeClients(Integer idCommercial) {

		// on crée un nouvel objet ClientDao
		ClientDao custdao = new ClientDao();
		ArrayList<Client> listcustomer = new ArrayList();
		// on récupère dans une liste l'ensemble des clients attribué au
		// commercial
		listcustomer = custdao.renvoyerListeClient(idCommercial);
		// on transforme l'ArrayList en ObservableList
		ObservableList<Client> data = FXCollections.observableArrayList(listcustomer);
		// on set la liste d'objet au tableau de la vue
		tbClient.setItems(data);
		// on déclare quelles valeurs de la liste correspondent aux colonnes du
		// tableau
		// (par exemple ici on met dans la colonne prenom le champ prenom de
		// l'objet Client)
		clPrenomClient.setCellValueFactory(cellData -> cellData.getValue().getPrenomClient());
		clNomClient.setCellValueFactory(cellData -> cellData.getValue().getNomClient());

		tbClient.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> afficherDetailsClient(newValue));
	}

	public void afficherDetailsClient(Client newValue) {

		firstName.setText(newValue.prenomClient());
		lastName.setText(newValue.nomClient());
		address.setText(newValue.adresseClient());
		postalCode.setText(newValue.codePostal());
		city.setText(newValue.villeClient());
		phoneNumber.setText(newValue.numeroTelClient());
		email.setText(newValue.emailClient());
		numCpte.setText(newValue.idClient().toString());
		etatClient.setText(etdao.afficherLibelleEtat(newValue.idEtat()));
		informations.setText(newValue.informationsClient());
		zone.setText(zdao.renvoyerLibelle(newValue.idZone()));

	}

	// --------------------------------------------------------------------------------------------------
	@FXML
	private void handleSupprimerClient() {

		ClientDao cdao = new ClientDao();
		//on recupère l'identifiant de la ligne sélectionnée par l'utilisateur
		int indexSelection = tbClient.getSelectionModel().getSelectedIndex();

		//si une ligne a bien été sélectionnée on recupère le client de la ligne, puis son id
		//et on le supprime en base de données, puis physiquement du tableau 
		if (indexSelection >= 0) {

			Client cli = tbClient.getItems().get(indexSelection);
			Integer idClient = cli.idClient();
			cdao.supprimerClient(idClient);
			tbClient.getItems().remove(indexSelection);
		}

		// rien n'a été sélectionné, on notifie à l'utilisateur une erreur dans la procédure de suppression 
		else {
			Main main = new Main();
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(main.getPrimaryStage());
			alert.setTitle("Aucun client sélectionné");
			alert.setHeaderText("Vous n'avez sélectionné aucun client dans la liste");
			alert.setContentText("Sélectionner d'abord un client puis réessayer");

			alert.showAndWait();
		}

	}

	// ------------------------------------------------------------------------------------------------------------------------------

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

	// ------------------------------------------------------------------------------------------------------------------------------------


	// -------------------------------------------------------------------------------------------------------------------------------------

	public void handleEditDialog() {

		Client selectedCust = tbClient.getSelectionModel().getSelectedItem();
		if (selectedCust != null) {

			main.EditCustomer(selectedCust);

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(main.getPrimaryStage());
			alert.setTitle("Pas de selection");
			alert.setHeaderText("Aucun client n'a été préalablement sélectionné");
			alert.setContentText("Sélectionner un client avant d'effectuer une modification");

			alert.showAndWait();
		}

	}

}
