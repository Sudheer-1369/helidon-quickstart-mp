/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private long salary;
    private String landLineNumber;
    private Store store;

    public String toString() {
        return "Employee[id: " + id + " firstName:" + firstName + " lastName:" + lastName + " age:" + age + " salary:" + salary + " landLineNumber" + landLineNumber + "]";
    }
}
