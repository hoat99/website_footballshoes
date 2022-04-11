package com.example.dto.request;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
	
	@NotEmpty(message = "Không được bỏ trống mục này")
	private String username;
	
	@NotEmpty(message = "Không được bỏ trống mục này")
	private String password;
}
