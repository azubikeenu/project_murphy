package com.azubike.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "notification", path = "/api/v1/notifications")

public interface NotificationClient {
    @PostMapping("{customerId}/{customerEmail}")
     void notifyCustomer(@PathVariable("customerId") Integer customerId, @PathVariable("customerEmail") String customerEmail);
}
