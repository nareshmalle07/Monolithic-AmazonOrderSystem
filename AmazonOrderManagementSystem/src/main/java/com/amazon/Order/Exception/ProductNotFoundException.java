package com.amazon.Order.Exception;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String message) 
	{
		super(message);
	}
}
