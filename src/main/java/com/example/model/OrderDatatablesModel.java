package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.entity.Order;
import com.example.entity.OrderDetail;
import com.example.entity.OrderInfoID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDatatablesModel {

private List<List<String>> data;

	
	public static OrderDatatablesModel converter(List<Order> orders) {
		List<List<String>> datas = new ArrayList<>();
		orders.forEach(order -> datas.add(Arrays.asList(order.getIdOrder1().toString()
				,order.getUsername()
				,order.getCreateAt().toString()
				,order.getReceivedAt() != null ? order.getReceivedAt().toString():""
				,order.getPrice().toString()
				,order.getStatus().getDeliveryStatus()
				,order.getPaymentInfo() != null ? order.getPaymentInfo().getBankCode():""
				,order.getPaymentMethod()
				)));
		return OrderDatatablesModel.builder().data(datas).build();
	}
	
}
