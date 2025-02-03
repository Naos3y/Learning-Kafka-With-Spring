package com.brunolopes.learn_kafka.controller;

import com.brunolopes.learn_kafka.kafka.KafkaJsonProducer;
import com.brunolopes.learn_kafka.kafka.KafkaProducer;
import com.brunolopes.learn_kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class MessageController {
    private KafkaProducer kafkaProducer;
    private KafkaJsonProducer kafkaJsonProducer;

    @Autowired
    public MessageController(KafkaProducer kafkaProducer, KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to topic");
    }

    @PostMapping("/publishJson")
    public ResponseEntity<String> publishJson(@RequestBody User user){
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity.ok(user.toString());
    }
}
