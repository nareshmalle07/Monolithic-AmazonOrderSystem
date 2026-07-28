package com.amazon.Order.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.Order.dto.CreateOrderRquest;
import com.amazon.Order.dto.OrderResponse;
import com.amazon.Order.dto.ProductRequest;
import com.amazon.Order.dto.ProductResponse;
import com.amazon.Order.entity.Order;
import com.amazon.Order.service.OrderService;
import com.amazon.Order.service.ProductService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private final OrderService orderService;
	private final ProductService productService;

	public OrderController(OrderService orderService, ProductService productService) {
		this.orderService = orderService;
		this.productService = productService;
	}

	@PostMapping("/createOrder")
	public OrderResponse CreateOrder(@RequestBody CreateOrderRquest request) {

		System.out.println("Inside order Controller - createOrder");
		return orderService.createOrder(request);
	}

	@GetMapping("/get")
	public List<Order> GetOrder() {
		return orderService.getOrders();
	}

	@PostMapping("/insertProduct")
	public ProductResponse InsertProduct(@RequestBody ProductRequest request) {
		return productService.insertProduct(request);
	}
}
