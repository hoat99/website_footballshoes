package com.example.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_info")
public class OrderInfo {

	@EmbeddedId
	private OrderInfoID id;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "price")
	private BigDecimal price;
	
}
