package com.harshit.beans;

/*POJO class to store login credentials
 * from the user during login phase.
 * Username is the logged in user's Gmail address
 * and password is the logged in user's Gmail password 
 */

public class Credentials {
	private String userEmail;
	private String password;
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
