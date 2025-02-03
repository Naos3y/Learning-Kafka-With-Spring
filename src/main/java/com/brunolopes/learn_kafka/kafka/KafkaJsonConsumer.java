package com.brunolopes.learn_kafka.kafka;

import com.brunolopes.learn_kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "jsonTopic", groupId = "myConsumerGroup")
    public void consumeJson(User user){
        LOGGER.info("Message received -> {}", user.toString());
    }
}
