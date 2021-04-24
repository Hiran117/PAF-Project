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
				
				public String readUsers() {
					String output = "";
					try {
						Connection con = connect();
						if (con == null) {
							return "Error while connecting to the database for reading.";
						}
						// Prepare the html table to be displayed
						output = "<table border=\"1\"><tr><th>User ID</th><th>Name</th><th>Email</th><th>User Type</th><th>Password</th><th>Update</th><th>Remove</th></tr>";
						String query = "select * from users";
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						// iterate through the rows in the result set
						while (rs.next()) {

							String userID = Integer.toString(rs.getInt("userID"));
							String name = rs.getString("name");
							String email = rs.getString("email");
							String userType = rs.getString("userType");
							String pw = rs.getString("pw");

							// Add into the html table

							output += "<tr><td>"+ userID + "</td>";
							output += "<td>" + name + "</td>";
							output += "<td>" + email + "</td>";
							output += "<td>" + userType + "</td>";
							output += "<td>" + pw + "</td>";

							// buttons

							output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
									+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-UserID='"
									+ userID + "'>" + "</td></tr>";
						}
						con.close();
						// Complete the html table
						output += "</table>";
					} catch (Exception e) {
						output = "Error while reading the users.";
						System.err.println(e.getMessage());
					}
					return output;
				}
				
				public String updateUser(String userID, String name, String email, String userType, String pw)
				 {
					String output = "";

					try {
						Connection con = connect();
						if (con == null) {
							return "Error while connecting to the database for updating.";
				}
						// create a prepared statement
						String query = "UPDATE users SET name=?,email=?,userType=?,pw=? WHERE userID=?";
						PreparedStatement preparedStmt = con.prepareStatement(query);
						// binding values

							preparedStmt.setString(1, name);
							preparedStmt.setString(2, email);
							preparedStmt.setString(3, userType);
							preparedStmt.setString(4, pw);
							preparedStmt.setInt(5, Integer.parseInt(userID));

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
				
				
}
