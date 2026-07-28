package com.amazon.Order.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amazon.Order.dto.PaymentRequest;
import com.amazon.Order.dto.PaymentResponse;
import com.amazon.Order.entity.Payments;
import com.amazon.Order.enums.PaymentStatus;
import com.amazon.Order.enums.PaymentType;
import com.amazon.Order.repository.PaymentRepository;
import com.amazon.Order.strategy.PaymentStrategy;
import java.util.stream.Collectors;

@Service
public class PaymentService {

	private final Map<PaymentType,PaymentStrategy> strategyMap;
	
	public PaymentService(PaymentRepository paymentRepository, 
			List<PaymentStrategy> strategyMap) 
	{
		this.strategyMap= strategyMap.stream()
							.collect(Collectors.
									toMap(PaymentStrategy::getPaymentType,
												strategy -> strategy));
	}
	
	public PaymentResponse processPayment(PaymentRequest request) 
	{
//		Payments payment = new Payments();
//		
//		payment.setOrder_id(request.getOrderId());
//		payment.setAmount(request.getAmount());
//		payment.setStatus(PaymentStatus.SUCCESS);
//		payment.setPayment_time(LocalDateTime.now());
//		
//		Payments savedPayment= paymentRepository.save(payment);
//		
//		PaymentResponse response =new PaymentResponse();
//		response.setOrder_id(savedPayment.getOrder_id());
//		response.setStatus(savedPayment.getStatus().name());
		
		PaymentStrategy strategy=strategyMap.get(request.getPaymentType());
		
		System.out.println("the StrategyMap is  "+strategyMap);
		System.out.println("the StrategyMap payment type is  "+request.getPaymentType());
		System.out.println("the Strategy is "+strategy);
		if(strategy ==null) 
		{
			throw new RuntimeException("Un-Expected payment type");
		}
		
		return strategy.processPayment(request);
	}
}
