/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package complexmodelmapperpractice.entities;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRA_STORE")
@ApplicationScoped
public class TraStore {

  @OneToMany(mappedBy = "traStore", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  List<TraEmployee> employeeList;

  @OneToMany(mappedBy = "traStore", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  List<TraCustomer> customerList;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private long id;

  @Column(name = "CODE")
  private String code;

  @Column(name = "STORELINE_NUMBER")
  private String storeLineNumber;

  public String toString() {
    return "Store[id:" + id + ", code:" + code + ", storeLineNumber:" + storeLineNumber + "]";
  }
}
