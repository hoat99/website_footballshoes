package com.example.dto.response;

import com.google.auto.value.AutoValue.Builder;

import lombok.Data;

@Data
@Builder
public class BannerResponse {

	private String img;
	
	private String content;
	
	private String shortDescription;
	
}
