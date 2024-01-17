package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DBConnection;

//ログイン用
public class LoginDAO {
	public boolean validate(String email, String password) throws SQLException, ClassNotFoundException {
		
		boolean status = false;
		String sql = "SELECT * FROM users WHERE email=? AND password=?";
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
				
				stmt.setString(1, email);
				stmt.setString(2, password);
				
				ResultSet rs = stmt.executeQuery();
				status = rs.next();
		}
		return status;
	}
	
	//ユーザーID取得
	public int getUserId(String email) throws ClassNotFoundException, SQLException {
		int UserId = -1;
		String sql = "SELECT user_id FROM users WHERE email = ?";
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				UserId = rs.getInt("user_id");
			}
			return UserId;
		}
	}
		
		//ログイン用
//		public UserBean validate(String email,String password)
//				throws ClassNotFoundException, SQLException {
//			UserBean user = new UserBean();
//			String sql ="SELECT * FROM users WHERE email = ? AND password = ? AND admin_status = true";
//			try(Connection con = DBConnection.getConnection();
//					PreparedStatement stmt = con.prepareStatement(sql)){
//				stmt.setString(1, email);
//				stmt.setString(2, password);
//				ResultSet res = stmt.executeQuery();
//				while(res.next()) {
//					user = new UserBean();
//					user.setUserId(res.getInt("user_id"));
//					user.setUsername(res.getString("username"));
//					user.setEmail(res.getString("email"));
//					user.setPassword(res.getString("password"));
//					user.setUserStatus(res.getBoolean("user_status"));
//				}
//				return user;
//			}
//	}
}
