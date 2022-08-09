package timestamppractice.restapi;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.testcontainers.shaded.com.google.common.collect.Iterables;
import timestamppractice.dto.Employee;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@HelidonTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeResourceTest {

    private WebTarget target;

    @Inject
    public EmployeeResourceTest(WebTarget target) {
        this.target = target;
    }

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
    @Order(1)
    void testAddEmployee(){

        Employee employee = new Employee();
        employee.setLastName("Thadala");
        employee.setFirstName("SivaTeja");
        employee.setAge(24);
        employee.setSalary(2200000);
        employee.setJoiningDate("2021-01-01");

        try(var r = target.path("employee").request().post(Entity.json(employee))){

            assertThat(query(r,"$")).isNotNull().extracting("lastName","age").containsExactly(tuple("Thadala", 24));
        }
    }

    @Test
    @Order(2)
    void testGetEmployee(){

        try(var r = target.path("employee").path("20").request().get()){

            assertThat(query(r,"$")).isNotNull().extracting("lastName","age").containsExactly(tuple("Thadala", 24));

        }
    }

    @Test
    @Order(3)
    void testUpdateEmployee(){

        Employee employee = new Employee();
        employee.setLastName("Kanakala");
        employee.setFirstName("Ayyagoru");
        employee.setAge(23);
        employee.setSalary(2200000);
        employee.setJoiningDate("2021-01-01 10:10:10.10");

        try(var r = target.path("employee").path("9").request().put(Entity.json(employee))){
            assertThat(query(r,"$")).isNotNull().extracting("firstName","age").containsExactly(tuple("Ayyagoru", 23));

        }
    }

//    @Test
//    public void testUpdatePartiallyCompany(){
//
//        Company company = new Company();
//
//        company.setId(13L);
//        company.setName("EMARS INDIA LTD");
//        company.setPhoneNumber("8919624673");
//
//        var client =
//                ClientBuilder.newClient().property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
//
//
//        try (var r =
//                     client
//                             .target(target.getUri())
//                             .path("company")
//                             .request()
//                             .build("PATCH", Entity.json(company))
//                             .invoke()){
//
//            assertThat(query(r,"$")).isNotNull().extracting("name","phoneNumber").containsExactly(tuple("EMARS INDIA LTD", "8919624673"));
//
//        }
//    }

    @Test
    @Order(5)
    public void testDeleteCompany(){
        try(var r = target.path("employee").path("20").request().delete()){

            assertThat(r.getStatusInfo().toEnum()).isEqualTo(Response.Status.NO_CONTENT);
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
