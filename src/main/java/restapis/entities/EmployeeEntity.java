/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "EMPLOYEE")
public class EmployeeEntity implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Column(name = "COMPANY_ID",insertable = false, updatable = false)
    private Long companyId;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "FIRST_NAME", columnDefinition = "varchar(40) default 'Shrutika'")
    private String firstName;
    @Column(name = "AGE", nullable = false)
    private Integer age;
    @Column(name = "SALARY")
    private Integer salary;
    @Column(name = "JOINING_DATE")
    private Timestamp joiningDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    public EmployeeEntity(Long id, Long companyId, String lastName, String firstName, Integer age, Integer salary) {
        this.id = id;
        this.companyId = companyId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.salary = salary;
    }

    public EmployeeEntity(Long id, String lastName, String firsName, int age, int salary, Timestamp joiningDate, CompanyEntity company) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firsName;
        this.age = age;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.company = company;
    }

    public EmployeeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Timestamp getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Timestamp joiningDate) {
        this.joiningDate = joiningDate;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firsName='" + firstName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                ", company=" + company +
                '}';
    }
}
