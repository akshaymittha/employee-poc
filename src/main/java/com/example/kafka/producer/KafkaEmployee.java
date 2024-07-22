package com.example.kafka.producer;


import com.example.constant.KafkaConstant;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class KafkaEmployee {
    @Inject
    KafkaProducer kafkaProducer;
    public void sendEmployeeNotification(String message) {
        kafkaProducer.send(KafkaConstant.EMPLOYEE_TOPIC, message);
    }
}
