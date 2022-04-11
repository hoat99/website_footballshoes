package com.example.dto.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageRequest {

	private Long id;
	
	private String nameProduct;
	
//	private MultipartFile avatar;
//	
//	private MultipartFile image1;
//	
//	private MultipartFile image2;
//
//	private MultipartFile image3;
//
//	private MultipartFile image4;
	
	private String avatar;
	
	private String image1;
	
	private String image2;

	private String image3;

	private String image4;

	
}
