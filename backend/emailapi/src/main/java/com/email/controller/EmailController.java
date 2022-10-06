package com.email.controller;

import com.email.model.EmailRequest;
import com.email.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmailController {
   
	@Autowired
	private EmailService emailService;
    @RequestMapping("/welcome")
    public String welcome(){
        return "working";
    }
    
    

    
    @PostMapping("/sendemail")
    public ResponseEntity<?> sendMail(@RequestBody EmailRequest details)
    {
    	System.out.println(details);
        boolean status= emailService.sendSimpleMail(details);
System.out.println("status:"+status);
if(status){
  return ResponseEntity.ok("email send sucessfully");
}
else{
  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("email not send");
}
    }
    

    
    
    
    
 // Sending email with attachment 
    //send in raw/json and for attachment use its path in json only
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailRequest details)
    {
    	System.out.println(details);
        String status= emailService.sendMailWithAttachment(details);
        System.out.println("status:"+status);
        return status;
    }
}
