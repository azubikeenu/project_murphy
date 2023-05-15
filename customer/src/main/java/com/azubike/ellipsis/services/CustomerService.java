package com.azubike.ellipsis.services;

import com.azubike.ellipsis.dto.CustomerRegistrationRequest;
import com.azubike.ellipsis.model.Customer;
import com.azubike.ellipsis.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .email(customerRegistrationRequest.email())
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName()).build();

        customerRepository.save(customer);
    }
}
