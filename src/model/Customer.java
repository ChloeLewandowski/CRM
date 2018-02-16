package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {

	private StringProperty idCust;
	private StringProperty firstNameCust;
	private StringProperty lastNameCust;
	private StringProperty addressCust;
	private StringProperty postalCodeCust;
	private StringProperty cityCust;
	private StringProperty phoneNumberCust;
	private StringProperty emailAddressCust;

	//-------------------------------------------------------------------------------------------------------------------------------------------------------------

	public Customer(){

	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------
	public Customer(StringProperty idCust, StringProperty firstNameCust, StringProperty lastNameCust,
			StringProperty addressCust, StringProperty postalCodeCust, StringProperty cityCust,
			StringProperty phoneNumberCust, StringProperty emailAddressCust) {

		this.idCust = idCust;
		this.firstNameCust = firstNameCust;
		this.lastNameCust = lastNameCust;
		this.addressCust = addressCust;
		this.postalCodeCust = postalCodeCust;
		this.cityCust = cityCust;
		this.phoneNumberCust = phoneNumberCust;
		this.emailAddressCust = emailAddressCust;
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------------------

	public Customer(String idCust, String firstNameCust, String lastNameCust, String addressCust, String postalCodeCust, String cityCust, String phoneNumberCust, String emailAddressCust){

		this.idCust = new SimpleStringProperty(idCust);
		this.firstNameCust =new SimpleStringProperty(firstNameCust);
		this.lastNameCust = new SimpleStringProperty(lastNameCust);
		this.addressCust = new SimpleStringProperty(addressCust);
		this.postalCodeCust = new SimpleStringProperty(postalCodeCust);
		this.cityCust =new SimpleStringProperty( cityCust);
		this.phoneNumberCust = new SimpleStringProperty(phoneNumberCust);
		this.emailAddressCust = new SimpleStringProperty(emailAddressCust);

	}

	public StringProperty getIdCust() {
		return idCust;
	}

	public String idCust(){

		return idCust.get();
	}

	public void setIdCust(StringProperty idCust) {
		this.idCust = idCust;
	}

	public StringProperty getFirstNameCust() {
		return firstNameCust;
	}

	public String firstName(){

		return firstNameCust.get();
	}

	public void setFirstNameCust(StringProperty firstNameCust) {
		this.firstNameCust = firstNameCust;
	}

	public StringProperty getLastNameCust() {
		return lastNameCust;
	}

	public String lastName(){

		return lastNameCust.get();
	}

	public void setLastNameCust(StringProperty lastNameCust) {
		this.lastNameCust = lastNameCust;
	}

	public StringProperty getAddressCust() {
		return addressCust;
	}

	public String address(){

		return addressCust.get();
	}

	public void setAddressCust(StringProperty addressCust) {
		this.addressCust = addressCust;
	}

	public StringProperty getPostalCodeCust() {
		return postalCodeCust;
	}

	public String postalCode(){

		return postalCodeCust.get();
	}

	public void setPostalCodeCust(StringProperty postalCodeCust) {
		this.postalCodeCust = postalCodeCust;
	}

	public StringProperty getCityCust() {
		return cityCust;
	}

	public String city(){

		return cityCust.get();
	}

	public void setCityCust(StringProperty cityCust) {
		this.cityCust = cityCust;
	}

	public StringProperty getPhoneNumberCust() {
		return phoneNumberCust;
	}

	public String phoneNumber(){

		return phoneNumberCust.get();
	}

	public void setPhoneNumberCust(StringProperty phoneNumberCust) {
		this.phoneNumberCust = phoneNumberCust;
	}

	public StringProperty getEmailAddressCust() {
		return emailAddressCust;
	}

	public String emailAddress(){

		return emailAddressCust.get();
	}

	public void setEmailAddressCust(StringProperty emailAddressCust) {
		this.emailAddressCust = emailAddressCust;
	}

	//-------------------------------------------------------------------------------------------------------------------------------------------------------------


}
