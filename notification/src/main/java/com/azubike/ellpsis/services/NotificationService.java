package com.azubike.ellpsis.services;

import com.azubike.ellpsis.dto.NotificationClientRequest;
import com.azubike.ellpsis.model.Notification;
import com.azubike.ellpsis.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    public void notify(NotificationClientRequest notificationClientRequest) {
        final Notification notification = Notification.builder().message(notificationClientRequest.getMessage())
                .toCustomerEmail(notificationClientRequest.getToCustomerEmail())
                .message("This is a dummy message")
                .sender("Richard")
                .toCustomerId(notificationClientRequest.getToCustomerId()).build();
        notificationRepository.save(notification);
    }

}
