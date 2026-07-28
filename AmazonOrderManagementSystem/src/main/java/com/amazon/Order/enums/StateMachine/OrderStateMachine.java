package com.amazon.Order.enums.StateMachine;

import org.springframework.stereotype.Component;

import com.amazon.Order.entity.Order;
import com.amazon.Order.enums.OrderStatus;

@Component
public class OrderStateMachine {

	public void transition(Order order,OrderStatus targetStatus) {
	
		OrderStatus currentStatus=order.getOrderStatus();
		validateTransaction(currentStatus,targetStatus);
		order.setOrderStatus(targetStatus);
	}

	private void validateTransaction(OrderStatus currentStatus, OrderStatus targetStatus) {
		switch(currentStatus) {
		case ORDER_PENDING:  if(targetStatus == OrderStatus.INVENTORY_RESERVED ||targetStatus == OrderStatus.PRODUCT_CANCELLED)
						{
							//Do Nothing
						}else {
							throw new RuntimeException("Invalid Transition");
						}
					break;
		case INVENTORY_RESERVED:  if(targetStatus == OrderStatus.PAYMENT_COMPLETED ||targetStatus == OrderStatus.PRODUCT_CANCELLED)
						{
							//Do Nothing
						}else {
							throw new RuntimeException("Invalid Transition");
						}
					break;
		case PAYMENT_COMPLETED:  if(targetStatus == OrderStatus.PRODUCT_SHIPPED ||targetStatus == OrderStatus.PRODUCT_CANCELLED)
						{
							//Do Nothing
						}else {
							throw new RuntimeException("Invalid Transition");
						}
					break;
	
		case PRODUCT_SHIPPED:  if(targetStatus == OrderStatus.PRODUCT_DELIEVERED ||targetStatus == OrderStatus.PRODUCT_CANCELLED)
					{
						//Do Nothing
					}else {
						throw new RuntimeException("Invalid Transition");
					}
				break;
	
		default :  throw new RuntimeException("Invalid Transition");
					
		}
	}
}
