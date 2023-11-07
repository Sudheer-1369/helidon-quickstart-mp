///*
// * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
// */
//package decskafka;
//
//import io.helidon.config.mp.MpConfigSources;
//import org.eclipse.microprofile.config.Config;
//import org.eclipse.microprofile.config.spi.ConfigProviderResolver;
//import org.eclipse.microprofile.config.spi.ConfigSource;
//
//import java.util.NoSuchElementException;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//import java.util.stream.StreamSupport;
//
///**
// * Collection of utilities to support integration testing (with help of Testcontainers).
// */
//public final class IntegrationTestConfig {
//
//    private static final String MP_CONFIG_INT_TEST =
//            "META-INF/microprofile-config-integration.properties";
//
//    private IntegrationTestConfig() {
//    }
//
//    /**
//     * @return configuration specified in 'microprofile-config-integration.properties' or empty.
//     */
//    public static ConfigSource intTestConfigSource() {
//        var configSource = MpConfigSources.classPath(MP_CONFIG_INT_TEST);
//        return configSource.size() > 0 ? configSource.get(0) : EmptyConfigSource.EMPTY_CONFIG_SOURCE;
//    }
//
//    /**
//     * Takes the {@code config} and registers it with the {@link ConfigProviderResolver}. If this
//     * already holds a dynamic configuration, it merges the {@code config} with the existing dynamic
//     * configuration.
//     *
//     * @param config configuration to be registered.
//     */
//    public static void registerDynamicConfig(Config config) {
//
//        Config dynamicConfig;
//        try {
//            var currentConfig = ConfigProviderResolver.instance().getConfig();
//            // If there is no value for this yet, we know we don't have dynamic configuration yet
//            currentConfig.getValue("mp.initializer.allow", Boolean.class);
//            dynamicConfig = mergeConfiguration(config, currentConfig);
//        } catch (NoSuchElementException e) {
//            dynamicConfig = config;
//        }
//
//        ConfigProviderResolver.instance()
//                .registerConfig(dynamicConfig, Thread.currentThread().getContextClassLoader());
//    }
//
//    private static Config mergeConfiguration(Config config, Config currentConfig) {
//
//        var existingConfigSources =
//                StreamSupport.stream(currentConfig.getConfigSources().spliterator(), false);
//        var dynamicConfigSources = StreamSupport.stream(config.getConfigSources().spliterator(), false);
//
//        var allConfigSources = Stream.concat(existingConfigSources, dynamicConfigSources);
//
//        return ConfigProviderResolver.instance()
//                .getBuilder()
//                .withSources(allConfigSources.collect(Collectors.toList()).toArray(new ConfigSource[0]))
//                .build();
//    }
//}
