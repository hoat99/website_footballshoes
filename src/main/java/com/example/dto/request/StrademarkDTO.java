package com.example.dto.request;

import lombok.Builder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class StrademarkDTO {

	private Long id;
	
	private String name;
	
	private String img;
	
	private Integer numberProduct;
}
