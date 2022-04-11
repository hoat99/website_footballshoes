package com.example.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "courtyard")
@Getter
@Setter
public class Courtyard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCourtyard;
	
	private String type;
	
	@OneToMany(mappedBy = "courtyard", cascade = CascadeType.ALL)
	private Set<Product> products;		
	
}
