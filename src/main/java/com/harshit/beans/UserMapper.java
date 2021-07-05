package com.harshit.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

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
        return e;
	}

}
