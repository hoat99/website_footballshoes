package com.example.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.api.client.util.DateTime;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "payment_info")
public class PaymentInfo {

	@Id
	private Long idPaymentInfo;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@Column(name = "bankCode")
	private String bankCode;
	
	@Column(name = "cardType")
	private String cardType;
	
	@Column(name = "orderInfo")
	private String orderInfo;
	
	@Column(name = "payDate")
	private LocalDateTime payDate;
	
	@OneToOne(mappedBy = "paymentInfo")
	private Order order;
}
