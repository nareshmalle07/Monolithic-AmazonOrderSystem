package com.amazon.Order.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.amazon.Order.dto.NotificationRequest;
import com.amazon.Order.dto.NotificationResponse;
import com.amazon.Order.enums.NotificationType;
import com.amazon.Order.strategy.NotificationStrategy;

@Service
public class NotificationService {

	private final Map< NotificationType,NotificationStrategy> strategyMap;
	
	public NotificationService(List<NotificationStrategy> strategyMap) 
	{
		this.strategyMap=strategyMap.stream().collect(Collectors.toMap(NotificationStrategy::getNotificationType,strategy-> strategy));
	}
	
	public NotificationResponse sendNotification(NotificationRequest request) 
	{
		
		NotificationStrategy strategy=strategyMap.get(request.getNotificationType());
		System.out.println("the Notification Strategy is "+strategy.getNotificationType());
		if(strategy ==null)
			throw new RuntimeException("hey naresh ,----Un-Supported Notification Type ");
		
		return strategy.sendNotification(request);
	}
}
