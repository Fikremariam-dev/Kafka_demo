package com.example.Kafka_demo.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

// constants
import static com.example.Kafka_demo.constants.Topics.TOPIC_1;
import static com.example.Kafka_demo.constants.GroupId.GROUP_ID_1;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = TOPIC_1, groupId = GROUP_ID_1)
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group " + GROUP_ID_1 + ": " + message);
    }

}
