package com.amazon.Order.client;

import com.amazon.Order.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8085")
public interface ProductFeignClient {

    @GetMapping("/product/active")
    List<ProductResponse> getActiveProducts();

    @PostMapping ("/product/{productId}")
    ProductResponse findById(@PathVariable("productId") Long productId);
}
