package model;

import java.sql.*;



public class Funders {

	// A common method to connect to the DB

	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paf_db" ,"root" ,"hiran97");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertFunder(String fundAmount, String name, String email, String cardNumber, String fundReqDate) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = "insert into funders (funderID,fundAmount,name,email,cardNumber,fundReqDate)" + "values (?,?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, fundAmount);
			preparedStmt.setString(3, name);
			preparedStmt.setString(4, email);
			preparedStmt.setString(5, cardNumber);
			preparedStmt.setString(6, fundReqDate);
			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Inserted successfully";

		} catch (Exception e) {
			output = "Error while inserting the Funders.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String readFunders() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Funder ID</th><th>Fund Amount</th><th>Name</th><th>Email</th><th>Card Number</th><th>Fund Request Date</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from funders";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {

				String funderID = Integer.toString(rs.getInt("funderID"));
				String fundAmount = rs.getString("fundAmount");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String cardNumber = rs.getString("cardNumber");
				String fundReqDate = rs.getString("fundReqDate");

				// Add into the html table

				output += "<tr><td><input id='hidFunderIDUpdate' name='hidFunderIDSUpdate' type='hidden' value='"
						+ funderID + "'>" + funderID + "</td>";
				output += "<td>" + fundAmount + "</td>";
				output += "<td>" + name + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + cardNumber + "</td>";
				output += "<td>" + fundReqDate + "</td>";

				// buttons

				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-funderID='"
						+ funderID + "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the funders.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String updateFunder(String funderID, String fundAmount, String name, String email, String cardNumber, String fundReqDate)
	 {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
	}
			// create a prepared statement
			String query = "UPDATE Funders SET fundAmount=?,name=?,email=?,cardNumber=?,fundReqDate=? WHERE funderID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values

				preparedStmt.setString(1, fundAmount);
				preparedStmt.setString(2, name);
				preparedStmt.setString(3, email);
				preparedStmt.setString(4, cardNumber);
				preparedStmt.setString(5, fundReqDate);
				preparedStmt.setInt(6, Integer.parseInt(funderID));

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
	

	public String deleteFunder(String funderID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from funders where funderID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(funderID));
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
