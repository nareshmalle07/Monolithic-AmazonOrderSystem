package com.amazon.Order.strategy;

import org.springframework.stereotype.Component;

import com.amazon.Order.dto.NotificationRequest;
import com.amazon.Order.dto.NotificationResponse;
import com.amazon.Order.enums.NotificationType;

@Component
public class EmailNotificationStrategy implements NotificationStrategy {

	@Override
	public NotificationType getNotificationType() {
		
		return NotificationType.EMAIL;
	}

	@Override
	public NotificationResponse sendNotification(NotificationRequest request) {
		
		NotificationResponse response=new NotificationResponse();
		System.out.println("Email Notification Sent : "+request.getMessage());
		response.setNotificationStatus("SUCCESS");
		
		 return response;
	}

}
