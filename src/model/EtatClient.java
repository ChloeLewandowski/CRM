package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class EtatClient {
	
	private IntegerProperty idEtat;
	private StringProperty libelleEtat;
	private StringProperty descriptionEtat;
	
	public EtatClient(IntegerProperty idEtat, StringProperty libelleEtat, StringProperty descriptionEtat) {
		super();
		this.idEtat = idEtat;
		this.libelleEtat = libelleEtat;
		this.descriptionEtat = descriptionEtat;
	}

	public IntegerProperty getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(IntegerProperty idEtat) {
		this.idEtat = idEtat;
	}

	public StringProperty getLibelleEtat() {
		return libelleEtat;
	}

	public void setLibelleEtat(StringProperty libelleEtat) {
		this.libelleEtat = libelleEtat;
	}

	public StringProperty getDescriptionEtat() {
		return descriptionEtat;
	}

	public void setDescriptionEtat(StringProperty descriptionEtat) {
		this.descriptionEtat = descriptionEtat;
	}
	
	
	
	
	
	
	
	
	}
	
	
	


