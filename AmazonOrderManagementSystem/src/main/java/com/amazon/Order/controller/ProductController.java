package com.amazon.Order.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.Order.dto.ProductRequest;
import com.amazon.Order.dto.ProductResponse;
import com.amazon.Order.entity.Product;
import com.amazon.Order.repository.ProductRepository;
import com.amazon.Order.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@GetMapping
	public List<Product> getProduct()
	{
		return productService.getProduct();	
	}  
	
	@PostMapping
	public ProductResponse insertProduct(@RequestBody ProductRequest request) 
	{
		return productService.insertProduct(request);
	}
	
	@PostMapping("/{productId}")
	public Product findById(@PathVariable Long productId) 
	{
		return productService.findById(productId);
	}
	
	@GetMapping("/active")
	public List<Product> getActiveProducts()
	{
		return productService.getActiveProducts();
	}
	
	@PostMapping("/deactivate/{ProductID}")
	public String deactivateProduct(@PathVariable Long ProductID)
	{
		return productService.deactivateProduct(ProductID);
	}
}
