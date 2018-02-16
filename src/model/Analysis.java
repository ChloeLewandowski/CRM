package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Analysis {
	
	private IntegerProperty countVisit;
	private StringProperty lastName;
	private StringProperty firstName;
	
	public Analysis (Integer countVisit, String lastName, String firstName){
		
		this.countVisit=new SimpleIntegerProperty(countVisit);
		this.lastName= new SimpleStringProperty(lastName);
		this.firstName=new SimpleStringProperty(firstName);
			
	}
	
	public IntegerProperty getCountVisit(){
		return countVisit;
	}
	
	public Integer countVisit(){
		
		return countVisit.get();
	}
	
	public StringProperty lastName(){
		
		return lastName;
	}
	
	public StringProperty firstName(){
		
		return firstName;
	}

}
