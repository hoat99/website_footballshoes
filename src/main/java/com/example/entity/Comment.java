package com.example.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.cloud.firestore.annotation.ServerTimestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comment")
@Getter
@Setter
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComment;	
	
	@ServerTimestamp
	private LocalDateTime date;
	
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	
//	@ManyToOne
//	@JoinColumn(name = "id_product")
//	private Product product;
}
