package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
			String query = " insert into innovator "
							+ "(`innovatorID`,`innovatorName`,`projName`,`price`,`project`)"
							+ " values (?, ?, ?, ?, ?)"; 
			
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			// binding values
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, name); 
			preparedStmt.setString(3, projname);
			preparedStmt.setString(4, pprice);  
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
	
		public String readItems() 
		{ 
			String output = ""; 
			
			try
			{ 
				Connection con = connect(); 
				
				if (con == null) 
				{return "Error while connecting to the database for reading."; } 
				
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>InnovatorID</th><th>InnovatorName</th>" +
						"<th>ProjectName</th>" + 
						"<th>ProjectPrice</th>" +
						"<th>Update</th><th>Project</th></tr>"; 
	 
				String query = "select * from innovator"; 
				Statement stmt = con.createStatement(); 
				ResultSet rs = stmt.executeQuery(query); 
				// iterate through the rows in the result set
				
				while (rs.next()) 
				{ 
					String innovatorID = Integer.toString(rs.getInt("innovatorID")); 
					String innovatorName = rs.getString("innovatorName"); 
					String projName = rs.getString("projName"); 
					String price = rs.getString("price"); 
					String project = rs.getString("project");
					
					// Add into the html table
					output += "<tr><td>" + innovatorID + "</td>"; 
					output += "<td>" + innovatorName + "</td>"; 
					output += "<td>" + projName + "</td>"; 
					output += "<td>" + price + "</td>";
					output += "<td>" + project + "</td>";
					
					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"+ "<td><form method='post' action='items.jsp'>"
							+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
							+ "<input name='itemID' value='" + innovatorID 
							+ "'>" + "</form></td></tr>"; 
				}
				
				con.close();
				
				// Complete the html table
				output += "</table>"; 
			} 
			catch (Exception e) 
			{ 
				output = "Error while reading the items."; 
				System.err.println(e.getMessage()); 
			} 
			return output; 
	 }
		
		
		//update
		
		public String updateItem(int id, String name, String projname, String pprice, String pproject)
		
		{ 
			String output = "";
			
			try
			{ 
				Connection con = connect();
				
				if (con == null) 
				{return "Error while connecting to the database for updating."; }
				
				// create a prepared statement
				String query = "UPDATE innovator SET innovatorName=?,projName=?,price=?,project=? WHERE innovatorID=?";
										
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				
				// binding values
				preparedStmt.setInt(0,(id)); 
				preparedStmt.setString(1, name); 
				preparedStmt.setString(2, projname); 
				preparedStmt.setString(2, pprice);  
				preparedStmt.setString(4, pproject); 
				
		 
				// execute the statement
				preparedStmt.execute(); 
				con.close(); 
		 
				output = "Updated successfully"; 
			} 
			catch (Exception e) 
			{ 
				output = "Error while updating the item."; 
				System.err.println(e.getMessage()); 
			} 
			
			return output; 
		 }
		
			//delete
		
			public String deleteItem(String innovatorID) 
			{ 
				String output = "";
				
				try
				{ 
					
					Connection con = connect();
					
					
					if (con == null) 
					{return "Error while connecting to the database for deleting."; } 
		 
					// create a prepared statement
					String query = "delete from innovator where innovatorID=?"; 
		 
					PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
					// binding values
		 
					preparedStmt.setInt(1, Integer.parseInt(innovatorID)); 
		 
					// execute the statement
					preparedStmt.execute(); 
					con.close(); 
		 
					output = "Deleted successfully"; 
				} 
				catch (Exception e) 
				{ 
					output = "Error while deleting the item."; 
					System.err.println(e.getMessage()); 
				} 
				
				return output;
				
			} 
} 
	
	
	
	
	
	
	
	
	
	
	
	


