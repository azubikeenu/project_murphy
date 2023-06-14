package com.azubike.ellipsis.services;

import com.azubike.amqp.producer.RabbitProducer;
import com.azubike.clients.dto.NotificationClientRequest;
import com.azubike.clients.fraud.FraudClient;
import com.azubike.ellipsis.dto.CustomerRegistrationRequest;
import com.azubike.ellipsis.model.Customer;
import com.azubike.ellipsis.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitProducer producer;

    @Transactional
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .email(customerRegistrationRequest.email())
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName()).build();
        customerRepository.saveAndFlush(customer); // ensures that the customer is persisted and the persisted object is returned

        final var response = fraudClient.isFraudster(customer.getId());
        var fraudCheckResponse = response.getBody();

        if (Objects.requireNonNull(fraudCheckResponse).isFraudulent()) {
            //TODO create a custom exception and handle with a global error handler
            throw new IllegalArgumentException("Customer is fraudulent!!!");
        }

        final NotificationClientRequest notificationClientRequest = NotificationClientRequest.builder().
                toCustomerEmail(customer.getEmail()).toCustomerId(customer.getId()).sender("Richard").message("Welcome in").build();
        producer.publish(notificationClientRequest, "internal-exchange", "internal.notification.routing-key");

    }
}
