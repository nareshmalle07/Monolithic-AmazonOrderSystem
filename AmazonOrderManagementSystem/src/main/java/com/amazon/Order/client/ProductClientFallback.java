package com.amazon.Order.client;

import com.amazon.Order.Exception.ProductServiceUnavailableException;
import com.amazon.Order.dto.ProductResponse;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductClientFallback implements ProductFeignClient{

//    public ResponseEntity<Map<String,String>> productFallback() {
//        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
//                .body(Map.of( "message", "Order Service is temporarily unavailable",
//                        "status", "SERVICE_UNAVAILABLE"));
//    }

    @Override
    public List<ProductResponse> getActiveProducts()
    {
       throw new ProductServiceUnavailableException("Product Service is currently not available");
    }

   @Override
     public ProductResponse findById(Long productId)
    {
        System.out.println("========== PRODUCT FALLBACK CALLED ==========");
        throw new ProductServiceUnavailableException("Hey Bakka dana , Product Service is currently not available");
    }

}
