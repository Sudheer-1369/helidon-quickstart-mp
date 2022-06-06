/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRA_EMPLOYEE")
public class TraEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "TRA_STORE_ID", nullable = false, updatable = false, insertable = false)
    private long storeId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "AGE")
    private int age;

    @Column(name = "SALARY")
    private long salary;

    @Column(name = "LANDLINE_NUMBER")
    private String landLineNumber;

    @ManyToOne
    @JoinColumn(name = "TRA_STORE_ID")
    private TraStore traStore;

    public String toString() {
        return "Employee[id: " + id + " firstName:" + firstName + " lastName:" + lastName + " age:" + age + " salary:" + salary + " landLineNumber:" + landLineNumber + " storeId:" + storeId + "]";
    }
}
