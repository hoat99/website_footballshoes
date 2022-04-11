package com.example.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "article_product")
public class ArticleProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idArticleProduct;
	
	@Column(name = "name_product")
	private String nameProduct;
	
	@Column(name = "content")
	private String content;
	
//	@OneToMany(mappedBy = "articleProduct", fetch = FetchType.LAZY)
//	private List<Product> products;
	
}
