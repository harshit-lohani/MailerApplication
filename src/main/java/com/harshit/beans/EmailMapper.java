package com.harshit.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.util.HtmlUtils;

public class EmailMapper implements RowMapper<Email>{

	public Email mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Email email = new Email();
		email.setEmailUUID(rs.getString(1));
		email.setFromEmail(rs.getString(2));
		email.setSubject(HtmlUtils.htmlUnescape(rs.getString(3)));
		email.setSentDate(rs.getDate(4));
		email.setContent(HtmlUtils.htmlUnescape(rs.getString(5)));
		email.setAttachmentCount(rs.getInt(6));
		email.setAttachments(rs.getString(7));
		email.setStarred(rs.getString(8));
		
		if(email.getAttachmentCount() > 0) {
			String[] strList = email.getAttachments().split(",");
			email.setAttachmentArray(strList);
		}
		
		return email;
	}

}
