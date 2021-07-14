package com.harshit.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


/*RowMapper class to map the Mail Log contents from the base from ResultSet object to
 * MailLog object. The calling function is 
 * "select id, email, toemail, subject, body, sendTime, status
 *  	from maillog
 *  	where email = 'user_email';
 *  	"
 *  Rows are mapped according to the query and must be modified according
 *  to the query
 */
public class MailLogMapper implements RowMapper<MailLog>{

	public MailLog mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		MailLog e = new MailLog();
		e.setId(rs.getInt(1));
		e.setEmail(rs.getString(2));
		e.setToEmail(rs.getString(3));
		e.setSubject(rs.getString(4));
		e.setBody(rs.getString(5));
		e.setSendTime(rs.getString(6));
		e.setStatus(rs.getString(7));
		return e;
	}

}
