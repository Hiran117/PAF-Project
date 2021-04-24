package model;

import java.sql.*;
public class Users {

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
	
				public String insertUser(String name, String email, String userType, String pw) {
					String output = "";

					try {
						Connection con = connect();

						if (con == null) {
							return "Error while connecting to the database for inserting.";
						}
						// create a prepared statement
						String query = "insert into users (userID,name,email,userType,pw)" + "values (?,?,?,?,?)";
						PreparedStatement preparedStmt = con.prepareStatement(query);

						// binding values
						preparedStmt.setInt(1, 0);
						preparedStmt.setString(2, name);
						preparedStmt.setString(3, email);
						preparedStmt.setString(4, userType);
						preparedStmt.setString(5, pw);
						// execute the statement
						preparedStmt.execute();
						con.close();

						output = "Inserted successfully";

					} catch (Exception e) {
						output = "Error while inserting the Users.";
						System.err.println(e.getMessage());
					}
					return output;
				}
				
}
