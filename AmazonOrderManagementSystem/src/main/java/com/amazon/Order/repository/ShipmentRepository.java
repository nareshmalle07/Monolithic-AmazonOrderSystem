package com.amazon.Order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.Order.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

}
