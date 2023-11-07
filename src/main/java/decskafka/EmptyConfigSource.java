/// *
// * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
// */
// package decskafka;
//
// import org.eclipse.microprofile.config.spi.ConfigSource;
//
// import java.util.Collections;
// import java.util.Map;
//
/// **
// * Flyweight to designate an empty config source.
// */
// public final class EmptyConfigSource implements ConfigSource {
//
//    static final ConfigSource EMPTY_CONFIG_SOURCE = new EmptyConfigSource();
//
//    private EmptyConfigSource() {
//    }
//
//    @Override
//    public Map<String, String> getProperties() {
//        return Collections.emptyMap();
//    }
//
//    @Override
//    public String getValue(String propertyName) {
//        return null;
//    }
//
//    @Override
//    public String getName() {
//        return null;
//    }
// }
