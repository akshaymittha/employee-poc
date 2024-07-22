//package com.example.kafka.consumer;
//
//import com.example.constant.KafkaConstant;
//import io.micronaut.configuration.kafka.annotation.KafkaListener;
//import io.micronaut.configuration.kafka.annotation.OffsetReset;
//import io.micronaut.configuration.kafka.annotation.Topic;
//
//@KafkaListener(offsetReset = OffsetReset.EARLIEST)
//public class EmployeeConsumer {
//    @Topic(KafkaConstant.EMPLOYEE_TOPIC)
//    public void consumeEmployeeNotification(String message) {
//        System.out.println(message);
//    }
//}
