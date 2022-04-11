package com.example.security.factory;


import java.util.Map;

import com.example.exception.OAuth2AuthenticationProcessingException;
import com.example.security.provinder.AuthProvider;
import com.example.security.user.FacebookOAuth2UserInfo;
import com.example.security.user.GoogleOAuth2UserInfo;
import com.example.security.user.OAuth2UserInfo;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
