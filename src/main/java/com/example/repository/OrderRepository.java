package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Order;
import com.example.entity.OrderDetail;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findByUsername(Sort by, String username);

	@Query(value= "Select * from abc.order1 o where o.create_at >= (select LAST_DAY(curdate() - interval 1 month) + interval 1 day) and o.create_at <= (select last_day(curdate()))", nativeQuery = true)
	List<Order> findByMonth();

	@Query(value= "Select * from abc.order1 o where o.create_at >= (select last_day(curdate() - interval 2 month) + interval 1 day) and o.create_at <= (select last_day(curdate() - interval 1 month))", nativeQuery = true)
	List<Order> findByMonthBefore();
}
