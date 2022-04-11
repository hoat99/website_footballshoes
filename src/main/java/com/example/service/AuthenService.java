package com.example.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.example.dto.request.LoginRequest;
import com.example.dto.request.RegisterRequest;
import com.example.entity.User;

public interface AuthenService {

	boolean registerUser(HttpServletRequest request, Model model, RegisterRequest registerRequest, String URL) throws UnsupportedEncodingException, MessagingException;
	
	void authenticate(LoginRequest loginRequest);
	
	boolean checkUserExist(String username);
	
}
