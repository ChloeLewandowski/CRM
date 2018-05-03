package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Analysis;
import model.Visite;

public class VisiteDao {

	Connection laConnection=Dao.initConnection();

	public ArrayList<Analysis> CountNumberVisitPerRegion(String region){


		ArrayList<Analysis> listCount= new ArrayList<Analysis>();

		try
		{
			Statement st= laConnection.createStatement();
			
			
			ResultSet rs= st.executeQuery("SELECT COUNT(idVisite) as countVisit, tb_commercial.nomCommercial, tb_commercial.prenomCommercial FROM tb_client, tb_commercial, tb_visite WHERE tb_commercial.idCommercial=tb_visite.idCommercial AND tb_visite.idClient=tb_client.idClient AND idZone=(SELECT tb_zone.idZone FROM tb_zone where tb_zone.nomZone='"+region+"') GROUP BY tb_commercial.idCommercial;");
			
			while (rs.next()){

				Integer countVisit= rs.getInt("countVisit");
				String lastNameSalesRep=rs.getString("nomCommercial");
				String firstNameSalesRep=rs.getString("prenomCommercial");
				Analysis al= new Analysis(countVisit, lastNameSalesRep, firstNameSalesRep);
				listCount.add(al);

			}




		}catch(SQLException e){


			e.printStackTrace();
		}
		return listCount;

	}

	public ArrayList<Visite> retournerListeVisites() {

		ArrayList<Visite> listVisite = new ArrayList<Visite>();

		try {
			Statement st = laConnection.createStatement();

			ResultSet rs = st.executeQuery("SELECT * from tb_Visite");
			while (rs.next()) {
				Integer idVisite = rs.getInt("idVisite");
				Date dateVisite = rs.getDate("dateVisite");
				String butVisite = rs.getString("butVisite");
				String informationsVisite = rs.getString("informationsVisite");
				Integer idCommercial = rs.getInt("idCommercial");
				Integer idClient = rs.getInt("idClient");

				Visite v = new Visite(idVisite, dateVisite, butVisite, informationsVisite, idCommercial, idClient);
				listVisite.add(v);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listVisite;
	}
	
}
