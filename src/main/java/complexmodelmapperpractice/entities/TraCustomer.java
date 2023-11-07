/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package complexmodelmapperpractice.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRA_CUSTOMER")
public class TraCustomer {

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

  @Column(name = "MOBILE_NUMBER")
  private String mobileNumber;

  @ManyToOne
  @JoinColumn(name = "TRA_STORE_ID")
  private TraStore traStore;

  public String toString() {
    return "Employee[id: "
        + id
        + " firstName:"
        + firstName
        + " lastName:"
        + lastName
        + " age:"
        + age
        + " mobileNumber"
        + mobileNumber
        + "]";
  }
}
