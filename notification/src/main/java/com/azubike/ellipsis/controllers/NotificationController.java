package com.azubike.ellipsis.controllers;

import com.azubike.ellipsis.dto.NotificationClientRequest;
import com.azubike.ellipsis.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/notifications")
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping
    public void notifyCustomer(@RequestBody NotificationClientRequest notificationClientRequest){
        log.info("Sending notification to customer with id {} and email {}" , notificationClientRequest.getToCustomerId() , notificationClientRequest.getToCustomerEmail());
            notificationService.notify(notificationClientRequest);
    }
}
