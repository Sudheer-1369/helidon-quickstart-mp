package restapispractice.service;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import restapis.dto.Employee;
import restapis.implementations.services.EmployeeService;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@HelidonTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Inject
    public EmployeeServiceTest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Test
    @Order(1)
    void testAddEmployee() {

        Employee employee = new Employee();
        employee.setLastName("Kanakala");
        employee.setFirstName("Niteesh");
        employee.setAge(22);
        employee.setSalary(2200000);
        employee.setJoiningDate("2021-01-01 10:10:10.10");

        Employee employee1 = employeeService.create(employee);
        assertThat(employee1).isNotNull();
        assertThat(employee1).extracting("lastName").isEqualTo("Kanakala");

    }

    @Test
    @Order(2)
    void testGetEmployee() {
        Employee employee = employeeService.get(9L);
        assertThat(employee).isNotNull();
        assertThat(employee).extracting("lastName").isEqualTo("Kanakala");
        assertThat(employee).extracting("age").isEqualTo(22);
    }

    @Test
    @Order(3)
    void updateEmployee() {

        Employee employee = new Employee();
        employee.setId(9L);
        employee.setLastName("Kanakala");
        employee.setFirstName("Niteesh Kumar");
        employee.setAge(23);
        employee.setSalary(2200000);
        employee.setJoiningDate("2021-01-02 10:10:10.10");

        Employee employee1 = employeeService.put(employee);

        assertThat(employee1).extracting("firstName").isEqualTo("Niteesh Kumar");
        assertThat(employee1).extracting("age").isEqualTo(23);
    }

    @Test
    @Order(4)
    void partialUpdateEmployee() {
        Employee employee = new Employee();
        employee.setId(9L);
        employee.setAge(26);

        Employee employee1 = employeeService.patch(employee);

        assertThat(employee1).extracting("firstName").isEqualTo("Niteesh Kumar");
        assertThat(employee1).extracting("age").isEqualTo(26);
    }
}
