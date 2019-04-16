package com.csye6225.kafka;


import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Producer {
    static LogManager logManager = LogManager.getLogManager();
    static Logger log = logManager.getLogger("Producer");

    private static final String TOPIC_NAME="ABC";

    private static KafkaProducer<String, String> createKafkaProducer() {
        Map<String,Object> map=new HashMap<>();
        map.put("bootstrap.servers","127.0.0.1:9092,127.0.0.1:9093");
        map.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        map.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        System.out.println("Kafka Producer created");
        log.info("Kafka producer created");
        return new KafkaProducer<>(map);

    }

    public static long SendToKafka(String data) {
        try {
            KafkaProducer<String, String> producer = createKafkaProducer();
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, data);
            System.out.println("Kafka Producer created the record and sending to topic");
            Future<RecordMetadata> recordMetadata = producer.send(record, new ProducerCallback());
            System.out.println("Kafka Producer msg sent.....");
            long offset = recordMetadata.get().offset();
            log.info("Kafka producer message sent");
            return offset;

        } catch (Exception e) {
            log.info("Kafka producer logged error in SendToKafka : " + e.getMessage() +"  with Stacktrace : " +e.getStackTrace());
            System.out.println("Exception while sending data by Kafka Producer - " + e.getMessage());
            e.printStackTrace();
            return 0    ;
        }
    }

    // Method to see if the message is send, if no exception the message is send
    private static class ProducerCallback implements Callback {
        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if (e != null) {
                System.out.println("Kafka Producer error on Completion - " + e.getMessage());
                log.info("Kafka producer logged error in onCompletion : " + e.getMessage() +"  with Stacktrace : " +e.getStackTrace());
                e.printStackTrace();
            } else {
                System.out.println("Kafka Producer success on Completion - " + recordMetadata.offset());
                log.info("Kafka producer logged onCompletion - data sent on : " + recordMetadata.topic() +"  with offset : " + recordMetadata.offset());
                System.out.println("sent on : " + recordMetadata.topic() + " offset : " + recordMetadata.offset());
            }

        }
    }
}

