package com.amazon.Order.dto;

import java.util.List;
import com.amazon.Order.enums.PaymentType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


public class CreateOrderRquest {
	private Long customerId;
	
	private List<OrderItemRequest> items;

	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;

	public List<OrderItemRequest> getItems() {
		return items;
	}

	public void setItems(List<OrderItemRequest> items) {
		this.items = items;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
}
