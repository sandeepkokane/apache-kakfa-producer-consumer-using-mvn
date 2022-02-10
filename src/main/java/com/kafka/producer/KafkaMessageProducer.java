package com.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Slf4j
public class KafkaMessageProducer {
    public static void main(String[] args) {
        log.debug("KafkaMessageProducer.main");
        try {
            // Properties to connect with kafka server
            Properties properties = new Properties();
            properties.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            properties.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            properties.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

            // create KafkaProducer
            KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

            // create string message
            String message = "Welcome to Apache Kafka Messaging";
            log.info("Message to publish : " + message);

            // provide topic name
            String topicName = "test-topic";
            log.info("Topic name : " + topicName);

            // create ProducerRecord representing the message
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topicName, message);

            // send/publish message
            kafkaProducer.send(producerRecord);
            log.info("Message Sent");

            // flush the message
            kafkaProducer.flush();

            // close the connection
            kafkaProducer.close();

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
