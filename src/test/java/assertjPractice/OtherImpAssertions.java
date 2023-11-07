package assertjPractice;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.InstanceOfAssertFactories.STRING;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import java.util.ArrayList;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;
import streamspractice.Employee;

@HelidonTest
public class OtherImpAssertions {

  @Test
  void testOtherAssertions() {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("Sudheer");
    arrayList.add("Sudheer");
    arrayList.add("Manoja");
    arrayList.add("Venkat");

    assertThat(arrayList)
        .first(as(InstanceOfAssertFactories.STRING))
        .startsWith("Sud")
        .isEqualTo("Sudheer");
    assertThat(arrayList).last(as(STRING)).isEqualTo("Venkat");
    assertThat(arrayList).element(1, as(STRING)).isEqualTo("Sudheer");

    // This singleElement method makes suere that the collection has only a single element in it
    ArrayList<String> arrayList1 = new ArrayList<>();
    arrayList1.add("Dimbu");
    assertThat(arrayList1).singleElement().isEqualTo("Dimbu");

    // Filtering starts here
    // Filtering using a predicate

    assertThat(arrayList)
        .filteredOn(d -> d.contains("a"))
        .containsExactly("Sudheer", "Manoja", "Venkat");

    // Filtering using a property or field

    Employee employee = new Employee("Sudheer", 24, 15, "ECE");
    Employee employee1 = new Employee("Manikantha", 28, 25, "CSE");
    Employee employee2 = new Employee("Manoja", 23, 20, "MBBS");
    Employee employee3 = new Employee("Venkat", 30, 25, "MECH");

    ArrayList<Employee> employees = new ArrayList<>();
    employees.add(employee);
    employees.add(employee1);
    employees.add(employee2);
    employees.add(employee3);

    assertThat(employees).filteredOn("age", in(24, 28)).containsExactly(employee, employee1);
    assertThat(employees)
        .filteredOn(d -> d.getSalary() > 10)
        .containsExactly(employee, employee1, employee2, employee3);
    assertThat(employees)
        .filteredOn("age", not(24))
        .containsExactly(employee1, employee2, employee3);

    // Filtering on a function return value
    assertThat(employees).filteredOn(Employee::getDept, "ECE").containsExactly(employee);
  }
}
