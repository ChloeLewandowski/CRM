package application;

import java.io.IOException;

import controller.AddCustomerController;
import controller.AjoutVisiteController;
import controller.EditCustomerController;
import controller.HomePageController;
import controller.LoginController;
import controller.SearchPageController;
import controller.TradeVisitController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Client;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Business CRM");

		initRootLayout();

		showLogin();
	}

	// --------------------------------------------------------------------------------------------------------------------------------------------------------
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void showLogin() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/LoginView.fxml"));
			AnchorPane accueil = (AnchorPane) loader.load();

			// Met la fenêtre d'accueil au centre du root layout
			rootLayout.setCenter(accueil);

			//
			LoginController controller = loader.getController();

			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void showHomePage(Integer idCommercial) {
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(Main.class.getResource("/View/HomePageView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Crée le dialog stage
			rootLayout.setCenter(page);

			//load le controller concerné
			HomePageController controller = loader.getController();

			controller.setMainApp(this);
			//on lance l'affichage des clients n'appartenant qu'au commercial concerné
			controller.afficherListeClients(idCommercial);
			//on initialise le menu
			controller.initialize();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void EditCustomer(Client cust) {
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(Main.class.getResource("/view/EditCustomerView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit customer");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			EditCustomerController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setCustomer(cust);

			dialogStage.showAndWait();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void showAddCustomer() {
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(Main.class.getResource("/View/AddCustomerView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit customer");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			AddCustomerController controller = loader.getController();
			
			controller.setDialogStage(dialogStage);
			controller.initialiseComboBox();
			dialogStage.showAndWait();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	// -----------------------------------------------------------------------------------------------------
	

	public void showSearchCustomer() {
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(Main.class.getResource("/View/SearchPageView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit customer");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			SearchPageController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			
			controller.RemplitChoixNumCpte();
			controller.initialize();

			dialogStage.showAndWait();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	// -----------------------------------------------------------------------------------------------------------------
	public void showTradeVisitsAnalysis() {
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(Main.class.getResource("/View/TradeVisitView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit customer");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			TradeVisitController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.implementComboBox();
			controller.initialize();

			dialogStage.showAndWait();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	// ------------------------------------------------------------------------------------
	public void showAjouterVisite() {
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(Main.class.getResource("/View/AjoutVisiteView.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ajouter une visite");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			AjoutVisiteController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.afficherVisites();

			dialogStage.showAndWait();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
	


    public static void main(String[] args) {
        launch(args);
    }

}
