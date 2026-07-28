package com.amazon.Order.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.amazon.Order.dto.PriceCalculationResponse;

@Service
public class PricingService {
	
	private static final BigDecimal GST =new BigDecimal("0.18");
	
	public PriceCalculationResponse calculatePrice(BigDecimal subTotal)
	{
		BigDecimal tax= subTotal.multiply(GST).setScale(2,RoundingMode.HALF_UP);
		BigDecimal finalAmount = subTotal.add(tax); 
		
		PriceCalculationResponse response =new PriceCalculationResponse();
		
		response.setSubTotal(subTotal);
		response.setTax(tax);
		response.setFinalAmount(finalAmount);
		
		return response;
	}

} 

