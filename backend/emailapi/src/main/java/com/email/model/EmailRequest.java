package com.email.model;

//Importing required classes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
	private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
