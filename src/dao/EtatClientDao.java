package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EtatClientDao {
	
	Connection laConnection=Dao.initConnection();


	public String afficherLibelleEtat(Integer idEtat) {
		String libelleEtat = "";

		try {
			Statement st = laConnection.createStatement();
			ResultSet rs = st.executeQuery("SELECT libelleEtat FROM tb_etatClient where idEtat='" + idEtat + "'");

			while (rs.next()) {

				libelleEtat = rs.getString("libelleEtat");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return libelleEtat;

	}
	
	public ArrayList<String> renvoyerLibelleEtat(){
		
		ArrayList<String>listeEtat= new ArrayList<String>();
		

		try {
			Statement st = laConnection.createStatement();
			ResultSet rs = st.executeQuery("SELECT libelleEtat FROM tb_etatClient");

			while (rs.next()) {

				String libelleEtat = rs.getString("libelleEtat");
				listeEtat.add(libelleEtat);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return listeEtat;
	}
	
	public Integer retournerIdEtat(String libelleEtatClient){
		Integer idEtat=0;

		try {
			Statement st = laConnection.createStatement();
			ResultSet rs = st.executeQuery("SELECT idEtat FROM tb_etatClient where libelleEtat='" + libelleEtatClient + "'");

			while (rs.next()) {

				idEtat = rs.getInt("idEtat");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return idEtat;
	}
}

