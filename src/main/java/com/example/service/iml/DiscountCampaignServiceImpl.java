package com.example.service.iml;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.request.DiscountCampaignRequest;
import com.example.entity.DiscountCampaign;
import com.example.entity.Product;
import com.example.model.DiscountCampaignModel;
import com.example.repository.DiscountCampaignRepository;
import com.example.repository.ProductRespository;
import com.example.service.DiscountCampaignService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiscountCampaignServiceImpl implements DiscountCampaignService {

	private final DiscountCampaignRepository discountCampaignRepository;

	private final ProductRespository productRespository;

	@Override
	public void createCampaign(DiscountCampaignRequest discountCampaignRequest) {

		DiscountCampaign discountCampaign = new DiscountCampaign();
		discountCampaign.setName(discountCampaignRequest.getName());
		discountCampaign.setStartAt(LocalDateTime.parse(discountCampaignRequest.getStartAt()));
		discountCampaign.setEndAt(LocalDateTime.parse(discountCampaignRequest.getEndAt()));
		discountCampaign.setDiscount(discountCampaignRequest.getDiscount());
		discountCampaign.setNameProduct(discountCampaignRequest.getNameProduct());
		List<Product> products = this.productRespository.getGroupProduct(discountCampaignRequest.getNameProduct());
		for (Product product : products) {
			product.setCostDiscount(discountCampaignRequest.getDiscount());
			productRespository.save(product);
			discountCampaign.setOriginalCost(product.getCost());
		}
		discountCampaignRepository.save(discountCampaign);
	}

	@Override
	public DiscountCampaignModel getAllDiscountCampaignModel() {
		// TODO Auto-generated method stub
		return DiscountCampaignModel.converter(this.discountCampaignRepository.findAll());
	}

	@Override
	public void updateCampaign(DiscountCampaignRequest discountCampaignRequest) {
		DiscountCampaign discountCampaign = this.discountCampaignRepository
				.getById(discountCampaignRequest.getIdDiscountCampaign());
		discountCampaign.setName(discountCampaignRequest.getName());
		discountCampaign.setStartAt(LocalDateTime.parse(discountCampaignRequest.getStartAt()));
		discountCampaign.setEndAt(LocalDateTime.parse(discountCampaignRequest.getEndAt()));
		discountCampaign.setDiscount(discountCampaignRequest.getDiscount());
		discountCampaign.setNameProduct(discountCampaignRequest.getNameProduct());
		List<Product> products = this.productRespository.getGroupProduct(discountCampaignRequest.getNameProduct());
		for (Product product : products) {
			product.setCostDiscount(discountCampaignRequest.getDiscount());
			productRespository.save(product);
			discountCampaign.setOriginalCost(product.getCost());
		}
		discountCampaignRepository.save(discountCampaign);
	}

	@Override
	public void deleteCampaign(Long id) {
		DiscountCampaign discountCampaign = this.discountCampaignRepository.getById(id);
		List<Product> products = this.productRespository.getGroupProduct(discountCampaign.getNameProduct());
		for (Product product : products) {
			product.setIsDiscount(false);
			productRespository.save(product);
		}	
		discountCampaignRepository.delete(discountCampaign);
	}

}
