package com.example.dto.request;

import java.util.List;

import lombok.Data;

@Data
public class CartRequest {

	private Long idCart;
	
	private String username;
	
	private Long idProduct;
	
	private Long quantity;
	
	List<Object> data;
}
