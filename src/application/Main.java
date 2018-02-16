package application;

import java.io.IOException;

import view.AddCustomerController;
import view.EditCustomerController;
import view.HomePageController;
import view.LoginController;
import view.SearchPageController;
import view.TradeVisitController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Customer;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	//----------------------------------------------------------------------------------------------------------------------------------------------------    
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Business CRM");

		initRootLayout();

		showLogin();
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------------------
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

	//------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void showLogin() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/LoginView.fxml"));
			AnchorPane accueil = (AnchorPane) loader.load();

			//Met la fenêtre d'accueil au centre du root layout
			rootLayout.setCenter(accueil);

			//
			LoginController controller = loader.getController();

			controller.setMainApp(this);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void showHomePage(){
		 try{
			  FXMLLoader loader= new FXMLLoader();
	  		  
	  		loader.setLocation(Main.class.getResource("/View/HomePageView.fxml"));
	          AnchorPane page = (AnchorPane) loader.load();
	          
	       // Create the dialog Stage.
	          rootLayout.setCenter(page);

	          // Set the person into the controller.
	          HomePageController controller = loader.getController();
	          
	         
	       
	          controller.setMainApp(this);
	          controller.displayCustList();
	          controller.initialize();
	         


	          
	  		
	  	}catch (IOException e){
	  		
	  		e.printStackTrace();
	  		
	  	}
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void EditCustomer(Customer cust){
		try{
	 		FXMLLoader loader= new FXMLLoader();
	 		
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
	 		
	 	}catch (IOException e){
	 		
	 		e.printStackTrace();
	 		
	 	}
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void showAddCustomer(){
		 try{
			  FXMLLoader loader= new FXMLLoader();
	  		  
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
		        
		        
		         dialogStage.showAndWait();
	         


	          
	  		
	  	}catch (IOException e){
	  		
	  		e.printStackTrace();
	  		
	  	}
	}
	
	//-----------------------------------------------------------------------------------------------------
	public void showSearchCustomer(){
		 try{
			  FXMLLoader loader= new FXMLLoader();
	  		  
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
	         


	          
	  		
	  	}catch (IOException e){
	  		
	  		e.printStackTrace();
	  		
	  	}
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	public void showTradeVisitsAnalysis(){
		 try{
			  FXMLLoader loader= new FXMLLoader();
	  		  
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
	         


	          
	  		
	  	}catch (IOException e){
	  		
	  		e.printStackTrace();
	  		
	  	}
	}
	
}
