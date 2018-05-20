package j2ee.spring.sellwatches.impl;

import java.util.Properties;

import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.services.ContactService;
import j2ee.spring.sellwatches.viewmodel.ContactViewModel;

import javax.mail.*;
import javax.mail.internet.*;

@Component
public class ContactServiceImplement implements ContactService {

	public boolean sendMessage(ContactViewModel contact) {
		 return send(contact);
	}
	
	private boolean send(ContactViewModel contact)
	{
		try{
            final String fromEmail = "tuvanthuan1996@gmail.com"; //requires valid gmail id
            final String password = "Thuan302"; // correct password for gmail id
            final String toEmail = "tuvanthuan120@gmail.com"; // can be any email id 

            System.out.println("TLSEmail Start");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.debug", "true"); 
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.smtp.EnableSSL.enable","true");
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
            props.setProperty("mail.smtp.socketFactory.fallbac k", "false"); 
            props.setProperty("mail.smtp.port", "465"); 
            props.setProperty("mail.smtp.socketFactory.port", "465"); 

                //create Authenticator object to pass in Session.getInstance argument
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
            Session session = Session.getInstance(props, auth);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(contact.getEmail()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Liên hệ từ khách hàng:"+contact.getName()+"\n Phone: "+contact.getPhone());    
            message.setText(contact.getMessage());

            Transport.send(message);
            System.out.println("Mail Sent");
            return true;
        }catch(Exception ex){
            System.out.println("Mail fail");
            System.out.println(ex);
            return false;
        }
	}
}
