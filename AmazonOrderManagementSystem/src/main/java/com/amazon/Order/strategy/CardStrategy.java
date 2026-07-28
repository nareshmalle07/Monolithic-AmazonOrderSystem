package com.amazon.Order.strategy;

import org.springframework.stereotype.Component;

import com.amazon.Order.dto.PaymentRequest;
import com.amazon.Order.dto.PaymentResponse;
import com.amazon.Order.enums.PaymentStatus;
import com.amazon.Order.enums.PaymentType;

@Component
public class CardStrategy implements PaymentStrategy {

	@Override
	public PaymentResponse processPayment(PaymentRequest request) {

		System.out.println("Card Payment is in proccess");
		
		PaymentResponse response = new PaymentResponse();
		response.setStatus("SUCCESS");
		
		System.out.println();
		System.out.println("Card Payment ------- DONE -------");
		return response;
	}

	@Override
	public PaymentType getPaymentType() {
		return PaymentType.CARD;
	}

}
