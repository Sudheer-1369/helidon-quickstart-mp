package restapispractice.service;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import restapis.dto.Company;
import restapis.implementations.services.CompanyService;

import javax.inject.Inject;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@HelidonTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CompanyServiceTest {

    private CompanyService companyService;

    @Inject
    public CompanyServiceTest(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Test
    @Order(1)
    void testAddCompany(){
        Company company = new Company();
        company.setName("Linoy Technologies");
        company.setPhoneNumber("12345678");

        Company company1 = companyService.create(company);

        assertThat(company1).extracting("name").isEqualTo("Linoy Technologies");

    }

    @Test
    @Order(3)
    void testUpdateCompany(){
        Company company = new Company();

        company.setId(10L);
        company.setName("Linoy Technologies Pvt Ltd");
        company.setPhoneNumber("1234567890");

        Company company1 = companyService.put(company);

        assertThat(company1).extracting("name").isEqualTo("Linoy Technologies Pvt Ltd");
        assertThat(company1).extracting("phoneNumber").isEqualTo("1234567890");

    }

    @Test
    @Order(4)
    void testPartialUpdate(){
        Company company = new Company();

        company.setId(11L);
        company.setName("Linoy Technologies India Pvt Ltd");

        Company company1 = companyService.patch(company);

        assertThat(company1).extracting("name").isEqualTo("Linoy Technologies India Pvt Ltd");
        assertThat(company1).extracting("phoneNumber").isEqualTo("9493615809");

    }

    @Test
    @Order(2)
    void testFetchCompany(){
        Company company = companyService.get(10L);
        assertThat(company).extracting("name").isEqualTo("Linoy Technologies India Pvt Ltd");
        assertThat(company).extracting("phoneNumber").isEqualTo("1234567890");
    }

    @Test
    @Order(5)
    void testDeleteCompany(){
        companyService.delete(10L);
        Company company = companyService.get(10L);

        assertThat(company).isNull();
    }
}
