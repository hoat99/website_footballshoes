package com.example.dto.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BannerRequest {

	private Long idBanner;
	
	
//	private MultipartFile img;
	
	private String img;
	
	private String content;
	
	private String shortDescription;
	
	private String status;
}
