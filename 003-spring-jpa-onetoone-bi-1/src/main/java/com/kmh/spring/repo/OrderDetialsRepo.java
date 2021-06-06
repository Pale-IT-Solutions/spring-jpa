package com.kmh.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmh.spring.entity.OrderDetails;

@Repository
public interface OrderDetialsRepo extends JpaRepository<OrderDetails, Integer> {

	OrderDetails findAllById(int i);

}
