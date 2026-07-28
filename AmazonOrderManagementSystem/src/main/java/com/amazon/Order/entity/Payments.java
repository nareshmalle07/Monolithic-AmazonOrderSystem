package com.amazon.Order.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.amazon.Order.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PAYMENTS")
public class Payments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private Long order_id;
	
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	private LocalDateTime payment_time;

	public long getId() {
		return id;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public LocalDateTime getPayment_time() {
		return payment_time;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public void setAmount(BigDecimal bigDecimal) {
		this.amount = bigDecimal;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public void setPayment_time(LocalDateTime payment_time) {
		this.payment_time = payment_time;
	}
	
	
}
