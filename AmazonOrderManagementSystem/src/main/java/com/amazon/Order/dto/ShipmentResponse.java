package com.amazon.Order.dto;

public class ShipmentResponse {

	private Long shipmentId;
	
	private String trackingNumber;
	
	private String courierPartner;

	public Long getShipmentId() {
		return shipmentId;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public String getCourierPartner() {
		return courierPartner;
	}

	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public void setCourierPartner(String courierPartner) {
		this.courierPartner = courierPartner;
	}
	
}
