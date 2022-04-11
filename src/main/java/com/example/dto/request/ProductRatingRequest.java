package com.example.dto.request;

import java.util.List;

import lombok.Data;

@Data
public class ProductRatingRequest {

	private List<Long> idProduct;

	private List<Integer> rate;
	
	private Long idOrder;

}
