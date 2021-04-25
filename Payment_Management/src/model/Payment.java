package model;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Payment {


	 //A common method to connect to the DB
	private Connection connect() 
	 { 
	         Connection con = null; 
	          
	         try
	        { 
	           Class.forName("com.mysql.cj.jdbc.Driver"); 
	 
	           //Provide the correct details: DBServer/DBName, username, password 
	           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paf_db" ,"root" ,"rockyrox"); 
	         } 
	         catch (Exception e) 
	         {e.printStackTrace();} 
	 
	         return con; 
	 } 
	
	//insert payment details
	 public String insertPayment_details(String name, String email, String address, String contact_number, String card_name, String card_number, String expiry_date, String cvc_number) 
	 { 
	         String output = ""; 
	         try
	         { 
	 
	        	 Connection con = connect(); 
	 
	        	 if (con == null) 
	             
	        	 {return "Error while connecting to the database for inserting."; } 
	          
	        	 // create a prepared statement
	             String query = "insert into payment_details (payment_ID, name , email , address , contact_number , card_name , card_number , expiry_date , cvc_number )"
	            		 + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
	 
	             PreparedStatement preparedStmt = con.prepareStatement(query);
	 
	             // binding values
	             preparedStmt.setInt(1, 0); 
	             preparedStmt.setString(2, name); 
	             preparedStmt.setString(3, email); 
	             preparedStmt.setString(4, address); 
	             preparedStmt.setString(5, contact_number); 
	             preparedStmt.setString(6, card_name); 
	             preparedStmt.setString(7, card_number); 
	             preparedStmt.setString(8, expiry_date); 
	             preparedStmt.setString(9, cvc_number); 
	             
	             // execute the statement
	             preparedStmt.execute();
	             con.close();
	             
	             output = "Inserted successfully";
	             
	         }
	         catch(Exception e)
	         {   
	        	 output = "Error while inserting the payment details.";
	             System.err.println(e.getMessage());
	        	 
	         }
	         
	         return output;
	 }
	 