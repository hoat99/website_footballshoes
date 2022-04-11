package com.example.service;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dto.request.UserProfileRequest;
import com.example.entity.User;

public interface UserService {

	User getUser(String username);
	
	void updateUser(UserProfileRequest request);
	
	void updateResetPasswordToken(String token, String email);
	
	User getByResetPasswordToken(String token);
	
	void updatePassword(User user, String newPassword);
	
	boolean checkExistsEmail(String email);
	
	boolean verify(String verificationCode);
	
	void changePassword(String username, String oldPassword, String newPassword, RedirectAttributes ra);
}
