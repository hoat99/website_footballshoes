package com.example.service.iml;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dto.request.ProductRatingRequest;
import com.example.entity.Cart;
import com.example.entity.Order;
import com.example.entity.OrderDetail;
import com.example.entity.Product;
import com.example.entity.ProductRating;
import com.example.model.ProductRatingModel;
import com.example.repository.OrderRepository;
import com.example.repository.OrderTestRepository;
import com.example.repository.ProductRatingRepository;
import com.example.repository.ProductRespository;
import com.example.service.ProductRatingService;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductRatingServiceImpl implements ProductRatingService{

	private final ProductRatingRepository productRatingRepository;
	
	private final OrderRepository orderRepository;
	
	private final ProductRespository productRespository;

	@Override
	public void doRating(ProductRatingRequest productRatingRequest, String username) {
		List<Long> idProduct = productRatingRequest.getIdProduct();
		List<Integer> rate = productRatingRequest.getRate();
		Long idOrder = productRatingRequest.getIdOrder();  
//		int a = cartRequest.getIdCart().size();
//		System.out.println(cartRequest.getQuantity());
		for (int i = 0; i < idProduct.size(); i++) {
//			Cart cart = this.cartRepository.getById(idCart.get(i));
//			cart.setQuantity(quantity.get(i));
//			cartRepository.save(cart);
			ProductRating productRating = new ProductRating();
			productRating.setIdProduct(idProduct.get(i));
			productRating.setRate(rate.get(i));
			productRating.setUsername(username);
			productRatingRepository.save(productRating);
			updateRateProduct(idProduct.get(i));
			Order order = this.orderRepository.getById(idOrder);
			order.setCheckRate(true);
			orderRepository.save(order);
		}
				
	}

	@Override
	public ProductRatingModel productRating(Long id) {
		ProductRatingModel productRatingModel = new ProductRatingModel();
		productRatingModel.setIdProduct(id);
		List<ProductRating> productRatings = this.productRatingRepository.findByIdProduct(id);
		float avgRate = 0;
		if (productRatings.size()>0) {
			for (ProductRating productRating : productRatings) {
				avgRate += productRating.getRate();
			}
			avgRate = avgRate/productRatings.size();
		}
		
		productRatingModel.setAvgRate(avgRate);
		productRatingModel.setNumberRating((long)productRatings.size());
		return productRatingModel;
	}

	@Override
	public void updateRateProduct(Long id) {
		Product product = this.productRespository.getById(id);
		List<ProductRating> productRatings = this.productRatingRepository.findByIdProduct(id);
		if (productRatings.size() > 0) {
			float rate = 0;
			for (ProductRating productRating : productRatings) {
				rate += productRating.getRate();
			}
			rate = rate/productRatings.size();
			product.setRate(Math.round(rate*2)/2.0);
			product.setNumberOfRating((long)productRatings.size());
			productRespository.save(product);
		}
		
	}
		
}
