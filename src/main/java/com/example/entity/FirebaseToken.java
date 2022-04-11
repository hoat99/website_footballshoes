package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "firebase_token")
public class FirebaseToken {

    @Id
    private String token;

    private String deviceInfo;

}
