package com.amazon.Order.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SHIPMENT")
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ORDER_ID",nullable = false)
	private Long orderId;
	
	@Column(name="TRACKING_NUMBER",nullable = false)
	private String trackingNumber;
	
	@Column(name="COURIER_PARTNER",nullable = false)
	private String courierPartner;
	
	@Column(name="SHIPMENT_DATE")
	private LocalDateTime shipmentDate;
	
	public Long getId() {
		return id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public String getCourierPartner() {
		return courierPartner;
	}

	public LocalDateTime getShipmentDate() {
		return shipmentDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public void setCourierPartner(String courierPartner) {
		this.courierPartner = courierPartner;
	}

	public void setShipmentDate(LocalDateTime shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	
}
