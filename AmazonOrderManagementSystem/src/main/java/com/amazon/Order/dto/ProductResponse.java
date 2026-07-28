package com.amazon.Order.dto;

import java.math.BigDecimal;

public class ProductResponse {

	private Long id;
	
	private String name;
	
	private BigDecimal price;
	
	private Boolean active;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Boolean getActive() {
		return active;
	}

	public void setId(Long id) {
		this.id = id;
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
