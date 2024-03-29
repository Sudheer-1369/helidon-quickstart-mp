/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package jan;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.core.Response;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.testcontainers.shaded.com.google.common.collect.Iterables;

@ApplicationScoped
public class JSONContextParameterResolver {

  private static final Map<String, Boolean> JSON_PRINT =
      Map.of(JsonGenerator.PRETTY_PRINTING, Boolean.TRUE);

  //    public Object resolveParameter(
  //            ParameterContext parameterContext, ExtensionContext extensionContext)
  //            throws ParameterResolutionException {
  //
  //        return new JSONContext();
  //    }

  //  public static class JSONContext {
  private static final JsonWriterFactory jsonWriterFactory = Json.createWriterFactory(JSON_PRINT);
  private static final Configuration JSON_PATH =
      Configuration.builder()
          .options(
              // We're using Iterables.getFirst whenever we expect a single value
              Option.ALWAYS_RETURN_LIST,
              // Let us just deal with empty lists
              Option.SUPPRESS_EXCEPTIONS)
          .build();
  private String lastReadPayload;
  private DocumentContext lastReadDocumentContext;
  private boolean responseRead;

  public boolean supportsParameter(
      ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {

    //        return parameterContext.getParameter().getType() == JSONContext.class;
    return true;
  }

  /**
   * Query the {@code response} body payload with a JsonPath query.
   *
   * @param response the JAX-RS response object (with payload).
   * @param query a JsonPath query (as a string)
   * @return the result of the query coerced to a list or empty list for no results.
   * @see <a href="https://github.com/json-path/JsonPath">JsonPath</a>
   */
  public List<?> query(Response response, String query) {

    responseRead = true;

    lastReadPayload = response.readEntity(String.class);
    lastReadDocumentContext = JsonPath.using(JSON_PATH).parse(lastReadPayload);
    List<?> result = lastReadDocumentContext.read(query);

    if (result.size() == 0) {
      return Collections.emptyList();
    } else if (result.get(0) instanceof List<?>) {
      return (List<?>) Iterables.getFirst(result, Collections.emptyList());
    } else {
      return List.of(result.get(0));
    }
  }

  public String getLastReadPayload() {
    return lastReadPayload;
  }

  /** @return a pretty Json string for the last read payload or null if none was read. */
  public String jsonPrettyPrinted() {
    if (lastReadPayload == null) return null;

    var sw = new StringWriter();
    try (JsonWriter writer = jsonWriterFactory.createWriter(sw);
        JsonReader reader = Json.createReader(new StringReader(lastReadPayload))) {
      writer.write(reader.read());
      return sw.toString();
    }
  }

  public DocumentContext getLastReadDocumentContext() {
    return lastReadDocumentContext;
  }

  /**
   * Shorthand to get to the top of the JAX-RS/Json response body.
   *
   * @param response the JAX-RS response.
   * @return the result for <strong>$</strong>
   */
  public List<?> top(Response response) {
    return query(response, "$");
  }

  public Iterable<?> read(String path) {

    if (!responseRead)
      throw new IllegalStateException("Response was not \"top\" or \"query(response, path)\"");
    return getLastReadDocumentContext().read(JsonPath.compile(path), Iterable.class);
  }

  public List<?> query(String path) {

    if (!responseRead)
      throw new IllegalStateException("Response was not \"top\" or \"query(response, path)\"");

    return getLastReadDocumentContext().read(path);
  }
}
// }
