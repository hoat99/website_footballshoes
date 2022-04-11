package com.example.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.request.OrderRequest;
import com.example.entity.Order;
import com.example.entity.OrderDetail;
import com.example.model.OrdersReponseModel;
import com.example.repository.OrderTestRepository;
import com.example.service.CommonService;
import com.example.service.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	
	private final CommonService commonService;

	@GetMapping("/order")
	public String orderPage(Principal principal,Model model) {
		
		List<OrdersReponseModel> ordersReponseModels = this.orderService.ordersReponseModels(principal.getName());
		if(ordersReponseModels.isEmpty()) model.addAttribute("empty", "Không có đơn hàng nào");
		model.addAttribute("orders", ordersReponseModels);
		this.commonService.getCommonObj(model);
		
		return "user/order";
	}
	
	@PostMapping("/create-order")
	public String createOrder(@RequestBody OrderRequest orderRequest, Principal principal) {
		this.orderService.createOrder(orderRequest, principal.getName());
		
		System.out.println(orderRequest);
		return "redirect:/order";
	}
	
}
