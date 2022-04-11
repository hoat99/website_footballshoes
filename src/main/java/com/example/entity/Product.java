package com.example.entity;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduct;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cost")
	private BigDecimal cost;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "material")
	private String material;
	
	@Column(name = "representativePlayer")
	private String representativePlayer;
	
	@Column(name = "album")
	private String album;
	
	@Column(name = "yearOfProduction")
	private Long yearOfProduction;
	
	@Column(name = "technology")
	private String technology;
	
	@Column(name = "size")
	private Long size;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "rate")
	private Double rate;
	
	@Column(name = "number_of_rating")
	private Long numberOfRating;
	
	private BigDecimal costDiscount;
	
	private Boolean isDiscount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_strademark")
//	@ToStringExclude
//	@EqualsAndHashCode.Exclude
	private Strademark strademark;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_courtyard")
	private Courtyard courtyard;
//	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_image")
	private Image image;
//	
	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;
//	
	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cart> carts;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_article_product")
//	private ArticleProduct articleProduct;
	
//	@OneToMany(mappedBy = "product")
//	private List<Comment> comments;
	
	@Column(name = "name_removed_accent")
	private String nameRemovedAccent;
	

	
	@CreationTimestamp
	@Column(name = "create_at")
	private LocalDateTime createAt;

	@UpdateTimestamp
	@Column(name = "update_at")
	private LocalDateTime updateAt;

	@PrePersist
	private void prePersist() {
		this.setNameRemovedAccent(removeAccent(this.name));
	}
	
	@PreUpdate
	private void preUpdate() {
		this.setNameRemovedAccent(removeAccent(this.name));
	}


	private String removeAccent(String s) {
		s = s.toLowerCase();
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		temp = pattern.matcher(temp).replaceAll("");
		return temp.replaceAll("đ", "d");
	}
}
