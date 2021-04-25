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
	 // read payment_details
	 public String readpayment_details()
	 {
		     String output = "";
		     
		     try
		     {
		    	 Connection con = connect();
		    	 
		    	 if (con == null)
		         {return "Error while connecting to the database for reading.";}
		    	 
				// Prepare the html table to be displayed
				output = "<table border=\"1\"><tr><th>Payment ID</th><th>Name</th><th>Adrress</th><th>Email</th><th>Contact Number</th><th>Card Name</th><th>Card Number</th><th>Expiry Date</th><th>CVC Number</th><th>Update</th><th>Remove</th></tr>";
				
				String query = "select * from payment_details";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				// iterate through the rows in the result set
				while (rs.next()) {

					String payment_ID = Integer.toString(rs.getInt("payment_ID"));
					String name = rs.getString("name");
					String address = rs.getString("address");
					String email = rs.getString("email");
					String contact_number = rs.getString("contact_number");
					String card_name = rs.getString("card_name");
					String card_number = rs.getString("card_number");
					String expiry_date = rs.getString("expiry_date");
					String cvc_number = rs.getString("cvc_number");

					// Add into the html table
					output += "<tr><td>" + payment_ID + "</td>";
					output += "<td>" + name + "</td>";
					output += "<td>" + address + "</td>";
					output += "<td>" + email + "</td>";
					output += "<td>" + contact_number + "</td>";
					output += "<td>" + card_name + "</td>";
					output += "<td>" + card_number + "</td>";
					output += "<td>" + expiry_date + "</td>";
					output += "<td>" + cvc_number + "</td>";
				

					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
							+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-funderID='"
							+ payment_ID + "'>" + "</td></tr>";
				} 
				
				con.close();
				
				// Complete the html table
				output += "</table>";
				
			}
		    catch (Exception e)
		     {
				output = "Error while reading the payment details.";
				System.err.println(e.getMessage());
			}
			return output; 
		    	 
	 }
	
	//update payment details
		public String updatePayment_details(String payment_ID, String name, String address, String email, String contact_number, String card_name, String card_number, String expiry_date, String cvc_number)
		 {
			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
		}
				// create a prepared statement
				String query = "UPDATE payment_details SET name=?,address=?,email=?,contact_number=?,card_name=?,card_number=?expiry_date=?,cvc_number=? WHERE payment_ID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values

					preparedStmt.setString(1, name);
					preparedStmt.setString(2, address);
					preparedStmt.setString(3, email);
					preparedStmt.setString(4, contact_number);
					preparedStmt.setString(5, card_name);
					preparedStmt.setString(6, card_number);
					preparedStmt.setString(7, expiry_date);
					preparedStmt.setString(8, cvc_number);
					preparedStmt.setInt(9, Integer.parseInt(payment_ID));

					// execute the statement
					preparedStmt.execute();
					con.close();
					output = "Details Updated successfully.";
		 
			} catch (Exception e) {
				output = "Error in the data updation!."; 
				System.err.println(e.getMessage()); 
			}
			return output;
		 }
	         
		//delete payment details
		public String deletePayment_details(String payment_ID) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from payment_details where payment_ID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(payment_ID));
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Data has been Deleted."; 
				
			} catch (Exception e) {
				
				output = "Error while deleting.!"; 
				System.err.println(e.getMessage()); 
			}
			return output;
			}
	

}
