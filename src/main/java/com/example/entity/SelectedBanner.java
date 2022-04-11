package com.example.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "selected_banner")
@Getter
@Setter
public class SelectedBanner {

	@Id
	private Long id;
	
	private String content;
	
	private String shortDescription;
	
	private String img;	
}
