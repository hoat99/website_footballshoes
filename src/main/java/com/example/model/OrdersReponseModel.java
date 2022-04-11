package com.example.model;

import java.math.BigDecimal;
import java.util.List;

import com.example.entity.OrderInfo;
import com.example.entity.Product;

import lombok.Data;

@Data
public class OrdersReponseModel {

	private Long idOrder;
	
	private List<OrderInfoModel> orderInfoModels;
	
	private BigDecimal price;
	
	private String status;
	
	private boolean checkRate;
}
