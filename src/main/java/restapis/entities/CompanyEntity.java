/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.entities;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "COMPANY")
@NamedQuery(name = "getFew", query = "select e.name, e.phoneNumber from COMPANY e")
@FilterDef(name = "newbranches", parameters = @ParamDef(name = "openingDate", type = "timestamp"))
@Filter(name = "newbranches", condition = "OPENING_DATE >= :openingDate")
public class CompanyEntity implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID")
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String name;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "OPENING_DATE")
    @NotNull(message = "The opening date is mandatory")
    private Timestamp openingDate;

    @JoinColumn(name = "COMPANY_ID")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EmployeeEntity> employeeEntities;

    public CompanyEntity(Long id, String name, String phoneNumber, Timestamp openingDate, List<EmployeeEntity> employeeEntities) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.openingDate = openingDate;
        this.employeeEntities = employeeEntities;
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

    public Timestamp getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Timestamp openingDate) {
        this.openingDate = openingDate;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", openingDate='"+openingDate+'\''+
                '}';
    }
}
