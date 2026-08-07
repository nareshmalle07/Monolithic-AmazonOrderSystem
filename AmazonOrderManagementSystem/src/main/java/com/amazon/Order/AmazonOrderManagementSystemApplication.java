package com.amazon.Order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AmazonOrderManagementSystemApplication {

	public static void main(String[] args) {
		 System.out.println("AmazonOrderManagementSystemApplication started");
		 SpringApplication.run(AmazonOrderManagementSystemApplication.class, args);
		 System.out.println("AmazonOrderManagementSystemApplication ended");
	}
}
