package com.azubike.amqp.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitProducer {
    private final AmqpTemplate amqpTemplate;
    public void publish(Object payload , String exchangeName , String routingKey){
        log.info("publishing to {} using routing key {}  with payload {}" , exchangeName , routingKey , payload);
        amqpTemplate.convertAndSend(exchangeName ,routingKey , payload);
        log.info("published to {} using routing key {}  with payload {}" , exchangeName , routingKey , payload);
    }
}
