package com.example.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfileResponse {

    private String username;

    private String name;

    private String email;
    
    private String phone;

}
