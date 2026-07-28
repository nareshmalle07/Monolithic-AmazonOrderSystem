package com.amazon.Order.strategy;

import org.springframework.stereotype.Component;

import com.amazon.Order.dto.NotificationRequest;
import com.amazon.Order.dto.NotificationResponse;
import com.amazon.Order.enums.NotificationType;

@Component
public class SmsNotificationStrategy implements NotificationStrategy {

	@Override
	public NotificationType getNotificationType() {
		
		return NotificationType.SMS;
	}

	@Override
	public NotificationResponse sendNotification(NotificationRequest request) {
		
		System.out.println("SMS Notification Sent : "+request.getMessage());
		 NotificationResponse response=new NotificationResponse();
		 response.setNotificationStatus("SUCCESS");
		
		 return response;
	}

}
