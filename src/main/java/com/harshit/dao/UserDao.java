package com.harshit.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.harshit.beans.Credentials;
import com.harshit.beans.User;
import com.harshit.beans.UserMapper;

@Repository
public class UserDao {

	private JdbcTemplate template;
	
	public void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into Users(firstName, lastName, gender, phoneNumber, email, pword) values('" + user.getFirstName() + "','" + user.getLastName()
					+ "','" + user.getGender() + "','" + user.getPhoneNumber() + "','" + user.getEmail() + "','" + user.getPassword() + "')";
		
		return template.update(sql);
		
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return template.query("select * from Users",new UserMapper()); 
		
	}  
	


	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public User validateCredentials(Credentials cred) {
		
		List<User> list = getUserByEmail(cred.getUserEmail());
	
		if(list.isEmpty()) {
			System.out.println("NOTFOUND");
			return null;
		}
		
		User user = list.get(0);
		System.out.println("UserEmail: " + user.getEmail());
		System.out.println("UserPassword: " + user.getPassword());
		
		if(list.get(0).getPassword().compareTo(cred.getPassword()) == 0) {
			return list.get(0);
		}
		
		return null;
		
	}
	
	
	
	public List<User> getUserByEmail(String email) {
		String sql = "select * from users where email = '" + email + "';";
		return template.query(sql, new UserMapper());
	}
	
}
