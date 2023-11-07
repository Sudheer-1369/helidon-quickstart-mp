/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package complexmodelmapperpractice.services.impl;

import complexmodelmapperpractice.CommonExceptions.DaoException;
import complexmodelmapperpractice.dao.EmployeeDao;
import complexmodelmapperpractice.entities.TraEmployee;
import complexmodelmapperpractice.models.Employee;
import complexmodelmapperpractice.services.EmployeeService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {

  ModelMapper mapper = new ModelMapper();
  @Inject private EmployeeDao employeeDao;

  @Transactional
  public Employee updateEmployee(Employee employee) throws DaoException {
    TraEmployee traEmployee = mapper.map(employee, TraEmployee.class);
    try {
      employeeDao.updateEmployee(traEmployee);
    } catch (Exception e) {
      throw e;
    }

    return mapper.map(traEmployee, Employee.class);
  }
}
