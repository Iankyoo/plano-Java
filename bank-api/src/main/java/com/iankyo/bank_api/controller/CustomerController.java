package com.iankyo.bank_api.controller;

import com.iankyo.bank_api.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service = service;
    }

    @GetMapping("/customers/hello")
    public String hello(){
        return service.hello();
    }
}
