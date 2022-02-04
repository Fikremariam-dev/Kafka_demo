package com.example.Kafka_demo.Controller;

import com.example.Kafka_demo.services.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api/v1/producer")
public class ProducerController {

    private final KafkaProducer kafkaProducer;

    public ProducerController( KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(path = "/add/{message}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@PathVariable String message) {

        try {

            kafkaProducer.send(message);

            return new ResponseEntity<>(
                    "success",
                    HttpStatus.OK
            );


        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "");
        }

    }

}
