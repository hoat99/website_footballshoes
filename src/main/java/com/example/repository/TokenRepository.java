package com.example.repository;

import com.example.entity.FirebaseToken;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TokenRepository extends JpaRepository<FirebaseToken, String> {

}
