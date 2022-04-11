package com.example.service;

import com.example.dto.request.DiscountCampaignRequest;
import com.example.model.DiscountCampaignModel;

public interface DiscountCampaignService {

	DiscountCampaignModel getAllDiscountCampaignModel();
	
	void createCampaign(DiscountCampaignRequest discountCampaignRequest);
	
	void updateCampaign(DiscountCampaignRequest discountCampaignRequest);
	
	void deleteCampaign(Long id);
	
}
