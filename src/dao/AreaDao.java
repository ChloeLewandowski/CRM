package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AreaDao {
	
	Connection laConnection=Dao.initConnection();
	
	
	public ObservableList<String> returnAreaNames(){

		ObservableList<String> listArea= FXCollections.observableArrayList();


		try
		{
			Statement st= laConnection.createStatement();

			ResultSet rs= st.executeQuery("SELECT * FROM area");


			while(rs.next()){


				String nameArea= rs.getString("nameArea");


				//on parcours chacune des lignes de la requete, je recupère chacune des colonnes dans un attribut , et j'en crée un objet

				listArea.add(nameArea);
			}
		}catch(SQLException e){


			e.printStackTrace();
		}

		return listArea;
	}




		//---------------------------------------------------------------------------------------------------------------------------------------


}
