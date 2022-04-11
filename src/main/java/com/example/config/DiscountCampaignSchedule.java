package com.example.config;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.entity.DiscountCampaign;
import com.example.entity.Product;
import com.example.repository.DiscountCampaignRepository;
import com.example.repository.ProductRespository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class DiscountCampaignSchedule {

	private final ProductRespository productRespository;
	
	private final DiscountCampaignRepository discountCampaignRepository;
	
	@Scheduled(cron = "0 0 */3 ? * *")
	public void discountCampaignSchedule() {
		LocalDateTime now  = LocalDateTime.now();
		List<DiscountCampaign> discountCampaigns = this.discountCampaignRepository.findAll();
		for (DiscountCampaign discountCampaign : discountCampaigns) {
			if (now.compareTo(discountCampaign.getStartAt()) >= 0 && now.compareTo(discountCampaign.getEndAt())<=0) {
				List<Product> products = this.productRespository.getGroupProduct(discountCampaign.getNameProduct());
				for (Product product : products) {
					product.setCostDiscount(discountCampaign.getDiscount());
					product.setIsDiscount(true);
					productRespository.save(product);
				}
				System.out.println(now.isAfter(discountCampaign.getStartAt()) || now.isEqual(discountCampaign.getStartAt())
						&& now.isBefore(discountCampaign.getEndAt()) || now.isEqual(discountCampaign.getEndAt()));
			}
			else {
				List<Product> products = this.productRespository.getGroupProduct(discountCampaign.getNameProduct());
				for (Product product : products) {
					product.setIsDiscount(false);
					productRespository.save(product);
				}
				}
		}
			
	}
	
	
}
