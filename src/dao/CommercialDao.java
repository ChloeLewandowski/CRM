package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
