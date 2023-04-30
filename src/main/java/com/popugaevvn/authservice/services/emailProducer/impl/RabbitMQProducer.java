package com.popugaevvn.authservice.services.emailProducer.impl;

import com.popugaevvn.authservice.services.emailProducer.EmailProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQProducer implements EmailProducer {

    @Value("${spring.rabbitmq.template.exchange}")
    private String emailExchangeName;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessageEmailCreate(String email) {
        rabbitTemplate.convertAndSend(emailExchangeName, routingKey, email);
    }

}
