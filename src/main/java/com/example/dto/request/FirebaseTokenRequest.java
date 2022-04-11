package com.example.dto.request;

import lombok.Data;

@Data
public class FirebaseTokenRequest {

    private String token;

    private String deviceInfo;
}
