package com.example.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.entity.Product;
import com.example.entity.Status;
import com.example.entity.User;
import com.google.cloud.firestore.annotation.ServerTimestamp;

import lombok.Data;

@Data
public class OrderRequest {

	private Long idOrder;
		
	private BigDecimal cost;
	
	private String address;
	private String fullname;
	private String phone;
	private String email;
	
	private String note;
	
	private String username;

	private Long idStatus;
	
	private Long idProduct;
	
	private Long quantity;

//	@ServerTimestamp
//	private LocalDateTime date;
}
