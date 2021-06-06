package com.kmh.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmh.spring.entity.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {

}
