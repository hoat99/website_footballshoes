package com.example.security.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.constant.RoleCode;
import com.example.constant.UserType;
import com.example.entity.User;
import com.example.exception.OAuth2AuthenticationProcessingException;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.security.factory.OAuth2UserInfoFactory;
import com.example.security.user.CustomUserDetail;
import com.example.security.user.OAuth2UserInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauth2User =  super.loadUser(userRequest);
        log.info(oauth2User.toString());
        return this.processAuthenticateUser(userRequest, oauth2User);
    }

    private OAuth2User processAuthenticateUser(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
        if(!StringUtils.hasText(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }

        Optional<User> userOptional = this.userRepository.findById(oAuth2UserInfo.getId());
        User user;
        if (userOptional.isPresent()){
            user = userOptional.get();
//            if(!user.getType().equals(UserType.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))) {
//                throw new OAuth2AuthenticationProcessingException("Có vẻ bạn đã đăng nhập bằng tài khoản " +
//                        user.getType() + ". Vui lòng sử dụng tài khoản " + user.getType() +
//                        " để đăng nhập.");
//            }
            user = updateExistsUser(user, oAuth2UserInfo);
        } else {
            user = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
        }
        return CustomUserDetail.createCustomUser(user, oAuth2User.getAttributes());
    }

    private User registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
        User user = new User();

        user.setUsername(oAuth2UserInfo.getId());
        user.setPassword(passwordEncoder.encode("12345"));
//        user.setType(UserType.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
        user.setName(oAuth2UserInfo.getName());
        user.setEmail(oAuth2UserInfo.getEmail());
//        user.setAvatar(oAuth2UserInfo.getImageUrl());
        user.setRole(roleRepository.findRoleByRoleCode(RoleCode.USER));
        return userRepository.save(user);
    }

    private User updateExistsUser(User user, OAuth2UserInfo oAuth2UserInfo) {
        user.setName(oAuth2UserInfo.getName());
//        user.setAvatar(oAuth2UserInfo.getImageUrl());
        return this.userRepository.save(user);
    }
}
