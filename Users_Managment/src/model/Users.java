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
	
}
