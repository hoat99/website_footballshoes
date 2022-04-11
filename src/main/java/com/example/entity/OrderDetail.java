package com.example.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrderDetail;
	
//	@CreationTimestamp
//	@Column(name = "date")
//	private LocalDateTime date;
	@Column(name = "cost")
	private BigDecimal cost;	
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "fullname")
	private String fullname;
	
	private Long quantity;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "username")
	private String username;
	
	private Boolean checkRate;
	
	@CreationTimestamp
	@Column(name = "create_at")
	private LocalDateTime createAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_status")
	private Status status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product")
	private Product product;
	
}
