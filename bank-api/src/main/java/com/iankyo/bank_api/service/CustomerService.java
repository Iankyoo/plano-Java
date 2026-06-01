package com.iankyo.bank_api.service;

import com.iankyo.bank_api.dto.CreateCustomerRequest;
import com.iankyo.bank_api.dto.CustomerResponse;
import com.iankyo.bank_api.entity.Customer;
import com.iankyo.bank_api.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<CustomerResponse> findAll(){
        return repository.findAll()
                .stream()
                .map(c -> new CustomerResponse(c.getId(), c.getName(), c.getEmail()))
                .collect(Collectors.toList());
    }

    public CustomerResponse findByID(Long id){
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return new CustomerResponse(customer.getId(),customer.getName(), customer.getEmail());
    }

    public CustomerResponse create(CreateCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        Customer saved = repository.save(customer);
        return new CustomerResponse(saved.getId(),saved.getName(), saved.getEmail());
    }

    public void delete(long id){
        repository.deleteById(id);
    }
}
