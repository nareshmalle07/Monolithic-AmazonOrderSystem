package com.amazon.Order.dto;

import com.amazon.Order.enums.NotificationType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class NotificationRequest {

	private Long orderId;
	
	private String message;
	
	@Enumerated(EnumType.STRING)
	private NotificationType notificationType;

	public Long getOrderId() {
		return orderId;
	}

	public String getMessage() {
		return message;
	}

	public NotificationType getNotificationType() {
		return notificationType;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}
}
