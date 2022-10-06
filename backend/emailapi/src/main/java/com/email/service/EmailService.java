// Service Interface

package com.email.service;

import com.email.model.EmailRequest;

// Importing required classes


// Interface
public interface EmailService {

	// Method
	// To send a simple email
	boolean sendSimpleMail(EmailRequest details);
	
//	String sendSimpleMail(EmailRequest details);	

	// Method
	// To send an email with attachment
	String sendMailWithAttachment(EmailRequest details);
}
