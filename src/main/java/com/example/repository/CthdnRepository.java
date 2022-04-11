package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Cthdn;
import com.example.entity.CthdnId;
import com.example.entity.OrderInfo;

@Repository
public interface CthdnRepository extends JpaRepository<Cthdn, CthdnId>{
	
	@Query(value = "SELECT * FROM cthdn c WHERE c.hoa_don_nhap_id = :hoa_don_nhap_id", nativeQuery = true)
	List<Cthdn> findByHoaDonNhapId(@Param("hoa_don_nhap_id") Long hoa_don_nhap_id);
	
	@Modifying
	@Query(value = "Delete FROM cthdn c WHERE c.hoa_don_nhap_id = :hoa_don_nhap_id", nativeQuery = true)
	void deleteByHoaDonNhapId(@Param("hoa_don_nhap_id") Long hoa_don_nhap_id);
}
