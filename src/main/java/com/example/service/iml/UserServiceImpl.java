package com.example.service.iml;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dto.request.UserProfileRequest;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final EntityManager entityManager;

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder encoder;

	@Override
	public User getUser(String username) {
//		Optional<User> user = this.userRepository.findById(username);
//		User user2 = new User();
//		if (user.isPresent()) {
//		    user2 = user.get();
//		}
		User user2 = this.entityManager.find(User.class, username);
		return user2;
	}

	@Override
	public void updateUser(UserProfileRequest request) {
		User user = this.userRepository.getById(request.getUsername());
		if (user != null) {
			user.setAddress(request.getAddress());
			user.setEmail(request.getEmail());
			user.setGender(request.getGender());
			user.setName(request.getName());
			user.setPhone(request.getPhone());
			userRepository.save(user);
		}
	}

	@Override
	public void updateResetPasswordToken(String token, String email) {
		User user = this.userRepository.findByEmail(email);
		if (user != null) {
			user.setResetPasswordToken(token);
			userRepository.save(user);
		}
	}

	@Override
	public User getByResetPasswordToken(String token) {
		return this.userRepository.findByResetPasswordToken(token);
	}

	@Override
	public void updatePassword(User user, String newPassword) {
		String encodedPassword = encoder.encode(newPassword);
		user.setPassword(encodedPassword);
		user.setResetPasswordToken(null);
		userRepository.save(user);
	}

	@Override
	public boolean checkExistsEmail(String email) {
		if (this.userRepository.findByEmail(email) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean verify(String verificationCode) {
		User user = userRepository.findByVerificationCode(verificationCode);
	     
	    if (user == null || user.getEnabled()) {
	        return false;
	    } else {
	        user.setVerificationCode(null);
	        user.setEnabled(true);
	        userRepository.save(user);	         
	        return true;
	    }
	}

	@Override
	public void changePassword(String username, String oldPassword, String newPassword, RedirectAttributes ra) {
		User user = this.userRepository.getById(username);
		
		if (encoder.matches(oldPassword, user.getPassword())) {
			user.setPassword(encoder.encode(newPassword));
			userRepository.save(user);
			ra.addFlashAttribute("success", "Thay đổi mật khẩu thành công");
		}else {
			ra.addFlashAttribute("fail", "Mật khẩu không chính xác!");
		}
	}

}
