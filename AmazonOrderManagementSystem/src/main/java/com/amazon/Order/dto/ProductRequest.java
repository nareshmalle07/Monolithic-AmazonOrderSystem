package com.amazon.Order.dto;

import java.math.BigDecimal;

public class ProductRequest {

	private String name;
	private BigDecimal price;
	private Boolean active ;
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public Boolean getActive() {
		return active;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
}
