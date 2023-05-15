package com.azubike.ellipsis.controllers;

import com.azubike.ellipsis.dto.CustomerRegistrationRequest;
import com.azubike.ellipsis.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
          log.info("Registering new customer {} " , customerRegistrationRequest);
          customerService.registerCustomer(customerRegistrationRequest);
    }
}
