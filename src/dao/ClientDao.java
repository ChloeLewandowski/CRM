package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Client;


public class ClientDao {


	Connection laConnection=Dao.initConnection();

	public ArrayList<Client> renvoyerListeClient(Integer idCommercial){

		ArrayList<Client> listCust= new ArrayList();


		try
		{
			Statement st= laConnection.createStatement();

			ResultSet rs= st.executeQuery("SELECT * FROM tb_client where idCommercial='"+idCommercial+"'");


			while(rs.next()){

				//je recupere le contenu de la colonne numOpe, montantOpe etc
				Integer idCust= rs.getInt("idClient");
				String firstNameCust= rs.getString("prenomClient");
				String lastNameCust=rs.getString("nomClient");
				String addressCust= rs.getString("adresseClient");
				String postalCodeCust=rs.getString("codePostalClient");
				String cityCust= rs.getString("villeClient");
				String phoneNumberCust=rs.getString("numeroTelClient");
				String emailAddressCust=rs.getString("emailClient");
				String infosClient=rs.getString("informationsClient");
				Integer idEtat = rs.getInt("idEtat");

				Client cust= new Client (idCust, firstNameCust, lastNameCust, addressCust, postalCodeCust, cityCust, phoneNumberCust, emailAddressCust, infosClient, idEtat);


			
				//on parcours chacune des lignes de la requete, je recupère chacune des colonnes dans un attribut , et j'en crée un objet

				listCust.add(cust);
			}
		}catch(SQLException e){


			e.printStackTrace();
		}

		return listCust;


	}

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void supprimerClient(Integer idClient){

		try 
		{
			Statement st= laConnection.createStatement();
			st.executeUpdate("DELETE FROM tb_client WHERE idClient='"+idClient+"'");


		}catch(SQLException e){

			e.printStackTrace();
		}

	}


	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public Boolean updateCustomer (Client cust){

		Boolean ok=true;
		Integer idCust= cust.idClient();
		String firstName= cust.prenomClient();
		String lastName= cust.nomClient();
		String address= cust.adresseClient();
		String postalCode= cust.codePostal();
		String phoneNumber= cust.numeroTelClient();
		String email= cust.emailClient();
		String city= cust.villeClient();
		try
		{	
			Statement st= laConnection.createStatement();
			st.executeUpdate("UPDATE tb_client set prenomClient='"+firstName+"',"
					+ "nomClient='"+lastName+"',adresseClient='"+address+"',codePostalClient='"+postalCode+"',villeClient='"+city+"',numeroTelClient='"+phoneNumber+"',emailClient='"+email+"'WHERE idClient="+idCust);

			System.out.println("TEST -> UPDATE tb_client set prenomClient='"+firstName+"',"
					+ "nomClient='"+lastName+"',adresseClient='"+address+"',codePostalClient='"+postalCode+"',villeClient='"+city+"',numeroTelClient='"+phoneNumber+"',emailClient='"+email+"'WHERE idClient='"+idCust+"'");
		}catch(SQLException e){

			e.printStackTrace();
			ok=false;
		}

		return ok;
	}

	//---------------------------------------------------------------------------------------------------------------------------
	public Boolean ajouterCli (Client cust)
	{
		Boolean ok=true;

		try
		{
			Statement st= laConnection.createStatement();
			Integer idCust=cust.idClient();
			String firstNameCust=cust.prenomClient();
			String lastNameCust=cust.nomClient();
			String addressCust=cust.adresseClient();
			String postalCodeCust=cust.codePostal();
			String cityCust=cust.villeClient();
			String phoneNumberCust=cust.numeroTelClient();
			String emailCust=cust.emailClient();



			st.executeUpdate("INSERT INTO tb_client (firstNameCust, lastNameCust, addressCust, postalCodeCust, cityCust, phoneNumberCust, emailAddressCust) values('"+firstNameCust+"','"+lastNameCust+"','"+addressCust+"','"+postalCodeCust+"','"+cityCust+"','"+phoneNumberCust+"','"+emailCust+"')");
			System.out.println("INSERT INTO tb_client values('"+idCust+"','"+firstNameCust+"','"+lastNameCust+"','"+addressCust+"','"+postalCodeCust+"','"+cityCust+"','"+phoneNumberCust+"','"+emailCust+"')");

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

			ResultSet rs= st.executeQuery("SELECT * FROM tb_client");


			while(rs.next()){


				String idCust= rs.getString("idClient");


				//on parcours chacune des lignes de la requete, je recupère chacune des colonnes dans un attribut , et j'en crée un objet

				listCust.add(idCust);
			}
		}catch(SQLException e){


			e.printStackTrace();
		}

		return listCust;
	}




		//---------------------------------------------------------------------------------------------------------------------------------------

		public ArrayList<Client> renvoyerCpte(String crit){

			ArrayList<Client>listCust= new ArrayList();
			try {

				
				Statement st= laConnection.createStatement();
				System.out.println("SELECT * FROM tb_client where "+crit);
				ResultSet rs= st.executeQuery("SELECT * FROM tb_client where "+crit);
				
				while (rs.next()){

					Integer idCust=rs.getInt("idClient");
					String firstNameCust=rs.getString("prenomClient");
					String lastNameCust= rs.getString("nomClient");
					String addressCust= rs.getString("adresseClient");
					String postalCodeCust= rs.getString("codePostalClient");
					String cityCust=rs.getString("villeClient");
					String phoneNumberCust=rs.getString("numeroTelClient");
					String emailAddressCust=rs.getString("emailClient");
					String informationsClient =rs.getString("informationsClient");
					Integer idEtat = (Integer.getInteger(rs.getString("idEtat")));
					
					Client cust= new Client(idCust, firstNameCust, lastNameCust, addressCust, postalCodeCust, cityCust, phoneNumberCust, emailAddressCust,informationsClient, idEtat);
					listCust.add(cust);
				
				}
			}catch(SQLException e){

				e.printStackTrace();

			}

			return listCust;


		}
	}
