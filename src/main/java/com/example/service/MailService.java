package com.example.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.example.dto.request.MailRequest;
import com.example.dto.request.RegisterRequest;
import com.example.dto.request.UserProfileRequest;
import com.example.entity.User;

public interface MailService {
	
	void sendText(String mailTo, String subject, String content);
	
	void sendHtml(MailRequest request) throws MessagingException;
	
	void sendMailResetPassword(String recipientEmail, String link) throws MessagingException;

	void sendVerificationEmail(User user, String siteURL)
	        throws MessagingException, UnsupportedEncodingException;

}
