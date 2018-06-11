package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import dao.ClientDao;
import dao.CommercialDao;
import dao.VisiteDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Client;
import model.Commercial;
import model.Visite;

public class AjoutVisiteController {
	
	 	@FXML
	    private TableView<Visite> tbVisite;

	    @FXML
	    private TableColumn<Visite, Date> clDateVisite;

	    @FXML
	    private TableColumn<Visite, Integer> clIdClient;

	    @FXML
	    private JFXButton modifierVisite;

	    @FXML
	    private JFXButton supprimerVisite;

	    @FXML
	    private Label numCpte;

	    @FXML
	    private JFXTextArea infoVisite;

	    @FXML
	    private JFXTextField butVisite;

	    @FXML
	    private JFXDatePicker dateVisite;

	    @FXML
	    private JFXComboBox<Client> clientVisite;

	    @FXML
	    private JFXComboBox <String> commercialVisite;

	    @FXML
	    private JFXDrawer drawer;
	    
	    @FXML
	    private JFXHamburger hbMenu;
	    
	    @FXML
		private Stage dialogStage;
	    
	    VisiteDao vdao = new VisiteDao();
	    CommercialDao cdao= new CommercialDao();
	    //---------------------------------------------------------------------------------------------

		public void setDialogStage(Stage dialogStage) {
			this.dialogStage = dialogStage;
		}
		
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
	    
	    public void afficherVisites(){
	    	
	    	ArrayList<Visite>listVisite= new ArrayList<Visite>(vdao.retournerListeVisites());
	    	ObservableList<Visite> data= FXCollections.observableArrayList(listVisite);
	    	tbVisite.setItems(data);
	    	clDateVisite.setCellValueFactory(cellData -> cellData.getValue().DateVisite());
	    	clIdClient.setCellValueFactory(cellData -> cellData.getValue().getIdClient().asObject());
	    	
	    	

			tbVisite.getSelectionModel().selectedItemProperty().addListener(
					(observable, oldValue, newValue) -> afficherDetailsVisite(newValue));
	    }
	    
	    public void afficherDetailsVisite(Visite newValue){
	    	ClientDao clidao= new ClientDao();
	    	//ObservableList<Client> data= FXCollections.observableArrayList(clidao.returnCustList());
	    	String nom=cdao.renvoyerNomCommercial(newValue.idCommercial());
	    	System.out.println("test"+nom);
	    	commercialVisite.getItems().addAll(cdao.renvoyerListeNoms());
	    	commercialVisite.setValue(cdao.renvoyerNomCommercial(newValue.idCommercial()));
	    	
	    	butVisite.setText(newValue.getPurposeVisit());
	    	infoVisite.setText(newValue.getInfoVisit());
	    	dateVisite.setValue(convertToLocalDate(newValue.getDateVisit()));
	    	
	    }
	    
	    public LocalDate convertToLocalDate(Date dateToConvert) {
	        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	    }
	    
	    

}
