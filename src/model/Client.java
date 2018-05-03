package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {

	private IntegerProperty idClient;
	private StringProperty prenomClient;
	private StringProperty nomClient;
	private StringProperty adresseClient;
	private StringProperty codePostalClient;
	private StringProperty villeClient;
	private StringProperty numeroTelClient;
	private StringProperty emailClient;
	private StringProperty informationsClient;
	private IntegerProperty idEtat;

	//-------------------------------------------------------------------------------------------------------------------------------------------------------------

	public Client(){

	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------
	public Client(IntegerProperty idClient, StringProperty prenomClient, StringProperty nomClient,
			StringProperty adresseClient, StringProperty codePostalClient, StringProperty villeClient,
			StringProperty numeroTelClient, StringProperty emailClient,StringProperty informationsClient, IntegerProperty idEtat) {

		this.idClient = idClient;
		this.prenomClient = prenomClient;
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
		this.codePostalClient = codePostalClient;
		this.villeClient = villeClient;
		this.numeroTelClient = numeroTelClient;
		this.emailClient = emailClient;
		this.informationsClient = informationsClient;
		this.idEtat=idEtat;
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------------------

	public Client(Integer idClient, String prenomClient, String nomClient, String adresseClient, String codePostalClient, String villeClient, String numeroTelClient, String emailClient, String informationsClient, Integer idEtat){

		this.idClient = new SimpleIntegerProperty(idClient);
		this.prenomClient =new SimpleStringProperty(prenomClient);
		this.nomClient = new SimpleStringProperty(nomClient);
		this.adresseClient = new SimpleStringProperty(adresseClient);
		this.codePostalClient = new SimpleStringProperty(codePostalClient);
		this.villeClient =new SimpleStringProperty(villeClient);
		this.numeroTelClient = new SimpleStringProperty(numeroTelClient);
		this.emailClient = new SimpleStringProperty(emailClient);
		this.informationsClient= new SimpleStringProperty(informationsClient);
		this.idEtat= new SimpleIntegerProperty(idEtat);

	}

	public IntegerProperty getIdClient() {
		return idClient;
	}

	public Integer idClient(){

		return idClient.get();
	}

	public void setIdClient(IntegerProperty idClient) {
		this.idClient = idClient;
	}

	public StringProperty getPrenomClient() {
		return prenomClient;
	}

	public String prenomClient(){

		return prenomClient.get();
	}

	public void setPrenomClient(StringProperty prenomClient) {
		this.prenomClient = prenomClient;
	}

	public StringProperty getNomClient() {
		return nomClient;
	}

	public String nomClient(){

		return nomClient.get();
	}

	public void setNomClient(StringProperty lastNameCust) {
		this.nomClient = lastNameCust;
	}

	public StringProperty getAdresseClient() {
		return adresseClient;
	}

	public String adresseClient(){

		return adresseClient.get();
	}

	public void setAdresseClient(StringProperty adresseClient) {
		this.adresseClient = adresseClient;
	}

	public StringProperty getCodePostalClient() {
		return codePostalClient;
	}

	public String codePostal(){

		return codePostalClient.get();
	}

	public void setCodePostalClient(StringProperty codePostalClient) {
		this.codePostalClient = codePostalClient;
	}

	public StringProperty getVilleClient() {
		return villeClient;
	}

	public String villeClient(){

		return villeClient.get();
	}

	public void setVilleClient(StringProperty villeClient) {
		this.villeClient = villeClient;
	}

	public StringProperty getNumeroTelClient() {
		return numeroTelClient;
	}

	public String numeroTelClient(){

		return numeroTelClient.get();
	}

	public void setNumeroTelClient(StringProperty numeroTelClient) {
		this.numeroTelClient = numeroTelClient;
	}

	public StringProperty getEmailClient() {
		return emailClient;
	}

	public String emailClient(){

		return emailClient.get();
	}

	public void setEmailClient(StringProperty emailClient) {
		this.emailClient = emailClient;
	}
	
	//----------------------------------------------------------------------------------------------------------------------
	
	public StringProperty getInformationsClient() {
		return informationsClient;
	}
	
	public String informationsClient(){
		return this.informationsClient.get();
	}
	public void setInformationsClient(StringProperty informationsClient) {
		this.informationsClient = informationsClient;
	//-----------------------------------------------------------------------------------------------------------------------
	}
	public IntegerProperty getIdEtat(){
		return idEtat;
	}
	
	public Integer idEtat(){
		return idEtat.get();
	}
	
	public void setidEtat(IntegerProperty idEtat){
		
		this.idEtat = idEtat;
	}
	
	public void idEtat(Integer idEtat){
		
		this.idEtat.set(idEtat);
	}

	//-------------------------------------------------------------------------------------------------------------------------------------------------------------


}
