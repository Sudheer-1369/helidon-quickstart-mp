/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.services;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.models.Employee;

public interface EmployeeService {

  Employee updateEmployee(Employee employee) throws DaoException;
}
