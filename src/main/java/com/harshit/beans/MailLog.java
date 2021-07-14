package com.harshit.beans;


/*
 *POJO class to store the Mail Log retrieved from the database.
 *Status is a string holds "Sent" or "Not sent" depending upon the user transaction 
 *Send time holds the time of sending in dd--mm--yy hh--mm--ss in 24 hour format
 */

public class MailLog {
	private int id;
	private String email;
	private String toEmail;
	private String subject;
	private String body;
	private String sendTime;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

}
