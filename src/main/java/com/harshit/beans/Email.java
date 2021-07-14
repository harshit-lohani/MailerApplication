package com.harshit.beans;

public class Email {
	private int emailNumber;
	private String from;
	private String subject;
	private String content;
	private String body;
	private String bccEmail;
	private String ccEmail;
	
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getBccEmail() {
		return bccEmail;
	}
	
	public void setBccEmail(String bccEmail) {
		this.bccEmail = bccEmail;
	}
	
	public String getCcEmail() {
		return ccEmail;
	}
	
	public void setCcEmail(String ccEmail) {
		this.ccEmail = ccEmail;
	}
	
	public int getEmailNumber() {
		return emailNumber;
	}
	
	public void setEmailNumber(int emailNumber) {
		this.emailNumber = emailNumber;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}
