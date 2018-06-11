package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CommercialDao {

	Connection laConnection = Dao.initConnection();

	public Boolean loginRequest(String login, String password) {

		Boolean connexionOk = false;

		try {

			Statement st = laConnection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM tb_commercial where loginCommercial='" + login
					+ "' and mdpCommercial='" + password + "'");

			if (rs.next()) {

				connexionOk = true;
				System.out.println("c'est en base");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return connexionOk;
	}

	// ---------------------------------------------------------------------------------------------
	public String renvoyerNomCommercial(Integer idCommercial) {

		String nomComplet = "";

		try {

			Statement st = laConnection.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT nomCommercial, prenomCommercial FROM tb_commercial where idCommercial='"
							+ idCommercial + "' ");
			System.out.println("SELECT nomCommercial, prenomCommercial FROM tb_commercial where idCommercial='"
							+ idCommercial + "' ");

			if (rs.next()) {

				String nomCommercial = rs.getString("nomCommercial");
				String prenomCommercial = rs.getString("prenomCommercial");
				nomComplet = (nomCommercial + " " + prenomCommercial);
				System.out.println(nomComplet);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return nomComplet;

	}
	
	//-------------------------------------------------------------------------------------------------------------------------

	public Integer renvoyerIdCommercial(String login) {
		Integer idCommercial=0;
		try {

			Statement st = laConnection.createStatement();
			ResultSet rs = st.executeQuery("SELECT idCommercial FROM tb_commercial where loginCommercial='"+login+"'");
			while (rs.next()){
				
				idCommercial= rs.getInt("idCommercial");
				}
			
	}catch (SQLException e){
		e.printStackTrace();
	}
		return idCommercial;
	}
	
	//------------------------------------------------------------------------------------------------------------
	/*public ArrayList<Commercial> retournerCommerciaux(){
		
		ArrayList<Commercial> listeCommercial= new ArrayList();
		
		try {

			Statement st = laConnection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from tb_Commercial");
			while (rs.next()){
				
				Integer idCommercial= rs.getInt("idCommercial");
				String nomCommercial=rs.getString("nomCommercial");
				String prenomCommercial= rs.getString("prenomCommercial");
				String adresseCommercial= rs.getString("adresseCommercial");
				String cpCommercial = rs.getString("cpCommercial");
				String numTelCommercial= rs.getString("numTelCommercial");
				String emailCommercial= rs.getString("emailCommercial");
				Date dateNaissCommercial= rs.getDate("dateNaissCommercial");
				Date dateEntreeCommercial= rs.getDate("dateEntreeCommercial");
				String loginCommercial= rs.getString("loginCommercial");
				String mdpCommercial= rs.getString("mdpCommercial");
				Commercial cml= new Commercial(idCommercial, nomCommercial, prenomCommercial,adresseCommercial, cpCommercial,numTelCommercial,emailCommercial, dateNaissCommercial, dateEntreeCommercial, loginCommercial,mdpCommercial  );

				listeCommercial.add(cml);
			}
			
	}catch (SQLException e){
		e.printStackTrace();
	}
		
		return listeCommercial;				
	}*/
	
	
	public ArrayList<String> renvoyerListeNoms(){
		
		
		ArrayList<String>listeNom= new ArrayList();

		try {

			Statement st = laConnection.createStatement();
			ResultSet rs = st.executeQuery("SELECT nomCommercial, prenomCommercial FROM tb_commercial");
			

			while (rs.next()) {

				String nomCommercial = rs.getString("nomCommercial");
				String prenomCommercial = rs.getString("prenomCommercial");
				String nomComplet = (nomCommercial + " " + prenomCommercial);
				listeNom.add(nomComplet);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listeNom;
	}
		
		//----------------------------------------------------------------------------------------------------
		public Integer renvoyerCodeCommerciaux(String nom, String prenom){
			
			
			Integer idCommercial=0;

			try {

				Statement st = laConnection.createStatement();
				ResultSet rs = st.executeQuery("SELECT idCommercial FROM tb_commercial where nomCommercial='"+nom+"' and prenomCommercial='"+prenom+"'");
				

				if (rs.next()) {

					idCommercial= rs.getInt("idCommercial");
					

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

			return idCommercial;
		
		
		
		
	}
} 
