package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.request.StrademarkDTO;
import com.example.entity.Strademark;

public interface StrademarkRepository extends JpaRepository<Strademark, Long>{
	
	@Query("SELECT s.idStrademark, s.name, s.img FROM Strademark s WHERE s.idStrademark = :idStrademark")
	Optional<StrademarkDTO> findOneStrademark(@RequestParam(name = "idStrademark") Long idStrademark);
}
