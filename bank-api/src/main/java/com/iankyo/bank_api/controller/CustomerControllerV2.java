package com.iankyo.bank_api.controller;

import com.iankyo.bank_api.dto.CustomerResponseV2;
import com.iankyo.bank_api.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/v2/customers")
public class CustomerControllerV2 {

    private final CustomerService service;

    public CustomerControllerV2(CustomerService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<CustomerResponseV2>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(service.findAllV2(pageable));
    }

}
