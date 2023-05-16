package com.azubike.amqp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitmqConfig {

    private final ConnectionFactory connectionFactory;

    @Bean
    public AmqpTemplate amqpTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    SimpleRabbitListenerContainerFactory createListener (){
        final SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleRabbitListenerContainerFactory.setMaxConcurrentConsumers(10);
        // this will start with 5 consumers
        simpleRabbitListenerContainerFactory.setConcurrentConsumers(5);
        simpleRabbitListenerContainerFactory.setAutoStartup(true);
        simpleRabbitListenerContainerFactory.setMessageConverter(messageConverter());
        // this prevents requeue of message on exception
        simpleRabbitListenerContainerFactory.setDefaultRequeueRejected(false);
        return simpleRabbitListenerContainerFactory;
    }

    @Bean
    public MessageConverter messageConverter(){
        ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();
        return new Jackson2JsonMessageConverter(objectMapper);
    }



}
