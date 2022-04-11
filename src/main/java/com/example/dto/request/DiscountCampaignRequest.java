package com.example.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DiscountCampaignRequest {

	private Long idDiscountCampaign;
	
	private String startAt;
	
	private String endAt;
	
	private BigDecimal originalCost;
	
	private BigDecimal discount;
	
	
	private String name;
	
	private String nameProduct;
	
}
