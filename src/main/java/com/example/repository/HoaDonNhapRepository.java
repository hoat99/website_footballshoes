package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.HoaDonNhap;

@Repository
public interface HoaDonNhapRepository extends JpaRepository<HoaDonNhap, Long>{

}
