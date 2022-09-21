package com.intern.crs.common;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

	public static void main(String[] args) {
		SendEmail email = new SendEmail();
		email.sendEmailForPasswordReset("ammu.ganga@gmail.com");
	}
	
	public void sendEmailForPasswordReset(String emailId) {
		String subject = "Course Recommender Portal - Password Reset";
		try {
			Properties properties=new Properties();  
			
			/*
			 * properties.put("mai.smtp.auth", "true");
			 * properties.put("mail.smtp.starttls.enable", "true");
			 * properties.put("mail.smtp.host", "smtp.office365.com");
			 * properties.put("mail.smtp.port", "587");
			 * properties.put("mail.smtp.ssl.trust", "smtp.office365.com"); Session
			 * session=Session.getInstance(properties, new Authenticator() {
			 * 
			 * @Override protected PasswordAuthentication getPasswordAuthentication() {
			 * return new PasswordAuthentication("amutha.ganga@optisolbusiness.com",
			 * "Amu@Optisol"); } });
			 */
			  
			properties.put("mai.smtp.auth", "true");
			properties.setProperty("mail.smtp.host", "smtp.gmail.com"); 
			properties.put("mail.smtp.port", "25");
			properties.put("mail.smtp.starttls.enable", "true");
			Session session=Session.getInstance(properties, null);
		      
			// create the message
			Message message = new MimeMessage(session);
			MimeBodyPart mailbody = new MimeBodyPart();
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
			message.setFrom(new InternetAddress("ammu.ganga@gmail.com"));
			message.setSubject(subject);
			mailbody.setText("Dear user, \n \n Kindly click on the below link to reset your password: \n +"
					+ "<a href=\"http://localhost:8080/CourseRecommender/resetPassword.jsp?id="+emailId+"\">Click here to reset password</a> \n"
					+ "\n Regards, \n CRS Portal Support Team \n");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mailbody);
			message.setContent(multipart, "text/html");
			message.setSentDate(new Date());
			Transport.send(message, "ammu.ganga@gmail.com", "wlixwuqzljyizrcd");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
