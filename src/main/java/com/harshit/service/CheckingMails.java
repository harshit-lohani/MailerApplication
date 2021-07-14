package com.harshit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import com.harshit.beans.Email;

public class CheckingMails {

	private static String host = "pop.gmail.com";
	
	public static List<Email> checkEmails(String user, String password) {
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

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			for (int i = 0, n = Math.min(messages.length, 10); i < n; i++) {
				Message message = messages[i];

				Email email = new Email();
				email.setEmailNumber(i + 1);
				email.setSubject(message.getSubject());
				email.setFrom(message.getFrom()[0].toString());
				email.setContent(message.getContent().toString());

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