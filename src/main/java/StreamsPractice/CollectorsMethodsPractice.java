/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package StreamsPractice;


import java.util.*;
import java.util.stream.Collectors;

public class CollectorsMethodsPractice {

    public static void main(String[] args) {

        Employee emp = new Employee("sudheer", 25, 20, "ECE");
        Employee emp1 = new Employee("Rajnikanth", 24, 25, "ECE");
        Employee emp2 = new Employee("Venkat", 28, 30, "CSE");
        Employee emp3 = new Employee("Manoja", 22, 40, "CSE");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp);
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        // Listing
        List<Employee> employees = employeeList.stream().filter(s -> s.age > 20).collect(Collectors.toList());
        System.out.println(employees);

        //Setting
        Set<Employee> employeeSet = employeeList.stream().filter(s -> s.age > 20).collect(Collectors.toSet());
        System.out.println(employeeSet);

        //Concatenate to a string
        String joined = employeeList.stream().map(Employee::getName).collect(Collectors.joining(", "));
        System.out.println(joined);

        //Adding
        int totalSalary = employeeList.stream().map(Employee::getSalary).reduce(0, (a, b) -> a + b);
        System.out.println("method-1 salary is " + totalSalary);

        totalSalary = employeeList.stream().mapToInt(Employee::getSalary).sum();
        System.out.println("method-2 salary is " + totalSalary);

        totalSalary = employeeList.stream().collect(Collectors.summingInt(Employee::getSalary));
        System.out.println("method-3 salary is " + totalSalary);

        //avg
        OptionalDouble avgSalary = employeeList.stream().mapToInt(Employee::getSalary).average();
        System.out.println(avgSalary.getAsDouble());

        //Grouping
        Map<String, List<Employee>> byDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept));
        System.out.println("Grouping by department is " + byDept);

        Map<Boolean, List<Employee>> bySalaryLevel = employeeList.stream().collect(Collectors.partitioningBy(s -> s.getSalary() >= 25));
        System.out.println("Partitioning based on salaries " + bySalaryLevel);

    }
}
