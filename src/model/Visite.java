package model;

import java.sql.Date;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Visite {

	private IntegerProperty idVisit;
	private ObjectProperty<Date> dateVisit;
	private StringProperty purposeVisit;
	private StringProperty infoVisit;
	private IntegerProperty idCommercial;
	private IntegerProperty idClient;


	public Visite(Integer idVisit, Date dateVisit, String purposeVisit, String infoVisit, Integer idCommercial, Integer idClient){

		this.idVisit= new SimpleIntegerProperty(idVisit);
		this.dateVisit= new SimpleObjectProperty(dateVisit);
		this.purposeVisit= new SimpleStringProperty(purposeVisit);
		this.infoVisit= new SimpleStringProperty(infoVisit);
		this.idCommercial=new SimpleIntegerProperty(idCommercial);
		this.idClient= new SimpleIntegerProperty(idClient);
	
	}


	public Integer getIdVisit() {
		return idVisit.get();
	}


	public void setIdVisit(Integer idVisit) {
		this.idVisit.set(idVisit);
	}
//-----------------------------------------------------------------
	
	public ObjectProperty<Date> DateVisite(){
		
		return dateVisit;
		
	}

	public Date getDateVisit() {
		return dateVisit.get();
	}


	public void setDateVisit(Date dateVisit) {
		this.dateVisit.set(dateVisit);
	}


	public String getPurposeVisit() {
		return purposeVisit.get();
	}


	public void setPurposeVisit(String purposeVisit) {
		this.purposeVisit.set(purposeVisit);
	}


	public String getInfoVisit() {
		return infoVisit.get();
	}


	public void setInfoVisit(String infoVisit) {
		this.infoVisit.set(infoVisit);
	}
	//-----------------------------------------------------------------
	
	public IntegerProperty getIdCommercial() {
		return idCommercial;
	}
	
	public Integer idCommercial(){
		return idCommercial.get();
	}


	public void setIdCommercial(IntegerProperty idCommercial) {
		this.idCommercial = idCommercial;
	}
	
	public void setIdCmercial(Integer idCommercial){
		this.idCommercial.set(idCommercial);
	}
	//------------------------------------------------------------------

	public IntegerProperty getIdClient() {
		return idClient;
	}
	

	public Integer idClient(){
		
		return idClient.get();
	}

	public void setIdClient(IntegerProperty idClient) {
		this.idClient = idClient;
	}
	
	public void setIdClt(Integer idClient){
		this.idClient.set(idClient);
	}
	


}
