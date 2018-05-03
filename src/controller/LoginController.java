package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import dao.CommercialDao;
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
			 //on crée un nouvel objet commercialDao
			 CommercialDao cmdao= new CommercialDao();
			 //on recupère le contenu des chl=amps login et password
			 String login= tfLogin.getText();
		     String password= tfPassword.getText();
		     //on les passe en paramètre de la méthode du dao
			 cmdao.loginRequest(login, password);
			 
			 //si les infos existent en base on permet à l'utilisateur d'accéder à la fenêtre suivante
			 if (cmdao.loginRequest(login, password)){
				 
				 Integer id=cmdao.renvoyerIdCommercial(login);
				 main.showHomePage(id);
				 
				 
			 }
			 
			 //sinon on affiche un message d'erreur
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
