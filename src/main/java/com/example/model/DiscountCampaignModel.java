package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.entity.DiscountCampaign;
import com.example.entity.Strademark;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiscountCampaignModel {

	private List<List<String>> data;
	
	public static DiscountCampaignModel converter(List<DiscountCampaign> discountCampaigns) {
		List<List<String>> datas = new ArrayList<>();
		discountCampaigns.forEach(discountCampaign -> datas.add(Arrays.asList(discountCampaign.getIdDiscountCampaign().toString()
				,discountCampaign.getName() != null ? discountCampaign.getName() : " "
				,discountCampaign.getStartAt() != null ? discountCampaign.getStartAt().toString() : " "
				,discountCampaign.getEndAt() != null ? discountCampaign.getEndAt().toString() : " "
				,discountCampaign.getNameProduct()
				,discountCampaign.getOriginalCost().toString()
				,discountCampaign.getDiscount()	.toString())));
		return DiscountCampaignModel.builder().data(datas).build();
	}
	
}
