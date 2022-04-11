package com.example.service;

import java.util.List;

import com.example.dto.request.ProductRatingRequest;
import com.example.entity.ProductRating;
import com.example.model.ProductRatingModel;

public interface ProductRatingService {

	void doRating(ProductRatingRequest productRatingRequest, String username);
	
	ProductRatingModel productRating(Long id);
	
	void updateRateProduct(Long id);
}
