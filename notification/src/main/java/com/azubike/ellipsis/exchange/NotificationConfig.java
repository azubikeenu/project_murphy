package com.azubike.ellipsis.exchange;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Getter
public class NotificationConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queue.notification}")
    private String notification;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotification;

   @Bean
    TopicExchange internalTopicExchange(){
      return new TopicExchange(getInternalExchange() , true , false );
   }

   @Bean
   public Queue notificationQueue(){
       return new Queue(getNotification() , true ,  false , false );
   }

   @Bean
   public Binding internalToNotification(){
       return BindingBuilder.bind(notificationQueue()).to(internalTopicExchange()).with(internalNotification);
   }

}
