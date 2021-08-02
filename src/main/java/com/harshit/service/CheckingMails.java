package com.harshit.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.util.HtmlUtils;

import com.harshit.beans.Email;

public class CheckingMails {

	private static String host = "pop.gmail.com";
	
//	public static List<Email> checkEmails(String user, String password) {
//		List<Email> mailList = new ArrayList<Email>();
//		try {
//
//			// create properties field
//			Properties properties = new Properties();
//
//			properties.put("mail.pop3.host", host);
//			properties.put("mail.pop3.port", "995");
//			properties.put("mail.pop3.starttls.enable", "true");
//			Session emailSession = Session.getInstance(properties);
//
//			// create the POP3 store object and connect with the pop server
//			Store store = emailSession.getStore("pop3s");
//
//			store.connect(host, user, password);
//			
//			Folder[] f = store.getDefaultFolder().list();
//			for(Folder fd:f)
//			    System.out.println(">> "+fd.getName());
//
//			// create the folder object and open it
//			Folder emailFolder = store.getFolder("INBOX");
//			emailFolder.open(Folder.READ_ONLY);
//
//			// retrieve the messages from the folder in an array and print it
//			Message[] messages = emailFolder.getMessages();
//			System.out.println("messages.length---" + messages.length);
//
//			for (int i = 0, n = messages.length ; i < n; i++) {
//				Message message = messages[i];
//
//				Email email = new Email();
//				email.setEmailNumber(i + 1);
//					
//				String subject = message.getSubject();
//				
//				if(subject.length() >= 5 && subject.substring(0, 5).equals("[ENC]")) {
//					try {
//					String newSubject = subject.substring(5);
//					System.out.println(newSubject);
//					newSubject = "[ENC]" + MailEncryptor.caesarCipherDecrypte(newSubject);
//					System.out.println(newSubject);
//					subject = newSubject;
//					}catch(Exception e) {
//						e.printStackTrace();
//					}
//				}
//				
//				email.setSubject(StringEscapeUtils.escapeHtml4(subject));
//				email.setFrom(message.getFrom()[0].toString());
//				email.setContent(message.getContent().toString());
//
//				mailList.add(email);
//			}
//
//			// close the store and folder objects
//			emailFolder.close(false);
//			store.close();
//
//		} catch (NoSuchProviderException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return mailList;
//	}
	
	
	public static List<Email> downloadEmails(String userId, String user, String password) {
		List<Email> mailList = new ArrayList<Email>();
		try {

			// create properties field
			Properties properties = new Properties();

			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getInstance(properties);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");

			store.connect(host, user, password);
			
			Folder[] f = store.getDefaultFolder().list();
			for(Folder fd:f)
			    System.out.println(">> "+fd.getName());

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			for (int i = 0, n = messages.length ; i < n; i++) {
				MimeMessage message = (MimeMessage) messages[i];
				Address[] fromAddress = message.getFrom();
				String fromEmail = fromAddress[0].toString();
				String subject = message.getSubject();
				Date sentDate = new java.sql.Date(message.getSentDate().getTime());  
				
				UUID emailUUID = UUID.randomUUID();	
				
				String contentType = message.getContentType();
				String messageContent = "";
				
				String attachFiles = "";
				int attachmentCount = 0;
				
				if(contentType.contains("multipart")) {
					//this email contains attachment
					Multipart multipart = (Multipart) message.getContent();
					
					for(int j = 0 ; j < multipart.getCount() ; j++) {
						MimeBodyPart part = (MimeBodyPart) multipart.getBodyPart(j);
						if(Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
							//this part is an attachment
							//code to save attachment

							String extension = FilenameUtils.getExtension(part.getFileName());
							if(extension == "exe") {
								//we do not save exe files
								continue;
							}
							String fileName = emailUUID+"_"+attachmentCount+"."+extension;
							attachmentCount++;
							attachFiles += fileName + ", ";
							part.saveFile("E:\\JavaProjects\\EmailSpringDB\\src\\main\\temp\\Attachments\\" + fileName);
						}
						else {
							//multipart is text file
							messageContent = part.getContent().toString();
						}
					}
					
					//truncate attachfile ending
				}
				else if(contentType.contains("text/plain") || contentType.contains("text/html")) {
					Object content = message.getContent();
					if(content != null) {
						messageContent = content.toString();
					}
				}
				
				
				if(attachFiles.length() > 0) {
					attachFiles = attachFiles.substring(0, attachFiles.length() - 1);
				}
				
				
                // print out details of each message
                System.out.println("Message #" + (i + 1) + ":");
//                System.out.println("\t UUID: " + emailUUID);
//                System.out.println("\t From: " + fromEmail);
//                System.out.println("\t Subject: " + subject);
//                System.out.println("\t Sent Date: " + sentDate);
//                System.out.println("\t Message: " + messageContent);
//                System.out.println("\t Attachments: " + attachFiles);
                
                Email email = new Email();
                email.setEmailUUID(emailUUID.toString());
                email.setFromEmail(fromEmail);
                email.setSubject(HtmlUtils.htmlEscape(subject));
                email.setSentDate(sentDate);
                email.setContent(HtmlUtils.htmlEscape(messageContent));
                email.setAttachmentCount(attachmentCount);
                email.setAttachments(attachFiles);
                
                mailList.add(email);
                
			}

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mailList;
	}
	
	
	
}