package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import dao.SalesRepDao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
	
	
	@FXML
	private JFXButton btLogin;
	@FXML
	private JFXTextField tfLogin;
	@FXML
	private JFXPasswordField tfPassword;
	private Main main;
	
//--------------------------------------------------------------------------------------------------	
		
		 public void setMainApp(Main main) {
		        this.main = main;
		      
		 }
		 
//-------------------------------------------------------------------------------------------------------
	 
		 
		 public void handleConnexionOk()
		 {
			 SalesRepDao srdao= new SalesRepDao();
			 String login= tfLogin.getText();
		     String password= tfPassword.getText();
			 srdao.loginRequest(login, password);
			 
			 if (srdao.loginRequest(login, password)){
				 
				 main.showHomePage();
				 
				 
			 }
			 
			 else {
				 
				 Main main= new Main();
			     Alert alert = new Alert(AlertType.WARNING);
			     alert.initOwner(main.getPrimaryStage());
			     alert.setTitle("Erreur d'authentification");
			     alert.setHeaderText("Login ou mot de passe incorrect");
			     alert.setContentText("Votre login ou votre mot de passe est incorrect.");

			     alert.showAndWait();
			 }
			 
			 
			
		 }	

}
