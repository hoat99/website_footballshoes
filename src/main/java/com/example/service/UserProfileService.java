package com.example.service;

import java.io.IOException;

import com.example.dto.request.UserProfileRequest;
import com.example.dto.response.UserProfileResponse;

public interface UserProfileService {

    UserProfileResponse getUserProfile();

    void updateProfile(String username, UserProfileRequest userProfileRequest) throws IOException;
	
}
