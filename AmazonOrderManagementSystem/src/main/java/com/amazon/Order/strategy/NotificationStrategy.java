package com.amazon.Order.strategy;

import com.amazon.Order.dto.NotificationRequest;
import com.amazon.Order.dto.NotificationResponse;
import com.amazon.Order.enums.NotificationType;

public interface NotificationStrategy {
	
	public NotificationType getNotificationType();
	
	public NotificationResponse sendNotification(NotificationRequest request);

}
