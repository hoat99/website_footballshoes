package com.example.service;

import java.util.List;

import com.example.dto.request.CartRequest;
import com.example.dto.request.UpdateCartRequest;
import com.example.entity.Cart;
import com.example.entity.Product;

public interface CartService {

	void createCart(CartRequest cartRequest);
	
	void updateCart(UpdateCartRequest updateCartRequest);
	
	void deleteCart(Long id);
	
	Cart getCartById(Long id);
//	void addProductToCart(CartRequest cartRequest, Long id ,String username);
	
	void addProductToCart(Long idProduct,String username);
	
	List<Cart> getAllCart(String username);
	
	Integer numberItem(String username);
}
