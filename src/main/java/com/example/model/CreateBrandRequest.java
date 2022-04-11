package com.example.model;



import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CreateBrandRequest {

	
	private String name;
	
	private String img;
//	private MultipartFile img;
}
