/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.implementations.dao;

import javax.enterprise.context.ApplicationScoped;
import restapis.entities.EmployeeEntity;

@ApplicationScoped
public class EmployeeDao extends BaseDaoImpl<Long, EmployeeEntity> {

  public EmployeeDao() {
    super(EmployeeEntity.class);
  }
}
