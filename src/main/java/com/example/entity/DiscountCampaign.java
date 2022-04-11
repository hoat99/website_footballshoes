package com.example.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "discount_campaign")
public class DiscountCampaign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDiscountCampaign;
	
	private LocalDateTime startAt;
	
	private LocalDateTime endAt;
	
	private BigDecimal originalCost;
	
	private BigDecimal discount;
	
	private String name;
	
	private String nameProduct;
	
}
