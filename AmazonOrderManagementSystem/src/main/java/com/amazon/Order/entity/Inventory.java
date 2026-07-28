package com.amazon.Order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "INVENTORY")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long productId;
	
	private long Available_Quantity;

	public Long getId() {
		return id;
	}

	public Long getProductId() {
		return productId;
	}

	public Long getAvailable_Quantity() {
		return Available_Quantity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProductId(Long productId) {
		productId = productId;
	}

	public void setAvailable_Quantity(Long l) {
		Available_Quantity = l;
	}

}
