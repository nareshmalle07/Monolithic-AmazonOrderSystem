package com.amazon.Order.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.Order.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByName (String name);
	
	List<Product> findByActiveTrue();
	
	Boolean existsByName(String name);
	
}
