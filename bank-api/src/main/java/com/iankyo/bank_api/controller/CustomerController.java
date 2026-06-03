package com.iankyo.bank_api.controller;

import com.iankyo.bank_api.dto.CreateCustomerRequest;
import com.iankyo.bank_api.dto.CustomerResponse;
import com.iankyo.bank_api.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<CustomerResponse>> findAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "name") String sort){

        Pageable pageable = PageRequest.of(page,size, Sort.by(sort));
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<CustomerResponse>> findByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(service.findByName(name, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable long id){
        return ResponseEntity.ok(service.findByID(id));
    }

    @PostMapping()
    public ResponseEntity<CustomerResponse> createAccount(@Valid @RequestBody CreateCustomerRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
