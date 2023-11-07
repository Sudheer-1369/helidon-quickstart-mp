/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package kpractice;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.streams.kstream.KStream;

public class Consumer {
  public static void main(String[] args) throws InterruptedException {

    final Logger logger = Logger.getLogger(Consumer.class.getName());

    // Create variables for the string either through microprofile.config or hardcode the values
    final String bootstrapServers = "localhost:9092";
    final String consumerGroupId = "java-consumer-group";

    // Create and populate the properties object
    Properties properties = new Properties();
    properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    properties.setProperty(
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    properties.setProperty(
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    properties.setProperty(
        ConsumerConfig.GROUP_ID_CONFIG,
        consumerGroupId); // This consumer group might not present in the apache kafka server so we
    // need to set the offset point from where the consumer group need to
    // consume
    properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    // Create a consumer
    final KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

    KStream<String, String> kStream;

    // Subscribe to all the topics from which the consumer will read
    consumer.subscribe(Arrays.asList("kafka-java-topic"));

    // poll and consume the records
    while (true) {
      ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(10000));
      for (ConsumerRecord<String, String> record : consumerRecords) {
        logger.info(
            "Received new record: \n"
                + "key: "
                + record.key()
                + ", value"
                + record.value()
                + ", Topic: "
                + record.topic()
                + ", Partition: "
                + record.partition()
                + ", offset: "
                + record.offset());
      }
    }
  }
}
