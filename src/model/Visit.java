package model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Visit {

	private IntegerProperty idVisit;
	private ObjectProperty<LocalDate> dateVisit;
	private StringProperty purposeVisit;
	private StringProperty infoVisit;


	public Visit(Integer idVisit, LocalDate dateVisit, String purposeVisit, String infoVisit){

		this.idVisit= new SimpleIntegerProperty(idVisit);
		this.dateVisit= new SimpleObjectProperty(dateVisit);
		this.purposeVisit= new SimpleStringProperty(purposeVisit);
		this.infoVisit= new SimpleStringProperty(infoVisit);
	}


	public Integer getIdVisit() {
		return idVisit.get();
	}


	public void setIdVisit(Integer idVisit) {
		this.idVisit.set(idVisit);
	}


	public LocalDate getDateVisit() {
		return dateVisit.get();
	}


	public void setDateVisit(LocalDate dateVisit) {
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



}
