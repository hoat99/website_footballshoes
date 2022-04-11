package com.example.service;

import java.util.List;

import com.example.dto.request.OrderRequest;
import com.example.entity.Order;
import com.example.entity.OrderDetail;
import com.example.model.OrderDatatablesModel;
import com.example.model.OrderDetailDatatablesModel;
import com.example.model.OrdersReponseModel;


public interface OrderService {

	void createOrder(OrderRequest orderRequest,String username);
	
	List<Order> getOrderByUsername(String username);
	
	OrderDetailDatatablesModel getOrderDetailDatatablesModel();
	
    OrderDatatablesModel getOrderDatatablesModel();
	
	void changeStatusOrder(OrderRequest orderRequest);
	
	void deleteOrder(Long id);
	
	List<OrdersReponseModel> ordersReponseModels(String username);
}
