package model;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
