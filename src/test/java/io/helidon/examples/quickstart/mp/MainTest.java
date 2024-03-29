package io.helidon.examples.quickstart.mp;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@HelidonTest
class MainTest {

  @Inject private WebTarget target;

  @Test
  void testHelloWorld() {
    JsonObject jsonObject = target.path("greet").request().get(JsonObject.class);
    Assertions.assertEquals("Hello World!", jsonObject.getString("message"), "default message");

    jsonObject = target.path("greet/Joe").request().get(JsonObject.class);
    Assertions.assertEquals("Hello Joe!", jsonObject.getString("message"), "hello Joe message");

    try (Response r =
        target
            .path("greet/greeting")
            .request()
            .put(Entity.entity("{\"greeting\" : \"Hola\"}", MediaType.APPLICATION_JSON))) {
      Assertions.assertEquals(204, r.getStatus(), "PUT status code");
    }

    jsonObject = target.path("greet/Jose").request().get(JsonObject.class);
    Assertions.assertEquals("Hola Jose!", jsonObject.getString("message"), "hola Jose message");

    try (Response r = target.path("metrics").request().get()) {
      Assertions.assertEquals(200, r.getStatus(), "GET metrics status code");
    }

    try (Response r = target.path("health").request().get()) {
      Assertions.assertEquals(200, r.getStatus(), "GET health status code");
    }
  }
}
