package com.iankyo.bank_api.service;

import com.iankyo.bank_api.dto.CreateCustomerRequest;
import com.iankyo.bank_api.dto.CustomerResponse;
import com.iankyo.bank_api.dto.CustomerResponseV2;
import com.iankyo.bank_api.entity.Customer;
import com.iankyo.bank_api.exception.CustomerNotFoundException;
import com.iankyo.bank_api.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Page<CustomerResponse> findAll(Pageable pageable){
        return repository.findAll(pageable)
                .map(c -> new CustomerResponse(c.getId(), c.getName(), c.getEmail()));
    }

    public Page<CustomerResponse> findByName(String name, Pageable pageable){
        log.info("Searching customer with name: {}",name );
        return repository.findByNameContainingIgnoreCase(name, pageable)
                .map(c -> new CustomerResponse(c.getId(),c.getName(),c.getEmail()));
    }

    public CustomerResponse findByID(Long id){
        log.info("Searching customer with id: {}", id);
        Customer customer = repository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Customer not found with id: {}", id);
                    return new CustomerNotFoundException(id);
                });
        log.info("Customer found: {}", customer.getName());
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

    public Page<CustomerResponseV2> findAllV2(Pageable pageable){
        return repository.findAll(pageable)
                .map(c -> new CustomerResponseV2(
                        c.getId(),
                        c.getName(),
                        c.getEmail(),
                        c.getCreatedAt()
                ));
    }
}
