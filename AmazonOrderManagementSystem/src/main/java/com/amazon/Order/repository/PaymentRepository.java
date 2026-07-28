package com.amazon.Order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.Order.entity.Payments;

public interface PaymentRepository extends JpaRepository<Payments, Long> {

}
