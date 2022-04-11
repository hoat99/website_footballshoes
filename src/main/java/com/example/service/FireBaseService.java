package com.example.service;

import java.util.List;

import com.example.dto.request.FirebaseTokenRequest;
import com.example.dto.request.NotificationRequest;
import com.example.entity.FirebaseToken;
import com.google.firebase.messaging.FirebaseMessagingException;

public interface FireBaseService {
	
	String sendNotification(String token, NotificationRequest request);
	
	int sendBatchNotification(List<String> tokens, NotificationRequest request) throws FirebaseMessagingException;
	
	int sendAllNotification(NotificationRequest request) throws FirebaseMessagingException;
	
	FirebaseToken saveToken(FirebaseTokenRequest tokenRequest);
}
