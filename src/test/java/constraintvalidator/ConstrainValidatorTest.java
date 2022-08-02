package constraintvalidator;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.com.google.common.collect.Iterables;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@HelidonTest
class ConstrainValidatorTest {

    @Inject
    private WebTarget target;

    private String lastReadPayload;
    private DocumentContext lastReadDocumentContext;
    private boolean responseRead;


    private static final Configuration JSON_PATH =
            Configuration.builder()
                    .options(
                            // We're using Iterables.getFirst whenever we expect a single value
                            Option.ALWAYS_RETURN_LIST,
                            // Let us just deal with empty lists
                            Option.SUPPRESS_EXCEPTIONS)
                    .build();

    @Test
    @DisplayName("Should be able to create an Employee")
    void createEmployee(){
        Employee employee = new Employee();
        employee.setAge(25);
        employee.setDateOfBirth(Date.valueOf("1997-09-04"));
        employee.setJoiningDate(Date.valueOf("2020-09-04"));

        try (var r = target.path("employee").request().post(Entity.json(employee))){

            assertThat(query(r,"$")).isNotNull().extracting("dateOfBirth").map(Object::toString).containsExactly("1997-09-03Z");
        }
    }

    @Test
    @DisplayName("Should be able to create an Employee with validation error")
    void createEmployeeWithValidationError(){
        Employee employee = new Employee();
        employee.setAge(25);
        employee.setJoiningDate(Date.valueOf("1997-09-04"));
        employee.setDateOfBirth(Date.valueOf("2020-09-04"));

        try (var r = target.path("employee").request().post(Entity.json(employee))){

            assertThat(query(r,"$")).isNotNull().extracting("message").containsExactly("The Date of birth should always be before the date of joining");
        }
    }

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
}
