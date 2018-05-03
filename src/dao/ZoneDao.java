package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ZoneDao {
	
	Connection laConnection=Dao.initConnection();
	
	
	public ObservableList<String> returnAreaNames(){

		ObservableList<String> listArea= FXCollections.observableArrayList();


		try
		{
			Statement st= laConnection.createStatement();

			ResultSet rs= st.executeQuery("SELECT * FROM tb_Zone");


			while(rs.next()){


				String nomZone= rs.getString("nomZone");


				//on parcours chacune des lignes de la requete, je recupère chacune des colonnes dans un attribut , et j'en crée un objet

				listArea.add(nomZone);
			}
		}catch(SQLException e){


			e.printStackTrace();
		}

		return listArea;
	}




		//---------------------------------------------------------------------------------------------------------------------------------------


}
