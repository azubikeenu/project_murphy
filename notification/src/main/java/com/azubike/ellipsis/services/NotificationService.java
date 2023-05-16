package com.azubike.ellipsis.services;

import com.azubike.ellipsis.dto.NotificationClientRequest;
import com.azubike.ellipsis.model.Notification;
import com.azubike.ellipsis.repository.NotificationRepository;
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
