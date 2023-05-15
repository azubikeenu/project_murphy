package com.azubike.ellipsis.services;

import com.azubike.ellipsis.dto.CustomerRegistrationRequest;
import com.azubike.ellipsis.dto.FraudCheckResponse;
import com.azubike.ellipsis.model.Customer;
import com.azubike.ellipsis.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class  CustomerService{
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @Transactional
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .email(customerRegistrationRequest.email())
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName()).build();
        customerRepository.saveAndFlush(customer);
        //todo check if email is valid

        //todo check if email is not taken
        final FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, customer.getId());

        if(Objects.requireNonNull(fraudCheckResponse).isFraudulent()){
            throw new IllegalArgumentException("Customer is fraudulent!!!");
        }

        // todo send notification
    }
}
