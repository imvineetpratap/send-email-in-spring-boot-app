package com.email.service;

import com.email.model.EmailRequest;
//Importing required classes
import java.io.File;
import java.util.Collections;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	 @Autowired private JavaMailSender javaMailSender;
	 
	    @Value("${spring.mail.username}") private String sender;
	 
	    // Method 1
	    // To send a simple email
	    
	    
	    @Override
		public boolean sendSimpleMail(EmailRequest details) {

	      boolean flag=false;
	    	// Try block to check for exceptions
	        try {
	 
	            // Creating a simple mail message
	            SimpleMailMessage mailMessage
	                = new SimpleMailMessage();
	 
	            // Setting up necessary details
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(details.getRecipient());
	            mailMessage.setText(details.getMsgBody());
	            mailMessage.setSubject(details.getSubject());
	 
	            // Sending the mail
	            javaMailSender.send(mailMessage);
//	           String str="Mail Sent Successfully";
//	            return str;
	            flag=true;
	        }
	 
	        // Catch block to handle the exceptions
	        catch (Exception e) {
//	        	String str2="Error while Sending Mail";
	            
	        }
			return flag;
		}   
//	@Override
//	public String sendSimpleMail(EmailRequest details) {
//
//        // Try block to check for exceptions
//        try {
// 
//            // Creating a simple mail message
//            SimpleMailMessage mailMessage
//                = new SimpleMailMessage();
// 
//            // Setting up necessary details
//            mailMessage.setFrom(sender);
//            mailMessage.setTo(details.getRecipient());
//            mailMessage.setText(details.getMsgBody());
//            mailMessage.setSubject(details.getSubject());
// 
//            // Sending the mail
//            javaMailSender.send(mailMessage);
//           String str="Mail Sent Successfully";
//            return str;
//        }
// 
//        // Catch block to handle the exceptions
//        catch (Exception e) {
//        	String str2="Error while Sending Mail";
//            return str2;
//        }
//	}
	
	// Method 2
    // To send an email with attachment
	@Override
	public String sendMailWithAttachment(EmailRequest details) {
		 // Creating a mime message
        MimeMessage mimeMessage
            = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                details.getSubject());
 
            // Adding the attachment
            FileSystemResource file
                = new FileSystemResource(
                    new File(details.getAttachment()));
 
            mimeMessageHelper.addAttachment(
                file.getFilename(), file);
 
            // Sending the mail
            javaMailSender.send(mimeMessage);
            
            String str="Mail Sent Successfully...";
            return str;
           
        }
 
        // Catch block to handle MessagingException
        catch (MessagingException e) {
 
            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }
	
	}


