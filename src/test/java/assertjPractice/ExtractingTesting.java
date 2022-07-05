package assertjPractice;

import StreamsPractice.Employee;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@HelidonTest
public class ExtractingTesting {

    @Test
    void testExtracting() {
        Employee employee = new Employee("Sudheer", 24, 15, "ECE");
        Employee employee1 = new Employee("Manikantha", 28, 25, "CSE");
        Employee employee2 = new Employee("Manoja", 23, 20, "MBBS");
        Employee employee3 = new Employee("Venkat", 30, 25, "MECH");

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        List<String> list = employees.stream().map(Employee::getName).collect(Collectors.toList());
        assertThat(list).asList().containsExactly("Sudheer", "Manikantha", "Manoja", "Venkat");

        //In order to skip all the above process we can use extracting process

        assertThat(employees).extracting("name").containsExactly("Sudheer", "Manikantha", "Manoja", "Venkat");

        //More than one column extracting and asserting

        assertThat(employees).filteredOn(e -> e.getName().contains("a")).extracting("name", "age", "salary").containsExactly(
                tuple("Manikantha", 28, 25),
                tuple("Manoja", 23, 20),
                tuple("Venkat", 30, 25)
        );

    }
}
