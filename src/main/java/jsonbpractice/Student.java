/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package jsonbpractice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonbPropertyOrder({"lastName", "firstName", "age", "section,fee"})
public class Student {


    @JsonbProperty("Last_Name")
    private String lastName;
    @JsonbProperty("First_Name")
    private String firstName;
    @JsonbProperty("Age")
    private int age;
    @JsonbTransient
    private int fee;
    @JsonbProperty("Class_Section")
    private String section;

}
