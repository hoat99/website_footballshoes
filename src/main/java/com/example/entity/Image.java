package com.example.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "image")
@Getter
@Setter
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImage;
	
	private String nameProduct;
	
	private String avatar;
	
	private String image1;
	
	private String image2;
	
	private String image3;
	
	private String image4;
	
	@OneToMany(mappedBy = "image", cascade = CascadeType.ALL)
	private Set<Product> product;
}
