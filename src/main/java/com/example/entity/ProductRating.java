package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Entity
@Getter
@Setter
@Table(name = "product_rating")
public class ProductRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProductRating;
	
	private Long idProduct;
	
	private Integer rate;
	
	private String username;
	
	private Long idOrder;
	
}
