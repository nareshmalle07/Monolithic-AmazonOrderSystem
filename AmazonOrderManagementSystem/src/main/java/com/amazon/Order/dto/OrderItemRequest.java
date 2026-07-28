package com.amazon.Order.dto;

public class OrderItemRequest {

	private Long productId;
	
	private Long quantity;

	public Long getProductId() {
		return productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
}
