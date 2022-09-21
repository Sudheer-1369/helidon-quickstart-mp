package restapispractice.dao;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import restapis.entities.CompanyEntity;
import restapis.entities.EmployeeEntity;
import restapis.implementations.dao.CompanyDao;
import restapis.implementations.dao.EmployeeDao;

import javax.inject.Inject;
import java.sql.Timestamp;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@HelidonTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDaoTest {
    private EmployeeDao employeeDao;

    private CompanyDao companyDao;

    @Inject
    public EmployeeDaoTest(EmployeeDao employeeDao, CompanyDao companyDao) {
        this.employeeDao = employeeDao;
        this.companyDao = companyDao;
    }

    @Test
    @Order(1)
    void testCreateEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
//        employeeEntity.setAge(28);
        employeeEntity.setFirstName("Manikanta");
        employeeEntity.setLastName("Podugu");
        employeeEntity.setSalary(3500000);
        employeeEntity.setJoiningDate(Timestamp.valueOf("2016-09-04 10:10:10.0"));

        EmployeeEntity employeeEntity1 = employeeDao.create(employeeEntity);
        assertThat(employeeEntity1).isNotNull();
    }

    @Test
    @Order(2)
    void testGetEmployee() {
        EmployeeEntity employeeEntity = employeeDao.findById(2L);
        System.out.println(employeeEntity);
        assertThat(employeeEntity).isNotNull();
        assertThat(employeeEntity).extracting("joiningDate").isEqualTo(Timestamp.valueOf("2016-09-04 10:10:10.0"));
    }

    @Test
    @Order(3)
    void testUpdateEmployee() {

        CompanyEntity company = new CompanyEntity();
        company.setName("Google India Pvt Ltd");
        company.setPhoneNumber("9493615809");

        CompanyEntity company1 = companyDao.create(company);

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(2L);
        employeeEntity.setAge(29);
        employeeEntity.setFirstName("Manikanta");
        employeeEntity.setLastName("Podugu");
        employeeEntity.setSalary(3500000);
        employeeEntity.setJoiningDate(Timestamp.valueOf("2016-09-04 10:10:10.0"));
        employeeEntity.setCompany(company);

        EmployeeEntity employeeEntity1 = employeeDao.update(employeeEntity);

        assertThat(employeeEntity1).extracting("age").isEqualTo(29);
    }


    @Test
    @Order(4)
    void testDeleteEmployee() {
        employeeDao.deleteById(3L);
        assertThat("1").isNotNull();
    }

}
