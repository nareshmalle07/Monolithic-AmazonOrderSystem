package com.amazon.Order.strategy;

import org.springframework.stereotype.Component;

import com.amazon.Order.dto.PaymentRequest;
import com.amazon.Order.dto.PaymentResponse;
import com.amazon.Order.enums.PaymentStatus;
import com.amazon.Order.enums.PaymentType;

@Component
public class UpiStrategy implements PaymentStrategy {

	@Override
	public PaymentResponse processPayment(PaymentRequest request) {

		System.out.println("Upi Payment is in proccess");
		
		PaymentResponse response = new PaymentResponse();
		response.setStatus("SUCCESS");
		
		System.out.println();
		System.out.println("Upi Payment ------- DONE -------");
		return response;
	}

	@Override
	public PaymentType getPaymentType() {
		
		return PaymentType.UPI;
	}

}
