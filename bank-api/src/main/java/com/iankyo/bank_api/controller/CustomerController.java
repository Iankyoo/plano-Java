package com.iankyo.bank_api.controller;

import com.iankyo.bank_api.dto.CreateCustomerRequest;
import com.iankyo.bank_api.dto.CustomerResponse;
import com.iankyo.bank_api.repository.CustomerRepository;
import com.iankyo.bank_api.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service = service;
    }
}
