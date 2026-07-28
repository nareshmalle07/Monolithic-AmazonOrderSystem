package com.amazon.Order.dto;

public class PaymentResponse {

	private Long Order_id;
	
	private String status;

	public Long getOrder_id() {
		return Order_id;
	}

	public String getStatus() {
		return status;
	}

	public void setOrder_id(Long order_id) {
		Order_id = order_id;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
