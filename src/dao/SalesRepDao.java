package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalesRepDao {
	
	
Connection laConnection=Dao.initConnection();
	
	public Boolean loginRequest(String login, String password){
		
		Boolean connexionOk = false;
		
		
		try{  
		
		Statement st= laConnection.createStatement();
		ResultSet rs= st.executeQuery("SELECT * FROM commercial where idsalesrep='"+login+"' and passwd='"+password+"'");
		
		if (rs.next()){
			
		connexionOk=true;
		System.out.println("c'est en base");
			
		}
		

			
		}catch (SQLException e){
			
			e.printStackTrace();
		}
	
	
	
		return connexionOk;
	}
	
//---------------------------------------------------------------------------------------------

}
