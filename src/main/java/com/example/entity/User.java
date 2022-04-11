package com.example.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

	@Id	
	private String username;
	
	private String password;
	
	private String name;
	
	private String gender;
	
	private String phone;
	
	private String email;
	
	private String address;
	
	private String resetPasswordToken;
	
	@Column(name = "verification_code", length = 64)
	private String verificationCode;
	
	private Boolean enabled;
	
	@OneToMany(mappedBy = "user")
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "id_role_code")
	@ToString.Exclude
	private Role role;
	

	
	
}
