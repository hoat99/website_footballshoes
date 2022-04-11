package com.example.dto.request;

import java.util.List;

import lombok.Data;

@Data
public class CreateImportGoodsRequest {

	private List<Long> idProduct;
	
	private List<Integer> quantity;
	
	private Long idSupplier;
	
}
