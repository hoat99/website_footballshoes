package com.example.dto.request;

import lombok.Data;

@Data
public class MailRequest {

	private String name;
	
	private String phone;
	
	private String subject;

    private String content;

    private String mailFrom;
    
    private String mailTo;
	
}
