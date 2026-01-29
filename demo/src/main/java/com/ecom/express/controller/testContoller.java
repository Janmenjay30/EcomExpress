package com.ecom.express.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testContoller {
    @GetMapping("/test")
    public String testEndpoint() {
        return "Test endpoint is working!";
    }
}
