package com.example.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order1")
@Getter
@Setter
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrder1;
	
	@CreationTimestamp
	@Column(name = "create_at")
	private LocalDateTime createAt;
	
	@Column(name = "received_at")
	private LocalDateTime receivedAt;
	
	@Column(name = "price")
	private BigDecimal price;
	
	private String username;
	
	@Column(name = "full_name", length = 250)
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;
    
    @Column(name = "note")
    private String note;
	
	private String paymentMethod;
	
	@ManyToOne
	@JoinColumn(name = "id_status")
	private Status status;
	
	@OneToOne
	@JoinColumn(name = "id_payment_info")
	private PaymentInfo paymentInfo;
	
	@Column(name = "check_rate")
	private Boolean checkRate;
}
