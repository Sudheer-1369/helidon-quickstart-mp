/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package StreamsPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExecution {

//    Let’s consider the following scenario, where we have been asked to give a list with those employees with salaries below $80,000 and
//    update their salaries with a 5% increase. The stream responsible for doing that would be the one shown below:
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("sudheer",24,11,"decs"));
        employeeList.add(new Employee("srini",30,26,"decs"));
        employeeList.add(new Employee("cyril",30,26,"decs"));
        employeeList.add(new Employee("Raman",35,30,"decs"));
        employeeList.add(new Employee("Jan",53,60,"decs"));

        employeeList.stream().map(e->new Employee("sudheer",24,11,"decs")).collect(Collectors.toList());
    }


}
