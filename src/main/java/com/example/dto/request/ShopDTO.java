package com.example.dto.request;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShopDTO {

	private Long idProduct;
	
	private String name;
	
	private String img;
	
	private BigDecimal cost;
	
	private Double rate;
	
	private BigDecimal discount;
	
	private Boolean isDiscount;
//	private Long cost2 = cost.longValue();;
	
//	public Long setCost2(BigDecimal cost) {
//		cost2 = this.cost.longValue();
//		return cost2;
//	}
//	
}
