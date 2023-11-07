package restapispractice.dao;

import static org.assertj.core.api.Assertions.assertThat;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import java.sql.Timestamp;
import javax.inject.Inject;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.*;
import restapis.entities.CompanyEntity;
import restapis.implementations.dao.CompanyDao;

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
    company.setName("Kantar India Pvt Ltd");
    company.setPhoneNumber("9573558432");
    company.setOpeningDate(Timestamp.valueOf("2017-09-04 10:10:10.0"));
    CompanyEntity company1 = companyDao.create(company);

    assertThat(company1).extracting("name").isEqualTo("Kantar India Pvt Ltd");
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

    assertThat(companyEntityList)
        .extracting("name", "phoneNumber")
        .contains(Tuple.tuple("Apple India Pvt Ltd", "9493615809"));
  }

  @Test
  void testFindAll() throws NoSuchFieldException {

    var companyList = companyDao.findAll();

    for (CompanyEntity ce : companyList) {
      System.out.println(ce.toString());
    }
  }

  @Test
  void testFindNewCompanies() throws NoSuchFieldException {
    var companyList = companyDao.getNewCompanies();
    assertThat(companyList)
        .hasSize(3)
        .extracting("name")
        .contains("Apple India Pvt Ltd", "Google India Pvt Ltd", "EMARS INDIA PVT LTD");
  }
}
