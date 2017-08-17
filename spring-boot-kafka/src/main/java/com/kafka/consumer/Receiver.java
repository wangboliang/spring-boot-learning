package com.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }
    @KafkaListener(topics = "${kafka.topics[0]}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        log.info("received data='{}'", consumerRecord.toString());
        latch.countDown();
    }

}
