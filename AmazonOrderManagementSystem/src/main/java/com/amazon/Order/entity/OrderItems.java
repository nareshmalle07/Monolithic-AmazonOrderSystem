package com.amazon.Order.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ORDER_ITEMS")
public class OrderItems {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="CUSTOMERID")
	private Long customerId;
	
//	@Column(name="ORDER_ID")
//	private Long orderId;
	
	
	@Column(name="PRODUCT_ID")
	private Long productId;
	
	private Long quantity;
	
	private BigDecimal price;

	private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public Long getCustomerId() {
		return customerId;
	}

//	public Long getOrderId() {
//		return orderId;
//	}

	public Long getProductId() {
		return productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

//	public void setOrderId(Long orderId) {
//		this.orderId = orderId;
//	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public void setPrice(BigDecimal totalAmount) {
		this.price = totalAmount;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
