package com.brunolopes.learn_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic firstTopic(){
        return TopicBuilder.name("first_topic")
                .build();
    }

    @Bean
    public NewTopic jsonTopic(){
        return TopicBuilder.name("jsonTopic")
                .build();
    }
}
