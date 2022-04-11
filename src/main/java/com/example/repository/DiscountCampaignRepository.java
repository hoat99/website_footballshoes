package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.DiscountCampaign;

@Repository
public interface DiscountCampaignRepository extends JpaRepository<DiscountCampaign, Long>{

}
