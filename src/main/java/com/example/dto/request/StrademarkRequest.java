package com.example.dto.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class StrademarkRequest {

	private Long idStrademark;
	
	private String name;
	
//	private MultipartFile img; 
	
	private String img;
	
	
}
