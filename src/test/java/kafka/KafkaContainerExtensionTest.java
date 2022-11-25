///*
// * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
// */
//package kafka;
//
//import decskafka.KafkaContainerExtension;
//import decskafka.KafkaContainerResolver;
//import org.apache.kafka.clients.admin.AdminClient;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.testcontainers.containers.KafkaContainer;
//
//import java.util.Map;
//import java.util.concurrent.ExecutionException;
//
//import static org.apache.kafka.clients.admin.AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG;
//
//@ExtendWith(KafkaContainerResolver.class)
//@ExtendWith(KafkaContainerExtension.class)
//class KafkaContainerExtensionTest {
//
//    @Test
//    @Disabled("enable to verify KafkaContainerExtension sanity")
//    @DisplayName("should be able to start Kafka container with some topics")
//    void kafkaWithTopics(KafkaContainer container) throws ExecutionException, InterruptedException {
//
//        try (var client =
//                     AdminClient.create(Map.of(BOOTSTRAP_SERVERS_CONFIG, container.getBootstrapServers()))) {
//            Assertions.assertThat(client.listTopics().names().get()).contains("transmission.received");
//        }
//    }
//}
