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
				Integer idZone=rs.getInt("idZone");
				Integer idEtat = rs.getInt("idEtat");
				

				Client cust= new Client (idCust, firstNameCust, lastNameCust, addressCust, postalCodeCust, cityCust, phoneNumberCust, emailAddressCust, infosClient,idZone, idEtat, idCommercial);


			
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
		String informations= cust.informationsClient();
		Integer idZone=cust.idZone();
		Integer idCommercial= cust.idCommercial();
		Integer idEtat= cust.idEtat();
		try
		{	
			informations.replace("'", "''");
			Statement st= laConnection.createStatement();
			informations.replaceAll("'", "''");
			System.out.println("UPDATE tb_client set prenomClient='"+firstName+"',"
					+ "nomClient='"+lastName+"',adresseClient='"+address+"',codePostalClient='"+postalCode+"',villeClient='"+city+"',numeroTelClient='"+phoneNumber+"',emailClient='"+email+"', informationsClient='"+informations+"',"
							+ "idZone='"+idZone+"', idCommercial="+idCommercial+", idEtat='"+idEtat+"'WHERE idClient="+idCust);
		
			st.executeUpdate("UPDATE tb_client set prenomClient='"+firstName+"',"
					+ "nomClient='"+lastName+"',adresseClient='"+address+"',codePostalClient='"+postalCode+"',villeClient='"+city+"',numeroTelClient='"+phoneNumber+"',emailClient='"+email+"', informationsClient='"+informations+"',"
							+ "idZone='"+idZone+"', idCommercial='"+idCommercial+"', idEtat='"+idEtat+"'WHERE idClient="+idCust);

			
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
			String prenomCli=cust.prenomClient();
			String nomCli=cust.nomClient();
			String adresseCli=cust.adresseClient();
			String codePostalCli=cust.codePostal();
			String villeCli=cust.villeClient();
			String numTelCli=cust.numeroTelClient();
			String mailCli=cust.emailClient();
			String informationsCli= cust.informationsClient();
			Integer idZone= cust.idZone();
			Integer idEtat=cust.idEtat();
			Integer idCommercial= cust.idCommercial();


			System.out.println("INSERT INTO tb_client (prenomClient, nomClient, adresseClient, codePostalClient, villeClient, numeroTelClient, emailClient, informationsClient, idZone, idEtat, idCommercial) values('"+prenomCli+"','"+nomCli+"','"+adresseCli+"','"+codePostalCli+"','"+villeCli+"','"+numTelCli+"','"+mailCli+"','"+informationsCli+"','"+idZone+"','"+idEtat+"','"+idCommercial+"')");

			st.executeUpdate("INSERT INTO tb_client (prenomClient, nomClient, adresseClient, codePostalClient, villeClient, numeroTelClient, emailClient, informationsClient, idZone, idEtat, idCommercial) values('"+prenomCli+"','"+nomCli+"','"+adresseCli+"','"+codePostalCli+"','"+villeCli+"','"+numTelCli+"','"+mailCli+"','"+informationsCli+"','"+idZone+"','"+idEtat+"','"+idCommercial+"')");
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
				System.out.println("résultat du test en cours:SELECT * FROM tb_client where "+crit);
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
					Integer idEtat = rs.getInt("idEtat");
					Integer idZone =rs.getInt("idZone");
					Integer idCommercial =rs.getInt("idCommercial");
					
					Client cust= new Client(idCust, firstNameCust, lastNameCust, addressCust, postalCodeCust, cityCust, phoneNumberCust, emailAddressCust,informationsClient,idZone, idEtat, idCommercial);
					listCust.add(cust);
				
				}
			}catch(SQLException e){

				e.printStackTrace();

			}

			return listCust;


		}
	}
