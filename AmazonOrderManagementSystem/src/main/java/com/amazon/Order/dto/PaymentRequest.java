package com.amazon.Order.dto;

import java.math.BigDecimal;

import com.amazon.Order.enums.PaymentType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class PaymentRequest {
	
	private Long orderId;
	
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;

	public Long getOrderId() {
		return orderId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
	
}
