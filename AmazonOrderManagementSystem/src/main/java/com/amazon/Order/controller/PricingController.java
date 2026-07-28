package com.amazon.Order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pricing")
public class PricingController {

	@GetMapping("/")
    public String priceDisplay(){
        return "inside the pricing controller";
    }
}
