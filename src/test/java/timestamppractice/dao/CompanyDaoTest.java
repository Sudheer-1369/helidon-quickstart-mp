package timestamppractice.dao;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.*;
import timestamppractice.entities.CompanyEntity;
import timestamppractice.implementations.dao.CompanyDao;

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
        company.setName("Apple India Pvt Ltd");
        company.setPhoneNumber("9493615809");

        CompanyEntity company1 = companyDao.create(company);

        assertThat(company1).extracting("name").isEqualTo("Apple India Pvt Ltd");
    }

    @Test
    @DisplayName("Should be able to find the entity with the given id")
    @Order(2)
    void testFindCompany(){
        CompanyEntity company = companyDao.findById(2L);
        assertThat(company).extracting("name").isEqualTo("Oracle India Pvt Ltd");
    }

    @Test
    @DisplayName("Should be able to update the Company")
    @Order(3)
    void testUpdateCompany(){
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
    void testDeleteCompany(){

        companyDao.deleteById(5L);
        CompanyEntity company = companyDao.findById(5L);
        assertThat(company).isNull();
    }

}
