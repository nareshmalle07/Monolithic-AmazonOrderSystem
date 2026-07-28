package com.amazon.Order.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.amazon.Order.dto.ShipmentRequest;
import com.amazon.Order.dto.ShipmentResponse;
import com.amazon.Order.entity.Shipment;
import com.amazon.Order.repository.ShipmentRepository;

@Service
public class ShipmentService {

	private final ShipmentRepository shipmentRepository;
	
	public ShipmentService(ShipmentRepository shipmentRepository) 
	{
		this.shipmentRepository=shipmentRepository;
	}
	
	public ShipmentResponse createShipment(ShipmentRequest request) 
	{
		Shipment shipment=new Shipment();
		shipment.setOrderId(request.getOrderId());
		shipment.setCourierPartner("Blue Dart");
		shipment.setShipmentDate(LocalDateTime.now());
		shipment.setTrackingNumber(getTrackingNumber());
		
		Shipment savedShipment= shipmentRepository.save(shipment);
		ShipmentResponse response= new ShipmentResponse();
		response.setCourierPartner(savedShipment.getCourierPartner());
		response.setShipmentId(savedShipment.getId());
		response.setTrackingNumber(savedShipment.getTrackingNumber());
		
		return response;
	}

	private String getTrackingNumber() {
		return "ATN-"+UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}
	
}
