package model;

import java.sql.Date;
import java.time.LocalDate;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Commercial {


	private IntegerProperty idSalesRep;
	private StringProperty lastNameSalesRep;
	private StringProperty firstNameSalesRep;
	private StringProperty addressSalesRep;
	private StringProperty postalCodeSalesRep;
	private StringProperty phoneNumberSalesRep;
	private StringProperty emailAddressSalesRep;
	private SimpleObjectProperty<Date> birthdaySalesRep= new SimpleObjectProperty<Date>();
	private SimpleObjectProperty<Date> effectiveDateSalesRep= new SimpleObjectProperty<Date>();
	private StringProperty loginCommercial;
	private StringProperty passwd;


	public Commercial(IntegerProperty idSalesRep,StringProperty lastNameSalesRep, StringProperty firstNameSalesRep, StringProperty addressSalesRep,StringProperty postalCodeSalesRep, StringProperty phoneNumberSalesRep, StringProperty emailAddressSalesRep, SimpleObjectProperty<Date>birthdaySalesRep, SimpleObjectProperty<Date>BirthdaySalesRep, StringProperty loginCommercial, StringProperty passwd){

		this.idSalesRep=idSalesRep;
		this.lastNameSalesRep=lastNameSalesRep;
		this.firstNameSalesRep=firstNameSalesRep;
		this.addressSalesRep=addressSalesRep;
		this.postalCodeSalesRep=postalCodeSalesRep;
		this.phoneNumberSalesRep=phoneNumberSalesRep;
		this.emailAddressSalesRep=emailAddressSalesRep;
		this.birthdaySalesRep=birthdaySalesRep;
		this.effectiveDateSalesRep=effectiveDateSalesRep;
		this.loginCommercial=loginCommercial;
		this.passwd=passwd;			

	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public Commercial(Integer idSalesRep, String lastNameSalesRep, String firstNameSalesRep, String addressSalesRep, String postalCodeSalesRep, String phoneNumberSalesRep, String emailAddressSalesRep, Date birthdaySalesRep, Date effectiveDateSalesRep, String loginCommercial, String passwd ){

	this.idSalesRep= new SimpleIntegerProperty(idSalesRep);
	this.lastNameSalesRep= new SimpleStringProperty(lastNameSalesRep);
	this.firstNameSalesRep= new SimpleStringProperty(firstNameSalesRep);
	this.addressSalesRep= new SimpleStringProperty(addressSalesRep);
	this.postalCodeSalesRep= new SimpleStringProperty(postalCodeSalesRep);
	this.phoneNumberSalesRep= new SimpleStringProperty(phoneNumberSalesRep);
	this.emailAddressSalesRep= new SimpleStringProperty(emailAddressSalesRep);
	this.birthdaySalesRep=new SimpleObjectProperty<Date>(birthdaySalesRep);
	this.effectiveDateSalesRep=new SimpleObjectProperty<Date>(effectiveDateSalesRep);
	this.loginCommercial= new SimpleStringProperty(loginCommercial);
	this.passwd= new SimpleStringProperty(passwd);
		
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public IntegerProperty getIdSalesRep() {
		return idSalesRep;
	}
	
	public Integer IdSalesRep(){
		
		return idSalesRep.get();
	}

	public void setIdSalesRep(IntegerProperty idSalesRep) {
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

	public SimpleObjectProperty<Date> getBirthdaySalesRep() {
		return birthdaySalesRep;
	}

	public void setBirthdaySalesRep(SimpleObjectProperty<Date> birthdaySalesRep) {
		this.birthdaySalesRep = birthdaySalesRep;
	}

	public SimpleObjectProperty<Date> getEffectiveDateSalesRep() {
		return effectiveDateSalesRep;
	}

	public void setEffectiveDateSalesRep(SimpleObjectProperty<Date> effectiveDateSalesRep) {
		this.effectiveDateSalesRep = effectiveDateSalesRep;
	}

	public StringProperty getBasicWageSalesRep() {
		return loginCommercial;
	}

	public void setBasicWageSalesRep(StringProperty loginCommercial) {
		this.loginCommercial = loginCommercial;
	}

	public StringProperty getPasswd() {
		return passwd;
	}

	public void setPasswd(StringProperty passwd) {
		this.passwd = passwd;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
}
