/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.models;

import java.util.List;

public class Store {

    private long id;
    private String code;
    private String storeLineNumber;
    List<Employee> employeeList;
    List<Customer> customerList;

    public String toString() {
        return "Store[id: " + id + " code:" + code + " storeLineNumber:" + storeLineNumber + "]";
    }
}
