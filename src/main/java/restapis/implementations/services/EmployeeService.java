/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.implementations.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import restapis.dto.Employee;
import restapis.entities.EmployeeEntity;
import restapis.implementations.dao.EmployeeDao;
import restapis.mappers.EmployeeMapper;

@ApplicationScoped
public class EmployeeService
    extends AbstractCrudService<Long, EmployeeEntity, Employee, EmployeeMapper, EmployeeDao> {

  @Inject
  public EmployeeService(EmployeeMapper mapper, EmployeeDao dao) {
    super(mapper, dao);
  }
}
