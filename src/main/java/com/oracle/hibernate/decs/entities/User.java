/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package com.oracle.hibernate.decs.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "USERS")

@NamedNativeQueries({
        @NamedNativeQuery(name = "findAllUsers", query = "SELECT FULLNAME,EMAIL,PASSWORD FROM usersdb.USERS", resultSetMapping = "UserResult"),
        @NamedNativeQuery(name = "deleteUserById", query = "DELETE FROM usersdb.USERS WHERE ID= :ID"),
        @NamedNativeQuery(name = "deleteUserByCode", query = "DELETE FROM usersdb.USERS WHERE CODE= :CODE"),
        @NamedNativeQuery(name = "getUserById", query = "SELECT FULLNAME,EMAIL,PASSWORD FROM usersdb.USERS WHERE CODE= :CODE")
}
)

@SqlResultSetMapping(name = "UserResult", classes = {
        @ConstructorResult(targetClass = User.class, columns = {
                @ColumnResult(name = "FULLNAME", type = String.class),
                @ColumnResult(name = "EMAIL", type = String.class),
                @ColumnResult(name = "PASSWORD", type = String.class)
        })
})
public class User {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "FULLNAME")
    String fullName;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "dob")
    Date dob;


    public User(String fullName, String email, Date dob) {
        this.fullName = fullName;
        this.email = email;
        this.dob = dob;
    }


    public User() {
        // TODO Auto-generated constructor stub
    }
}
