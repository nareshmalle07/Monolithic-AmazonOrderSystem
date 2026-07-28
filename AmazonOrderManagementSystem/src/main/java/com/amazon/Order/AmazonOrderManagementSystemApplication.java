package com.amazon.Order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmazonOrderManagementSystemApplication {

	public static void main(String[] args) {

		 System.out.println("Step 1");

		    SpringApplication.run(
		            AmazonOrderManagementSystemApplication.class,
		            args
		    );

		    System.out.println("Step 2");	
	}
}
