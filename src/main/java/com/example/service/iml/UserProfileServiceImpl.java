package com.example.service.iml;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.dto.request.UserProfileRequest;
import com.example.dto.response.UserProfileResponse;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.security.user.CustomUserDetail;
import com.example.service.UserProfileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService{

    private final UserRepository userRepository;

    private final HttpServletRequest request;

	@Override
	public UserProfileResponse getUserProfile() {
        return this.userProfileConverter(this.userRepository.findById(((CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()));

	}

	@Override
	public void updateProfile(String username, UserProfileRequest userProfileRequest) throws IOException {
		Optional<User> userOptional = this.userRepository.findById(username);
        if (!userOptional.isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        User u = userOptional.get();
        u.setName(userProfileRequest.getName());
        u.setEmail(userProfileRequest.getEmail());
        u.setPhone(userProfileRequest.getPhone());
        this.userRepository.save(u);
		
	}
	
	private UserProfileResponse userProfileConverter(Optional<User> user) {
        return user.map(u -> UserProfileResponse.builder().username(u.getUsername())
                .name(u.getName()).email(u.getEmail()).phone(u.getPhone()).build()).orElse(null);
    }
	


}
