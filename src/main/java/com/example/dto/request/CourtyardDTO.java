package com.example.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CourtyardDTO {

	private Long id;
	
	private String type;
	
	private Integer numberProduct;
	
}
