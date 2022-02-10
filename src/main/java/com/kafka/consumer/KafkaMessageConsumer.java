package com.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Properties;

import static java.util.Set.of;
import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

@Slf4j
public class KafkaMessageConsumer {
    public static void main(String[] args) {
        log.debug("KafkaMessageConsumer.main");
        try {

            // Properties to connect with kafka
            Properties properties = new Properties();
            properties.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            properties.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.put(GROUP_ID_CONFIG, "test-topic-group");

            // create kakfa consumer
            KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);

            //  subscribe to the topic
            kafkaConsumer.subscribe(of("test-topic"));

            // poll for the message
            while (true) {
                ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(2000));
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    log.info(consumerRecord.value());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
