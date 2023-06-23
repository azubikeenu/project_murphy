package com.azubike.clients.notification;

import com.azubike.clients.dto.NotificationClientRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notification",url = "${clients.notification.url}" , path = "/api/v1/notifications")

public interface NotificationClient {
    @PostMapping
    public void notifyCustomer(@RequestBody NotificationClientRequest notificationClientRequest);

}
