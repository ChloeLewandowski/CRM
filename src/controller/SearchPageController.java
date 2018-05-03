package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import application.Main;
import dao.ClientDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Client;


public class SearchPageController {


	@FXML
	private AnchorPane root;

	@FXML
	private JFXHamburger hbMenu;

	@FXML
	private JFXDrawer drawer;

	@FXML
	private JFXTextField ztFirstName;

	@FXML
	private JFXTextField ztLastName;

	@FXML
	private JFXTextField ztPostalCode;

	@FXML
	private JFXComboBox<String> cbId;

	@FXML
	private TableView<Client> tbCust;
	
	@FXML
	private TableColumn<Client, String> clId;

	@FXML
	private TableColumn<Client, String> clFirstName;

	@FXML
	private TableColumn<Client, String> clLastName;

	@FXML
	private TableColumn<Client, String> clAddress;

	@FXML
	private TableColumn<Client, String> clPostalCode;

	@FXML
	private TableColumn<Client, String> clCity;

	@FXML
	private TableColumn<Client, String> clPhoneNumber;

	@FXML
	private TableColumn<Client, String> clEmailAddress;
	
	@FXML
	private Stage dialogStage;
	
	@FXML
	private JFXButton btSearch;
	
	Main main;

	// ----------------------------------------------------------------------------------------------------

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}
	// --------------------------------------------------------------------------------------------------

	public void setMainApp(Main main) {
		this.main = main;

	}

	//vient implémenter la liste des numéros de compte dans le selecteur combo box	
	public void RemplitChoixNumCpte(){

		ObservableList <String> listCust= FXCollections.observableArrayList();
		ClientDao custDao= new ClientDao();
		listCust=custDao.returnIdCust();
		cbId.setItems(listCust);


	}
	
	//-----------------------------------------------------------------------------------------------------------------------
	public void initialize() {
		//        rootP = root;

		try {
			VBox box = FXMLLoader.load(getClass().getResource("../view/MenuView.fxml"));
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
	
	
	public void searchCustomer(){
		ClientDao custDao= new ClientDao();
		ArrayList<Client>listCust= new ArrayList();
		// cette variable permettra de créer une requête sql sur mesure
		String crit="";
		System.out.println("zé parti");



		//on vient vérifier si le  champ est vide sinon on recupère la valeur 
		if(!ztFirstName.getText().equals("")){

			System.out.println("jsuis al");	
			String firstName=ztFirstName.getText();
			crit="firstNameCust='"+firstName+"'";
		}

		if (!(cbId.getValue()==null)){

			String idCust= cbId.getValue().toString();

			if (crit.equals("")){

				crit="idCust='"+idCust+"'";
			}else{

				crit=crit+"and idCust='"+idCust+"'";
			}		

		}



		if (!ztPostalCode.getText().equals("")){

			String postalCode= ztPostalCode.getText();

			if (crit.equals("")){

				crit="postalCodeCust='"+postalCode+"'";
			}else{

				crit=crit+"and postalCodeCust='"+postalCode+"'";
			}		
		}

		if (!ztLastName.getText().equals("")){

			String lastName= ztLastName.getText();

			if (crit.equals("")){

				crit="lastNameCust='"+lastName+"'";
			}else{

				crit=crit+"and lastNameCust='"+lastName+"'";

			}


		}

		System.out.println(crit);
		listCust=custDao.renvoyerCpte(crit);

		String numCpte=listCust.get(0).idCust();

		//permet la conversion d'une arraylist en observablelist utilisée en javafx
		ObservableList<Client> data= FXCollections.observableArrayList(listCust);

		tbCust.setItems(data);
		clId.setCellValueFactory(cellData -> cellData.getValue().getIdClient());
		clFirstName.setCellValueFactory(cellData-> cellData.getValue().getPrenomClient());
		clLastName.setCellValueFactory(cellData-> cellData.getValue().getNomClient());
		clAddress.setCellValueFactory(cellData -> cellData.getValue().getAdresseClient());
		clPostalCode.setCellValueFactory(cellData-> cellData.getValue().getCodePostalClient());
		clCity.setCellValueFactory(cellData -> cellData.getValue().getVilleClient());
		clPhoneNumber.setCellValueFactory(cellData -> cellData.getValue().getNumeroTelClient());
		clEmailAddress.setCellValueFactory(cellData -> cellData.getValue().getEmailClient());

		//clNomProprio.setCellValueFactory(cellData -> cellData.getValue().);

	}

//---------------------------------------------------------------------------------------------------------

}
