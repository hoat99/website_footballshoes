package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.entity.ArticleProduct;
import com.example.entity.OrderDetail;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetailDatatablesModel {
	
	private List<List<String>> data;

	
	public static OrderDetailDatatablesModel converter(List<OrderDetail> orderDetails) {
		List<List<String>> datas = new ArrayList<>();
		orderDetails.forEach(order -> datas.add(Arrays.asList(order.getIdOrderDetail().toString()
				,order.getFullname()
				,order.getUsername()
				,order.getPhone()
				,order.getEmail()
				,order.getAddress()								
				,order.getProduct().getName()
				,order.getQuantity().toString()
				,order.getCost().toString()
				,order.getStatus().getDeliveryStatus()
				,order.getNote())));
		return OrderDetailDatatablesModel.builder().data(datas).build();
	}
	
}
