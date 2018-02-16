package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Area {

	private IntegerProperty idArea;
	private StringProperty nameArea;
	
	
	public Area(Integer idArea, String nameArea){
		
		this.idArea= new SimpleIntegerProperty(idArea);
		this.nameArea= new SimpleStringProperty(nameArea);
	}


	public IntegerProperty getIdArea() {
		return idArea;
	}

	public Integer idArea(){

		return idArea.get();
	}

	public void setIdArea(Integer idArea) {
		this.idArea.set(idArea);
	}


	public StringProperty getNameArea() {
		return nameArea;
	}

	public String NameArea(){
		return nameArea.get(); 
	}
	
	public void setNameArea(String nameArea) {
		this.nameArea.set(nameArea);
	}

}
