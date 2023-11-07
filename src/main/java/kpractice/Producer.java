/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package kpractice;

import java.util.Properties;
import java.util.logging.Logger;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer {
  public static void main(String[] args) {

    final Logger logger = Logger.getLogger(Producer.class.getName());
    // Create a properties object for producer

    Properties properties = new Properties();

    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.setProperty(
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty(
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");

    // Create the producer

    final KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

    // Crete the ProducerRecord which is used for writing into the kafka topic by the kafka producer

    ProducerRecord<String, String> producerRecord;

    for (int i = 0; i < 7; i++) {
      // List<ProducerRecord> producerRecordList = new ArrayList<>();

      producerRecord = new ProducerRecord<>("kafka-java-topic", "key-" + i, "value-" + i);
      // ProducerRecord<String, String> producerRecord2 = new
      // ProducerRecord<>("kafka-topic-practice","key2","SudheerKumarPatnana");

      // Send the data - asynchronous
      producer.send(
          producerRecord,
          (recordMetadata, e) -> {
            if (e == null) {

              logger.info(
                  "\nReceived record metadata from the broker for selecting the leader broker for the topic :"
                      + "Topic: "
                      + recordMetadata.topic()
                      + ", Partition: "
                      + recordMetadata.partition()
                      + ", offset: "
                      + recordMetadata.offset()
                      + ", @TimeStamp: "
                      + recordMetadata.timestamp()
                      + "\n");
            } else {
              logger.info("Error Occurred while writing to the producer : " + e.getMessage());
            }
          });
    }
    // producer.send(producerRecord2);

    // flush and then close the producer
    producer.flush();
    producer.close();
  }
}
