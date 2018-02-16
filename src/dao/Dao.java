package dao;

import java.sql.Connection;
import java.sql.DriverManager;



public class Dao {
	
	static Connection laConnection;
	
	
	public Dao()
	{
	 try 
	 {
		//connection au driver jdbc
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 
		 
		 //connection à la BDD 
		 Dao.laConnection= DriverManager.getConnection("jdbc:mysql://localhost/gestionclients", "root","");

		 System.out.println("Connexion ok");
		 
	 }
	 catch(Exception e) 
	 {
		 System.out.println("Connexion fail");
		 System.out.println(e.getMessage());
	 }
		
		
	}
	
	//vérifie s'il n'y a pas déjà des connections et puis ensuite établie une connection 
	public static Connection initConnection(){
		
		if(laConnection==null) 
		{
			new Dao();
		}
		return laConnection;
	}
		
}
	

