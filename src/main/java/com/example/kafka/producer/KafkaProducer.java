package com.example.kafka.producer;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface KafkaProducer {
    void send(@Topic String topic, String message);
}
