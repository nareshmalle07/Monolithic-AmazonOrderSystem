package com.amazon.Order.Exception;

public class InsufficientInventoryException extends RuntimeException{

	public InsufficientInventoryException(String message) 
	{
		super(message);
	}
}