package com.example.service.iml;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.dto.request.FirebaseTokenRequest;
import com.example.dto.request.NotificationRequest;
import com.example.entity.FirebaseToken;
import com.example.repository.TokenRepository;
import com.example.service.FireBaseService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.MulticastMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class FirebaseServiceImpl implements FireBaseService {

	@Value("${firebase.config-file}")
	private String configFilePath;

	private final TokenRepository tokenRepository;

	@PostConstruct
	public void initFirebase() {
		log.info("Start init");
		try {
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(
							GoogleCredentials.fromStream(new ClassPathResource(configFilePath).getInputStream()))
					.setDatabaseUrl("https://my-first-firebase-projec-d714f.firebaseio.com").build();
			if (FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options);
				log.info("Firebase application has been initialized");
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public String sendNotification(String token, NotificationRequest request) {
		Message message = Message.builder().putData("content", request.getContent())
				.putData("title", request.getTitle()).putData("link", request.getLink()).setToken(token).build();
		String response = StringUtils.EMPTY;
		try {
			response = FirebaseMessaging.getInstance().send(message);
		} catch (FirebaseMessagingException e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public int sendBatchNotification(List<String> tokens, NotificationRequest request)
			throws FirebaseMessagingException {
		MulticastMessage message = MulticastMessage.builder().putData("title", request.getTitle())
				.putData("content", request.getContent()).putData("link", request.getLink()).addAllTokens(tokens)
				.build();
		BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
		return response.getSuccessCount();
	}

	@Override
	public FirebaseToken saveToken(FirebaseTokenRequest tokenRequest) {
		FirebaseToken firebaseToken = this.tokenRepository.findById(tokenRequest.getToken())
				.orElse(new FirebaseToken());
		firebaseToken.setToken(tokenRequest.getToken());
		firebaseToken.setDeviceInfo(tokenRequest.getDeviceInfo());
		return this.tokenRepository.save(firebaseToken);
	}

	@Override
	public int sendAllNotification(NotificationRequest request) throws FirebaseMessagingException {
		List<String> tokens = this.tokenRepository.findAll().parallelStream().map(FirebaseToken::getToken)
				.collect(Collectors.toList());
				MulticastMessage message = MulticastMessage.builder().putData("title", request.getTitle())
				.putData("content", request.getContent()).putData("link", request.getLink()).addAllTokens(tokens)
				.build();
		BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
		return response.getSuccessCount();
	}

}
