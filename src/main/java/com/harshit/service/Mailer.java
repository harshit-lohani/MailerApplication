package com.harshit.service;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.web.multipart.MultipartFile;

import com.harshit.beans.Credentials;
import com.harshit.beans.Mail;

import java.util.Properties;

public class Mailer {

	private String userEmail;
	private String password;
	private String recipient;
	private String bccEmail;
	private String ccEmail;
	private String subject;
	private String body;
	private MultipartFile file;

	private static final String HOSTNAME = "mail.smtp.host";
	private static final String SOCKETFACTORYPORT = "mail.smtp.socketFactoryPort";
	private static final String SOCKETFACTORYCLASS = "mail.smtp.socketFactory.class";
	private static final String AUTHENTICATION = "mail.smtp.auth";
	private static final String PORTNUMBER = "mail.smtp.port";

	public Mailer(String userEmail, String password, String recipient, String subject, String body, String bcc,
			String cc) {
		this.userEmail = userEmail;
		this.password = password;
		this.recipient = recipient;
		this.subject = subject;
		this.body = body;
	}

	public Mailer(Mail mail, Credentials cred) {
		this.userEmail = cred.getUserEmail();
		this.password = cred.getPassword();
		this.recipient = mail.getToEmail();
		this.subject = mail.getSubject();
		this.body = mail.getBody();
		this.bccEmail = mail.getBccEmail();
		this.ccEmail = mail.getCcEmail();
		this.file = mail.getFile();
	}

	/*
	 * This function takes hostname, port number, socket class and authentication
	 * bool to create an object of Properties class and returns the same.
	 */
	Properties createProperty(String hostname, String portNumber, String authentication, String socketClass) {
		Properties prop = new Properties();
		prop.put(HOSTNAME, hostname);
		prop.put(PORTNUMBER, portNumber);
		prop.put(SOCKETFACTORYCLASS, socketClass);
		prop.put(SOCKETFACTORYPORT, portNumber);
		prop.put(AUTHENTICATION, authentication);
		return prop;
	}

	/*
	 * This function takes sender's email ID as String, password as String and SMTP
	 * properties as a Properties object and returns the default instance of the
	 * Session object with those parameters.
	 */
	Session createSession(final String userEmail, final String userPassword, Properties prop) {
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userEmail, userPassword);
			}
		});

		return session;
	}

	/*
	 * This function takes a Session object, from address, to address, subject and
	 * body and returns an object of class Message. The function checks for valid
	 * email format and throws a Messaging Exception if email is not valid, or
	 * subject or body is null or not string
	 */
	Message createMessage(Session session, String from, String toEmail, String subjectText, String body,
			String bccEmail, String ccEmail) throws MessagingException {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//        if(bccEmail != "" && bccEmail != null)
//        	message.setRecipient(Message.RecipientType.BCC, new InternetAddress(bccEmail));
//        if(ccEmail != "" && ccEmail != null)
//        	message.setRecipient(Message.RecipientType.CC, new InternetAddress(ccEmail));
		message.setSubject(subjectText);
		message.setText(body);
		return message;
	}

	public Message getMessage() {

		final String hostname = "smtp.gmail.com";
		final String portNumber = "465";
		final String checkAuthentication = "true";
		final String socketClass = "javax.net.ssl.SSLSocketFactory";

		Properties prop = this.createProperty(hostname, portNumber, checkAuthentication, socketClass); // creates a
																										// Properties
																										// object with
																										// SMTP
																										// parameters
		Session session = this.createSession(this.userEmail, this.password, prop); // create session using object's
																					// email id and password
		Message message = null; // create an object of Message class

		try {
			message = this.createMessage(session, this.userEmail, this.recipient, this.subject, this.body,
					this.bccEmail, this.ccEmail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return message;
	}

	/*
	 * This function takes an object of class Message and tries to send the mail
	 * through the described properties in the Message object. The function throws a
	 * Messaging Exception if Message object is NULL or of wrong format.
	 */
	void sendMessage(Message message) throws MessagingException {
		Transport.send(message);
	}

	public boolean callMailer() {

		// local variables to initialize SMTP Properties object
		final String hostname = "smtp.gmail.com";
		final String portNumber = "465";
		final String checkAuthentication = "true";
		final String socketClass = "javax.net.ssl.SSLSocketFactory";

		Properties prop = this.createProperty(hostname, portNumber, checkAuthentication, socketClass); // creates a
																										// Properties
																										// object with
																										// SMTP
																										// parameters
		Session session = this.createSession(this.userEmail, this.password, prop); // create session using object's
																					// email id and password
		Message message; // create an object of Message class

		try {
			message = this.createMessage(session, this.userEmail, this.recipient, this.subject, this.body,
					this.bccEmail, this.ccEmail); // composes the message
			this.sendMessage(message); // tries to send the message using the message's properties
			return true;
		} catch (Exception e) {
			System.out.println("Invalid email or password!");
			e.printStackTrace();
			return false;
		}
	}
	
//	public BodyPart getAttachment(MultipartFile file) throws Exception{
//		String newPath = "E:\\JavaProjects\\EmailSpringDB\\src\\main\\temp\\";
//		BodyPart attachment = new MimeBodyPart();
//		String filename = newPath + file.getOriginalFilename();
//		FileDataSource source = new FileDataSource(filename);
//		attachment.setDataHandler(new DataHandler(source));
//		attachment.setFileName(filename);
//		return attachment;
//	}

	public boolean callMailerSimple() {

		try {
			Message message = this.getMessage();
			
			String newPath = "E:\\JavaProjects\\EmailSpringDB\\src\\main\\temp\\";
			
			if (!this.file.isEmpty()) {
				BodyPart attachment = new MimeBodyPart();
				String filename = newPath + file.getOriginalFilename();// change accordingly
				System.out.println("FILENAME IS: " + filename);
				FileDataSource source = new FileDataSource(filename);
				attachment.setDataHandler(new DataHandler(source));
				attachment.setFileName(filename);

				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(attachment);

				message.setContent(multipart);
			}
			
			
			Transport.send(message);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	public boolean callMailerAttach() {
		try {
			Message message = this.getMessage();
			BodyPart attachment = new MimeBodyPart();

			String newPath = "E:\\JavaProjects\\EmailSpringDB\\src\\main\\temp\\";

			String filename = newPath + file.getOriginalFilename();// change accordingly
			System.out.println("FILENAME IS: " + filename);
			FileDataSource source = new FileDataSource(filename);
			attachment.setDataHandler(new DataHandler(source));
			attachment.setFileName(filename);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(attachment);

			message.setContent(multipart);
			Transport.send(message);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
