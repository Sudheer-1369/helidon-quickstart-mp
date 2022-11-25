///*
// * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
// */
//package decskafka;
//
//import io.helidon.config.mp.MpConfigSources;
//import io.helidon.messaging.connectors.kafka.KafkaConnector;
//import org.eclipse.microprofile.config.spi.ConfigProviderResolver;
//import org.junit.jupiter.api.extension.BeforeAllCallback;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.testcontainers.containers.KafkaContainer;
//import org.testcontainers.utility.DockerImageName;
//import org.testcontainers.utility.MountableFile;
//
//import java.util.Map;
//
///**
// * A Kafka Container for integration testing purposes.
// */
//public class KafkaContainerExtension implements BeforeAllCallback {
//
//    private static final System.Logger logger =
//            System.getLogger(KafkaContainerExtension.class.getSimpleName());
//
//    // Frequently used (de)serializers.
//    private static final String STRING_SERIALIZER =
//            "org.apache.kafka.common.serialization.StringSerializer";
//    private static final String STRING_DESERIALIZER =
//            "org.apache.kafka.common.serialization.StringDeserializer";
//
//    // Use a recent version of the Confluent INC. Kafka image
//    private static final String DOCKER_IMAGE_NAME = "confluentinc/cp-kafka:6.2.4";
//
//    // Reuse of container means that after the test is done, and the JVM shutdown
//    // the referenced container is kept running. This can give a significant boost
//    // in performance. BUT, how useful that is depends on your tests.
//    private static final boolean reuse = true;
//
//    static KafkaContainer kafkaContainer;
//
//    private static String p(String key) {
//        return KafkaConnector.CONNECTOR_PREFIX + "helidon-kafka." + key;
//    }
//
//    @Override
//    public void beforeAll(ExtensionContext context) throws Exception {
//
//        if (kafkaContainer == null) {
//
//            logger.log(System.Logger.Level.DEBUG, "Starting Kafka Test Container...");
//
//            kafkaContainer =
//                    new KafkaContainer(DockerImageName.parse(DOCKER_IMAGE_NAME))
//                            .withEnv("delete.topic.enable", "true")
//                            .withCopyFileToContainer(
//                                    MountableFile.forClasspathResource("/decs_kafka.sh"), "/bin/decs_kafka.sh")
//                            .withReuse(reuse);
//
//            kafkaContainer.start();
//
//            var execResult = kafkaContainer.execInContainer("sh", "/bin/decs_kafka.sh");
//            if (execResult.getExitCode() != 0) {
//                throw new RuntimeException(
//                        String.format(
//                                "Kafka Testcontainer failed to initialize properly: %n%s", execResult.getStderr()));
//            }
//
//            var dynamicConfiguration =
//                    ConfigProviderResolver.instance()
//                            .getBuilder()
//                            .withSources(
//                                    MpConfigSources.create(
//                                            // @formatter:off
//                                            Map.of(
//                                                    "mp.initializer.allow", "true",
//                                                    p("bootstrap.servers"), kafkaContainer.getBootstrapServers(),
//                                                    p("key.serializer"), STRING_SERIALIZER,
//                                                    p("value.serializer"), STRING_SERIALIZER,
//                                                    p("key.deserializer"), STRING_DESERIALIZER,
//                                                    p("value.deserializer"), STRING_DESERIALIZER)),
//                                    // @formatter:on
//                                    IntegrationTestConfig.intTestConfigSource())
//                            .build();
//
//            IntegrationTestConfig.registerDynamicConfig(dynamicConfiguration);
//        }
//    }
//}
