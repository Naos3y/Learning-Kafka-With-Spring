package com.brunolopes.learn_kafka.kafka;

import com.brunolopes.learn_kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = "first_topic", groupId = "myConsumerGroup")
    public void consume(String message){
        LOGGER.info("Message received -> {}", message);
    }

}
