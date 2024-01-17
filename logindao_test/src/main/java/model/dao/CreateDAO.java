package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.DBConnection;

public class CreateDAO {
	public int createDAO(String username, String email, String password) throws ClassNotFoundException, SQLException {
		
		int processingNumber = 0;
		
		String sql = "INSERT INTO users (username,email, password) VALUES (?, ?, ?)";
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, username);
			stmt.setString(2, email);
			stmt.setString(3, password);
			
			processingNumber = stmt.executeUpdate();
		}
		return processingNumber;
				
	}
	
}
