/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package complexmodelmapperpractice.services;

import complexmodelmapperpractice.commonexceptions.DaoException;
import complexmodelmapperpractice.models.Employee;

public interface EmployeeService {

  Employee updateEmployee(Employee employee) throws DaoException;
}
