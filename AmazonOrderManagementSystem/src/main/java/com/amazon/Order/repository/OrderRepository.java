package com.amazon.Order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.Order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
