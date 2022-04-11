package com.example.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.OrderRequest;
import com.example.model.OrderDatatablesModel;
import com.example.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/order")
@RequiredArgsConstructor
public class OrderApi {

	private final OrderService orderService;
	
	
	@GetMapping("/get-all")
	public OrderDatatablesModel getOrderDatatablesModel() {
		return this.orderService.getOrderDatatablesModel();
	}
	
	@PutMapping("/update")
	public void updateOrder(@RequestBody OrderRequest orderRequest) {
		this.orderService.changeStatusOrder(orderRequest);
	}
	
	
}
