package com.harshit.beans;

import java.sql.Date;

public class Email {
	private String emailUUID;
	private String fromEmail;
	private String subject;
	private String content;
	private String attachments;
	private String varchar;
	private Date sentDate;
	private int attachmentCount;
	private String starred;
	private String[] attachmentArray;
	
	
	public String getEmailUUID() {
		return emailUUID;
	}
	public void setEmailUUID(String emailUUID) {
		this.emailUUID = emailUUID;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAttachments() {
		return attachments;
	}
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	public String getVarchar() {
		return varchar;
	}
	public void setVarchar(String varchar) {
		this.varchar = varchar;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public int getAttachmentCount() {
		return attachmentCount;
	}
	public void setAttachmentCount(int attachmentCount) {
		this.attachmentCount = attachmentCount;
	}
	public String getStarred() {
		return starred;
	}
	public void setStarred(String starred) {
		this.starred = starred;
	}
	public String[] getAttachmentArray() {
		return attachmentArray;
	}
	public void setAttachmentArray(String[] attachmentArray) {
		this.attachmentArray = attachmentArray;
	}
	
	

	
	
}
