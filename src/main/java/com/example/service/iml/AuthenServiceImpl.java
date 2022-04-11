package com.example.service.iml;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.dto.request.LoginRequest;
import com.example.dto.request.RegisterRequest;
import com.example.entity.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.service.AuthenService;
import com.example.service.MailService;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;

@Service
@RequiredArgsConstructor
public class AuthenServiceImpl implements AuthenService{

	private final UserRepository userRepository; 
	
	private final RoleRepository roleRepository;
	
	private final MailService mailService;
	
	private final BCryptPasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    
	@Override
	@Transactional
	public boolean registerUser(HttpServletRequest request, Model model, RegisterRequest registerRequest, String URL) throws UnsupportedEncodingException, MessagingException {
		if (this.userRepository.existsById(registerRequest.getUsername())) {
			return false;
		}
		if (this.userRepository.findByEmail(registerRequest.getEmail()) != null) {
			return false;
		}
		User user = new User();
		user.setVerificationCode(RandomString.make(64));
		user.setEnabled(false);
		user.setUsername(registerRequest.getUsername());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setEmail(registerRequest.getEmail());
		user.setRole(this.roleRepository.findRoleByRoleCode(com.example.constant.RoleCode.USER));
		userRepository.save(user);
		
		this.mailService.sendVerificationEmail(user, URL);
		
		return true;
	}

	@Override
	public void authenticate(LoginRequest loginRequest) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
		Authentication authentication = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	@Override
	public boolean checkUserExist(String username) {
		if (this.userRepository.existsById(username)) {
			return true;
		}
		return false;	
	}


}
