package model.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	private int userId;
	private String username;
	private String email;
	private String password;
	private boolean userStatus;
	
	public UserBean() {
		
	}

	public UserBean(int userId, String username, String email, String password, boolean userStatus) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.userStatus = userStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isUserStatus() {
		return userStatus;
	}

	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}

	

}
