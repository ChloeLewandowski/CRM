package model;

import java.time.LocalDate;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Commercial {


	private StringProperty idSalesRep;
	private StringProperty lastNameSalesRep;
	private StringProperty firstNameSalesRep;
	private StringProperty addressSalesRep;
	private StringProperty postalCodeSalesRep;
	private StringProperty phoneNumberSalesRep;
	private StringProperty emailAddressSalesRep;
	private SimpleObjectProperty<LocalDate> birthdaySalesRep= new SimpleObjectProperty<LocalDate>();
	private SimpleObjectProperty<LocalDate> effectiveDateSalesRep= new SimpleObjectProperty<LocalDate>();
	private FloatProperty basicWageSalesRep;
	private StringProperty passwd;


	public Commercial(StringProperty idSalesRep,StringProperty lastNameSalesRep, StringProperty firstNameSalesRep, StringProperty addressSalesRep,StringProperty postalCodeSalesRep, StringProperty phoneNumberSalesRep, StringProperty emailAddressSalesRep, SimpleObjectProperty<LocalDate>birthdaySalesRep, SimpleObjectProperty<LocalDate>BirthdaySalesRep, FloatProperty basicWageSalesRep, StringProperty passwd){

		this.idSalesRep=idSalesRep;
		this.lastNameSalesRep=lastNameSalesRep;
		this.firstNameSalesRep=firstNameSalesRep;
		this.addressSalesRep=addressSalesRep;
		this.postalCodeSalesRep=postalCodeSalesRep;
		this.phoneNumberSalesRep=phoneNumberSalesRep;
		this.emailAddressSalesRep=emailAddressSalesRep;
		this.birthdaySalesRep=birthdaySalesRep;
		this.effectiveDateSalesRep=effectiveDateSalesRep;
		this.basicWageSalesRep=basicWageSalesRep;
		this.passwd=passwd;			

	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public Commercial(String idSalesRep, String lastNameSalesRep, String firstNameSalesRep, String addressSalesRep, String postalCodeSalesRep, String phoneNumberSalesRep, String emailAddressSalesRep, LocalDate birthdaySalesRep, LocalDate BirthdaySalesRep,LocalDate effectiveDateSalesRep, Float basicWageSalesRep, String passwd ){

	this.idSalesRep= new SimpleStringProperty(idSalesRep);
	this.lastNameSalesRep= new SimpleStringProperty(lastNameSalesRep);
	this.firstNameSalesRep= new SimpleStringProperty(firstNameSalesRep);
	this.addressSalesRep= new SimpleStringProperty(addressSalesRep);
	this.postalCodeSalesRep= new SimpleStringProperty(postalCodeSalesRep);
	this.phoneNumberSalesRep= new SimpleStringProperty(phoneNumberSalesRep);
	this.emailAddressSalesRep= new SimpleStringProperty(emailAddressSalesRep);
	this.birthdaySalesRep=new SimpleObjectProperty<LocalDate>(birthdaySalesRep);
	this.effectiveDateSalesRep=new SimpleObjectProperty<LocalDate>(effectiveDateSalesRep);
	this.basicWageSalesRep= new SimpleFloatProperty(basicWageSalesRep);
	this.passwd= new SimpleStringProperty(passwd);
		
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public StringProperty getIdSalesRep() {
		return idSalesRep;
	}
	
	public String IdSalesRep(){
		
		return idSalesRep.get();
	}

	public void setIdSalesRep(StringProperty idSalesRep) {
		this.idSalesRep = idSalesRep;
	}
	

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public StringProperty getLastNameSalesRep() {
		return lastNameSalesRep;
	}
	
	public String LastNameSalesRep(){
		
		return lastNameSalesRep.get();
	}

	public void setLastNameSalesRep(StringProperty lastNameSalesRep) {
		this.lastNameSalesRep = lastNameSalesRep;
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


	public StringProperty getFirstNameSalesRep() {
		return firstNameSalesRep;
	}

	public String FirstNameSalesRep(){
		
		return firstNameSalesRep.get();
	}
	public void setFirstNameSalesRep(StringProperty firstNameSalesRep) {
		this.firstNameSalesRep = firstNameSalesRep;
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


	public StringProperty getAddressSalesRep() {
		return addressSalesRep;
	
	}
	
	public String AddressSalesRep(){
		
		return addressSalesRep.get();
	}

	public void setAddressSalesRep(StringProperty addressSalesRep) {
		this.addressSalesRep = addressSalesRep;
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public StringProperty getPostalCodeSalesRep() {
		return postalCodeSalesRep;
	}

	public void setPostalCodeSalesRep(StringProperty postalCodeSalesRep) {
		this.postalCodeSalesRep = postalCodeSalesRep;
	}

	public StringProperty getPhoneNumberSalesRep() {
		return phoneNumberSalesRep;
	}

	public void setPhoneNumberSalesRep(StringProperty phoneNumberSalesRep) {
		this.phoneNumberSalesRep = phoneNumberSalesRep;
	}

	public StringProperty getEmailAddressSalesRep() {
		return emailAddressSalesRep;
	}

	public void setEmailAddressSalesRep(StringProperty emailAddressSalesRep) {
		this.emailAddressSalesRep = emailAddressSalesRep;
	}

	public SimpleObjectProperty<LocalDate> getBirthdaySalesRep() {
		return birthdaySalesRep;
	}

	public void setBirthdaySalesRep(SimpleObjectProperty<LocalDate> birthdaySalesRep) {
		this.birthdaySalesRep = birthdaySalesRep;
	}

	public SimpleObjectProperty<LocalDate> getEffectiveDateSalesRep() {
		return effectiveDateSalesRep;
	}

	public void setEffectiveDateSalesRep(SimpleObjectProperty<LocalDate> effectiveDateSalesRep) {
		this.effectiveDateSalesRep = effectiveDateSalesRep;
	}

	public FloatProperty getBasicWageSalesRep() {
		return basicWageSalesRep;
	}

	public void setBasicWageSalesRep(FloatProperty basicWageSalesRep) {
		this.basicWageSalesRep = basicWageSalesRep;
	}

	public StringProperty getPasswd() {
		return passwd;
	}

	public void setPasswd(StringProperty passwd) {
		this.passwd = passwd;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
}
