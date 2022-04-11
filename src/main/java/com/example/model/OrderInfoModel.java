package com.example.model;

import com.example.entity.OrderInfo;
import com.example.entity.Product;

import lombok.Data;

@Data
public class OrderInfoModel {

	private Product product;
	
	private OrderInfo orderInfo;
	
}
