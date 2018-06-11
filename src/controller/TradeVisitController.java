package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import dao.ZoneDao;
import dao.VisiteDao;
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
import model.Analysis;
import model.Client;;

public class TradeVisitController {

	@FXML
	private AnchorPane root;

	@FXML
	private JFXHamburger hbMenu;

	@FXML
	private JFXDrawer drawer;

	@FXML
	private JFXButton btSearch;

	@FXML
	private JFXComboBox<String> cbArea;

	@FXML
	private TableView<Analysis> tbResults;

	@FXML
	private TableColumn<Analysis, String> clSalesRepId;

	@FXML
	private TableColumn<Analysis, String> clSalesRepLastName;

	@FXML
	private TableColumn<Analysis, Integer> clNumberVisits;

	@FXML
	private Stage dialogStage;
	
	//----------------------------------------------------------------------------------------------------


	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	//----------------------------------------------------------------------------------------------------
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

	//---------------------------------------------------------------------------------------------------
	public void implementComboBox(){
		
		ObservableList <String> listArea= FXCollections.observableArrayList();
		ZoneDao ardao= new ZoneDao();
		listArea=ardao.renvoyerNomZones();
		cbArea.setItems(listArea);
		
	}
	
	//---------------------------------------------------------------------------------------------------
	public void lauchAnalysis(){
		
		String region=cbArea.getValue();
		ArrayList<Analysis> listRs= new ArrayList();
		VisiteDao vdao= new VisiteDao();
		listRs=vdao.CountNumberVisitPerRegion(region);

		//permet la conversion d'une arraylist en observablelist utilisée en javafx
		ObservableList<Analysis> data= FXCollections.observableArrayList(listRs);
		
		tbResults.setItems(data);
		clSalesRepId.setCellValueFactory(cellData->cellData.getValue().firstName());
		clSalesRepLastName.setCellValueFactory(cellData-> cellData.getValue().lastName());
		clNumberVisits.setCellValueFactory(cellData-> cellData.getValue().getCountVisit().asObject());
		
		
		
		
		
	}
}
