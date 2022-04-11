package com.example.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "strademark")
@Getter
@Setter
public class Strademark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStrademark;
	
	private String name;
	
	private String img;
	
	@OneToMany(mappedBy = "strademark", cascade = CascadeType.ALL)
	@JsonIgnore
//	@ToStringExclude
	private Set<Product> products;

	public Long getIdStrademark() {
		return idStrademark;
	}

	public void setIdStrademark(Long idStrademark) {
		this.idStrademark = idStrademark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	
}
