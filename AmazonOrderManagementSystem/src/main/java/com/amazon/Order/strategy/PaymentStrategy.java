package com.amazon.Order.strategy;

import com.amazon.Order.dto.PaymentRequest;
import com.amazon.Order.dto.PaymentResponse;
import com.amazon.Order.enums.PaymentType;

public interface PaymentStrategy {
	
	PaymentResponse processPayment(PaymentRequest request);
	PaymentType getPaymentType();
}
