package com.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{
	@GetMapping("/customerServiceFallback")
    public String customerServiceFallback() {
        return "Customer service is down at this time !!";
    }
	
	@GetMapping("/orderServiceFallback")
    public String orderServiceFallback() {
        return "order service is down at this time !!";
    }
	
	@GetMapping("/paymentServiceFallback")
    public String paymentServiceFallback() {
        return "payment service is down at this time !!";
    }
}
