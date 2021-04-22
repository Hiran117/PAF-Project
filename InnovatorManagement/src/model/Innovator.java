package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Innovator 
{
	
	//A common method to connect to the DB
	private Connection connect() 
	{ 
		Connection con = null; 
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
	 
			//Provide the correct details: DBServer/DBName, username, password 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "", ""); 
			} 
			catch (Exception e) 
			{e.printStackTrace();} 
	 
			return con;
			
	}
	
	
	
	
	public String insertItem(int id, String name, String projname, String pprice, String pproject) 
	{ 
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
			
			if (con == null) 
			{return "Error while connecting to the database for inserting."; } 
			
			
			// create a prepared statement
			String query = " insert into items "
							+ "(`innovatorID`,`innovatorName`,`projName`,`price`,`project`)"
							+ " values (?, ?, ?, ?, ?)"; 
			
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			// binding values
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, name); 
			preparedStmt.setString(3, projname); 
			preparedStmt.setDouble(4, Double.parseDouble(pprice)); 
			preparedStmt.setString(5, pproject); 
			// execute the statement3
			preparedStmt.execute(); 
			con.close(); 
			output = "Inserted successfully"; 
			
		} 
		catch (Exception e) 
		{ 
			output = "Error while inserting the item."; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	 } 
	
	
	
	
	
	
	

}
