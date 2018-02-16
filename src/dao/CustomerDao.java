package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;

public class CustomerDao {


	Connection laConnection=Dao.initConnection();

	public ArrayList<Customer> returnCustList(){

		ArrayList<Customer> listCust= new ArrayList();


		try
		{
			Statement st= laConnection.createStatement();

			ResultSet rs= st.executeQuery("SELECT * FROM client");


			while(rs.next()){

				//je recupere le contenu de la colonne numOpe, montantOpe etc
				String idCust= rs.getString("idCust");
				String firstNameCust= rs.getString("firstNameCust");
				String lastNameCust=rs.getString("lastNameCust");
				String addressCust= rs.getString("addressCust");
				String postalCodeCust=rs.getString("postalCodeCust");
				String cityCust= rs.getString("cityCust");
				String phoneNumberCust=rs.getString("phoneNumberCust");
				String emailAddressCust=rs.getString("emailAddressCust");

				Customer cust= new Customer(idCust, firstNameCust, lastNameCust, addressCust, postalCodeCust, cityCust, phoneNumberCust, emailAddressCust);


				//on parcours chacune des lignes de la requete, je recupère chacune des colonnes dans un attribut , et j'en crée un objet

				listCust.add(cust);
			}
		}catch(SQLException e){


			e.printStackTrace();
		}

		return listCust;


	}

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void deleteCust(String idcust){

		try 
		{
			Statement st= laConnection.createStatement();
			st.executeUpdate("DELETE FROM client WHERE idCust='"+idcust+"'");


		}catch(SQLException e){

			e.printStackTrace();
		}

	}


	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public Boolean updateCustomer (Customer cust){

		Boolean ok=true;
		String idCust= cust.idCust();
		String firstName= cust.firstName();
		String lastName= cust.lastName();
		String address= cust.address();
		String postalCode= cust.postalCode();
		String city= cust.city();
		String phoneNumber= cust.phoneNumber();
		String email= cust.address();

		try
		{	
			Statement st= laConnection.createStatement();
			st.executeUpdate("UPDATE client set firstNameCust='"+firstName+"',"
					+ "lastNameCust='"+lastName+"',addressCust='"+address+"',postalCodeCust='"+postalCode+"',cityCust='"+city+"',phoneNumberCust='"+phoneNumber+"',emailAddressCust='"+email+"'WHERE idCust='"+idCust+"'");


		}catch(SQLException e){

			e.printStackTrace();
			ok=false;
		}

		return ok;
	}

	//---------------------------------------------------------------------------------------------------------------------------
	public Boolean addCustomer (Customer cust)
	{
		Boolean ok=true;

		try
		{
			Statement st= laConnection.createStatement();
			String idCust=cust.idCust();
			String firstNameCust=cust.firstName();
			String lastNameCust=cust.lastName();
			String addressCust=cust.address();
			String postalCodeCust=cust.postalCode();
			String cityCust=cust.city();
			String phoneNumberCust=cust.phoneNumber();
			String emailCust=cust.emailAddress();



			st.executeUpdate("INSERT INTO client (firstNameCust, lastNameCust, addressCust, postalCodeCust, cityCust, phoneNumberCust, emailAddressCust) values('"+firstNameCust+"','"+lastNameCust+"','"+addressCust+"','"+postalCodeCust+"','"+cityCust+"','"+phoneNumberCust+"','"+emailCust+"')");
			System.out.println("INSERT INTO client values('"+idCust+"','"+firstNameCust+"','"+lastNameCust+"','"+addressCust+"','"+postalCodeCust+"','"+cityCust+"','"+phoneNumberCust+"','"+emailCust+"')");

		}catch(SQLException e){

			e.printStackTrace();
			ok=false;
		}

		return ok;



	}

	//--------------------------------------------------------------------------------------------------------------------------------------	
	public ObservableList<String> returnIdCust(){

		ObservableList<String> listCust= FXCollections.observableArrayList();


		try
		{
			Statement st= laConnection.createStatement();

			ResultSet rs= st.executeQuery("SELECT * FROM client");


			while(rs.next()){


				String idCust= rs.getString("idCust");


				//on parcours chacune des lignes de la requete, je recupère chacune des colonnes dans un attribut , et j'en crée un objet

				listCust.add(idCust);
			}
		}catch(SQLException e){


			e.printStackTrace();
		}

		return listCust;
	}




		//---------------------------------------------------------------------------------------------------------------------------------------

		public ArrayList<Customer> renvoyerCpte(String crit){

			ArrayList<Customer>listCust= new ArrayList();
			try {

				
				Statement st= laConnection.createStatement();
				System.out.println("SELECT * FROM client where "+crit);
				ResultSet rs= st.executeQuery("SELECT * FROM client where "+crit);
				
				while (rs.next()){

					String idCust=rs.getString("idCust");
					String firstNameCust=rs.getString("firstNameCust");
					String lastNameCust= rs.getString("lastNameCust");
					String addressCust= rs.getString("addressCust");
					String postalCodeCust= rs.getString("postalCodeCust");
					String cityCust=rs.getString("cityCust");
					String phoneNumberCust=rs.getString("phoneNumberCust");
					String emailAddressCust=rs.getString("emailAddressCust");
					
					Customer cust= new Customer(idCust, firstNameCust, lastNameCust, addressCust, postalCodeCust, cityCust, phoneNumberCust, emailAddressCust);
					listCust.add(cust);
				
				}
			}catch(SQLException e){

				e.printStackTrace();

			}

			return listCust;


		}
	}
