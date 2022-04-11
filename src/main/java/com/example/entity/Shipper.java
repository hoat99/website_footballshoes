package com.example.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shipper")
@Getter
@Setter
public class Shipper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idShipper;
	
	private String name;
	
	private String phone;
	
//	@OneToMany(mappedBy = "shipper")
//	private List<Order> orders;
	
}
