package com.popugaevvn.authservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.template.default-receive-queue}")
    private String emailQueueName;

    @Value("${spring.rabbitmq.template.exchange}")
    private String emailExchangeName;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingKey;

    @Bean
    public Queue emailQueue() {
        return new Queue(emailQueueName, true);
    }

    @Bean
    TopicExchange emailExchange() {
        return new TopicExchange(emailExchangeName);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(emailQueue()).to(emailExchange()).with(routingKey);
    }
}
