package com.amazon.Order.dto;

import java.math.BigDecimal;

public class PriceCalculationResponse 
{

	private BigDecimal subTotal;
	
	private BigDecimal tax;
	
	private BigDecimal finalAmount;

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public BigDecimal getFinalAmount() {
		return finalAmount;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public void setFinalAmount(BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
	}
	
	
}
