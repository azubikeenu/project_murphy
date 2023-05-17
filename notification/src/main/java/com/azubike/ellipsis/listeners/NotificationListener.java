package com.azubike.ellipsis.listeners;

import com.azubike.ellipsis.dto.NotificationClientRequest;
import com.azubike.ellipsis.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationListener {
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void listen(NotificationClientRequest notificationClientRequest){
         log.info("Consuming message {}  from queue" , notificationClientRequest);
         notificationService.notify(notificationClientRequest);
    }
}
