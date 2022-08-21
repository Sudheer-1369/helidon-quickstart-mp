/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "COMPANY")
public class CompanyEntity implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID")
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String name;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @JoinColumn(name = "COMPANY_ID")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<EmployeeEntity> employeeEntities;

    public CompanyEntity(Long id, String name, String phoneNumber, List<EmployeeEntity> employees) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.employeeEntities = employees;
    }

    public CompanyEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(List<EmployeeEntity> employees) {
        this.employeeEntities = employees;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
