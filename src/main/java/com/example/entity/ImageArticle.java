package com.example.entity;

import javax.persistence.Column;
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
@Table(name = "image_article")
public class ImageArticle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImageArticle;
	
	@Column(name = "name_product")
	private String nameProduct;
	
	@Column(name = "img1")
	private String img1;
	
	@Column(name = "img2")
	private String img2;
	
	@Column(name = "img3")
	private String img3;
	
	@Column(name = "img4")
	private String img4;
	
	@Column(name = "img5")
	private String img5;
	
	@Column(name = "img6")
	private String img6;
	
}
