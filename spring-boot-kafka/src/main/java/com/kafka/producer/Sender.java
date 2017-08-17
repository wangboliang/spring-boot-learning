package com.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Sender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka.topics[0]}")
    private String topic;

    public void send(String message) {
        kafkaTemplate.send(topic, message);
        log.info("sending data='{}' to topic='{}'", message, topic);
    }
}
