package com.example.dto.request;

import java.util.List;

import lombok.Data;

@Data
public class UpdateCartRequest {

	private List<Long> idCart;
	
	private List<Long> quantity;
	
}
