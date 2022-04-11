package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long>{
	Status findByDeliveryStatus(String deliveryStatus);
}
