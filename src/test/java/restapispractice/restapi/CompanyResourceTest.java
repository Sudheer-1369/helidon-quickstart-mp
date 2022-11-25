package restapispractice.restapi;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import restapis.YesNo;
import restapis.dto.Company;
import restapis.runtimesupport.test.JsonContextParameterResolver;
import restapis.runtimesupport.test.JsonContextParameterResolver.JSONContext;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@HelidonTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(JsonContextParameterResolver.class)
public class CompanyResourceTest {

    private WebTarget target;

    @Inject
    public CompanyResourceTest(WebTarget target) {
        this.target = target;
    }

    @Test
    @Order(1)
    void testAddCompany(JSONContext context) {

        Company company = new Company();

        company.setName("EMARS INDIA PVT LTD");
        company.setPhoneNumber("9676253817");

        try (var r = target.path("company").request().post(Entity.json(company))) {

            assertThat(context.top(r)).isNotNull().extracting("name", "phoneNumber").containsExactly(tuple("EMARS INDIA PVT LTD", "9676253817"));
        }
    }

    @Test
    @Order(2)
    void testGetCompany(JSONContext context) {

        try (var r = target.path("company").path("16").request().get()) {

            assertThat(context.top(r)).isNotNull().extracting("name", "phoneNumber").containsExactly(tuple("EMARS INDIA PVT LTD", "9676253817"));

        }
    }

    @Test
    @Order(3)
    void testUpdateCompany(JSONContext context) {

        Company company = new Company();

        company.setName("EMARS INDIA PVT LTD");
        company.setPhoneNumber("9440011642");

        try (var r = target.path("company").path("16").request().put(Entity.json(company))) {
            assertThat(context.top(r)).isNotNull().extracting("name", "phoneNumber").containsExactly(tuple("EMARS INDIA PVT LTD", "9440011642"));

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
    public void testDeleteCompany() {
        try (var r = target.path("company").path("12").request().delete()) {

            assertThat(r.getStatusInfo().toEnum()).isEqualTo(Response.Status.NO_CONTENT);
        }
    }

    @Test
    @Order(5)
    void testGetFew(JSONContext context) {

        try (var r = target.path("company").path("functioningCompanies").request().get()) {
            assertThat(r.getStatusInfo().toEnum()).isEqualTo(Response.Status.OK);
            assertThat(context.top(r))
                    .extracting("name", "phoneNumber")
                    .contains(Tuple.tuple("Apple India Pvt Ltd", "9493615809"));
        }
    }


    @Test
    @Order(6)
    void testJersey(JSONContext context){
        try (var r = target.path("company").path("jerseyTest").request().get()){

            System.out.println(context.top(r));
        }
    }

    @Test
    @Order(7)
    void testValidate(JSONContext context){
        Company company = new Company();

        company.setName("EMARS INDIA PVT LTD");
        company.setPhoneNumber("9676253817");
        company.setSkipDuplicates(YesNo.YES);
        try (var r = target.path("company").path("validateCompanies").request().post(Entity.json(company))){
            System.out.println(context.top(r));

        }
    }
}
