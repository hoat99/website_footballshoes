package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter

public class OrderInfoID  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_order")
	private Long idOrder;
	
	@Column(name = "id_product")
	private Long idProduct;
}
