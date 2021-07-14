package com.harshit.service;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import com.harshit.beans.Credentials;
import com.harshit.beans.Mail;

public class MailerAttatched extends Mailer {

	public MailerAttatched(Mail mail, Credentials cred) {
		super(mail, cred);
	}

	public boolean callMailerAttatch(){
		 try {
			 Message message = this.getMessage();
			 BodyPart messageBodyPart1 = new MimeBodyPart();  
		     messageBodyPart1.setText("This is message body"); 
		     
		     MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		     
		     String filename = "E:/JavaProjects/EmailSpringDB/src/main/webapp/images/img1.jpeg";//change accordingly  
		     FileDataSource source = new FileDataSource(filename);  
		     messageBodyPart2.setDataHandler(new DataHandler(source));  
		     messageBodyPart2.setFileName(filename);  
		     
		     
		     Multipart multipart = new MimeMultipart();  
		     multipart.addBodyPart(messageBodyPart1);  
		     multipart.addBodyPart(messageBodyPart2); 
		     
		     message.setContent(multipart );  
		     Transport.send(message);  
		     return true;
		     
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return false;
	 }
}
