package com.harshit.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


/*RowMapper class to map the Users contents of the database from ResultSet object to
 * User object. The calling function is 
 * "select id, firstname, lastname, gender, phonenumber, email, password
 *  	from users;
 *  	"
 *  Rows are mapped according to the query and must be modified according
 *  to the query
 */
public class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
        User e=new User();    
        
        e.setId(rs.getInt(1));    
        e.setFirstName(rs.getString(2));
        e.setLastName(rs.getString(3));
        e.setGender(rs.getString(4));
        e.setPhoneNumber(rs.getString(5));
        e.setEmail(rs.getString(6));
        e.setPassword(rs.getString(7));
        e.setRole(rs.getString(9));
        
        System.out.println(rs.getString(9));
        
        return e;
        
	}

}
