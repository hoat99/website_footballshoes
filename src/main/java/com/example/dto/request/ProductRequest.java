package com.example.dto.request;

import java.math.BigDecimal;

import com.example.entity.Courtyard;
import com.example.entity.Image;
import com.example.entity.Strademark;

import lombok.Data;

@Data
public class ProductRequest {

	private Long idProduct;
	
	private String name;
	
	private BigDecimal cost;
	
	private Long quantity;
	
	private String material;
	
	private String representativePlayer;
	
	private String album;
	
	private Long yearOfProduction;
	
	private String technology;
	
	private Long idStrademark;
	
	private  Long idCourtyard;
	
	private Long size;
	
	private String color;
	
	private String imgProduct;
	
}
