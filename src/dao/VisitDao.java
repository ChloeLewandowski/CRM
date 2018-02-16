package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Analysis;

public class VisitDao {

	Connection laConnection=Dao.initConnection();

	public ArrayList<Analysis> CountNumberVisitPerRegion(String region){


		ArrayList<Analysis> listCount= new ArrayList<Analysis>();

		try
		{
			Statement st= laConnection.createStatement();
			
			System.out.println("SELECT COUNT(idVisit) as countVisit, commercial.lastNameSalesRep, commercial.firstNameSalesRep FROM client, commercial, visit WHERE commercial.idSalesRep=visit.idSalesRep AND visit.idCust=client.idCust AND idArea='SELECT area.idArea FROM area where area.nameArea='"+region+"') GROUP BY commercial.idSalesRep;");
			ResultSet rs= st.executeQuery("SELECT COUNT(idVisit) as countVisit, commercial.lastNameSalesRep, commercial.firstNameSalesRep FROM client, commercial, visit WHERE commercial.idSalesRep=visit.idSalesRep AND visit.idCust=client.idCust AND idArea=(SELECT area.idArea FROM area where area.nameArea='"+region+"') GROUP BY commercial.idSalesRep;");
			
			while (rs.next()){

				Integer countVisit= rs.getInt("countVisit");
				String lastNameSalesRep=rs.getString("lastNameSalesRep");
				String firstNameSalesRep=rs.getString("firstNameSalesRep");
				Analysis al= new Analysis(countVisit, lastNameSalesRep, firstNameSalesRep);
				listCount.add(al);

			}




		}catch(SQLException e){


			e.printStackTrace();
		}
		return listCount; 

	}
}
