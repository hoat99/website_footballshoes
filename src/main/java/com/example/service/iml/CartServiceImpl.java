package com.example.service.iml;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.example.dto.request.CartRequest;
import com.example.dto.request.UpdateCartRequest;
import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.repository.CartRepository;
import com.example.repository.ProductRespository;
import com.example.service.CartService;
import com.google.api.client.http.HttpRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

	private final CartRepository cartRepository;

	private final ProductRespository productRespository;

	private final EntityManager entityManager;

	@Override
	public void createCart(CartRequest cartRequest) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCart(UpdateCartRequest updateCartRequest) {
		List<Long> idCart = updateCartRequest.getIdCart();
		List<Long> quantity = updateCartRequest.getQuantity();
//		int a = cartRequest.getIdCart().size();
//		System.out.println(cartRequest.getQuantity());
		for (int i = 0; i < idCart.size(); i++) {
			Cart cart = this.cartRepository.getById(idCart.get(i));
			cart.setQuantity(quantity.get(i));
			cartRepository.save(cart);
		}
	}

	@Override
	public List<Cart> getAllCart(String username) {
		return this.cartRepository.findByUsername(username);
	}

//	@Override
//	public void addProductToCart(CartRequest cartRequest, Long id, String username) {
//		Product product2 = this.entityManager.find(Product.class, id);
////		Optional<Cart> cartOpt = this.cartRepository.findByUsernameAndProduct(username,product2);
////		if (cartOpt.isPresent()) {
////			Cart cart2 = cartOpt.get();
////			cart2.setQuantity(cart2.getQuantity()+1);
////			this.cartRepository.save(cart2);
////		}
//		Cart cart = new Cart();
//		cart.setUsername(username);
//		cart.setQuantity((long) 1);
//		Optional<Product> prodOpt = this.productRespository.findById(id);
//		prodOpt.ifPresent(cart::setProduct);
//		this.cartRepository.save(cart);
//		
//	}

	@Override
	public void addProductToCart(Long idProduct, String username) {
		Product prodOpt = this.entityManager.find(Product.class, idProduct);
		Optional<Cart> cartOpt = this.cartRepository.findByUsernameAndProduct(username, prodOpt);
		if (cartOpt.isPresent()) {
			Cart cart2 = cartOpt.get();
			cart2.setQuantity(cart2.getQuantity() + 1);
			this.cartRepository.save(cart2);
		} else {
			Cart cart = new Cart();
			cart.setProduct(prodOpt);
			cart.setUsername(username);
			cart.setQuantity((long) 1);
			if(prodOpt.getIsDiscount()) {
				cart.setCost(prodOpt.getCostDiscount());
			}else {
				cart.setCost(prodOpt.getCost());
			}
			cartRepository.save(cart);
		}
	}

	@Override
	public void deleteCart(Long id) {
		this.cartRepository.deleteById(id);
	}

	@Override
	public Cart getCartById(Long id) {
		Cart cart = this.cartRepository.getById(id);
		return cart;
	}

	@Override
	public Integer numberItem(String username) {
		TypedQuery<Integer> query = this.entityManager
				.createQuery("select count(c.id) from Cart c where c.username like :username", Integer.class);
		query.setParameter("username", username);
		return query.getSingleResult();
	}

}
