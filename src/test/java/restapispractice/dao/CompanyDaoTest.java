package restapispractice.dao;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.*;
import restapis.entities.CompanyEntity;
import restapis.implementations.dao.CompanyDao;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;


@HelidonTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CompanyDaoTest {

    private CompanyDao companyDao;

    @Inject
    public CompanyDaoTest(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Test
    @DisplayName("Should be able to create a company in the database")
    @Order(1)
    void testCreateCompany() {
        CompanyEntity company = new CompanyEntity();
        company.setName("Google India Pvt Ltd");
        company.setPhoneNumber("9573558432");

        CompanyEntity company1 = companyDao.create(company);

        assertThat(company1).extracting("name").isEqualTo("Google India Pvt Ltd");
    }

    @Test
    @DisplayName("Should be able to find the entity with the given id")
    @Order(2)
    void testFindCompany() {
        CompanyEntity company = companyDao.findById(2L);
//        assertThat(company).extracting("name").isEqualTo("Oracle India Pvt Ltd");
        assertThat(company).isNull();
    }

    @Test
    @DisplayName("Should be able to update the Company")
    @Order(3)
    void testUpdateCompany() {
        CompanyEntity company = new CompanyEntity();
        company.setId(2L);
        company.setName("Oracle India Pvt Ltd");
        company.setPhoneNumber("9573558432");
        CompanyEntity company1 = companyDao.update(company);

        assertThat(company1).extracting("phoneNumber").isEqualTo("9573558432");
    }

    @Test
    @DisplayName("Should be able to delete the existing company")
    @Order(4)
    void testDeleteCompany() {

        companyDao.deleteById(5L);
        CompanyEntity company = companyDao.findById(5L);
        assertThat(company).isNull();
    }

    @Test
    @DisplayName("Should be able to get few")
    @Order(5)
    void testGetFew() {

        var companyEntityList = companyDao.getFew();

        assertThat(companyEntityList).extracting("name", "phoneNumber")
                .contains(Tuple.tuple("Apple India Pvt Ltd", "9493615809"));

    }

}
