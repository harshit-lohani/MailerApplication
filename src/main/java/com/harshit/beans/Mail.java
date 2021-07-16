package com.harshit.beans;

import org.springframework.web.multipart.MultipartFile;

/*POJO class to store the email content
 * that is entered by the user for the MailerForm.jsp page.
 * bccEmail and ccEmail are the bcc and the cc recipients respectively
 * and can be left empty or null if none are present.
 */
public class Mail {
	
	private String toEmail;
	private String subject;
	private String body;
	private String bccEmail;
	private String ccEmail;
	private MultipartFile file;
	
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
}
