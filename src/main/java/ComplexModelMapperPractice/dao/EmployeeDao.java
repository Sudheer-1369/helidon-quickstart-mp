/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.dao;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.entities.TraEmployee;
import java.util.List;

public interface EmployeeDao {

  TraEmployee addEmployee(TraEmployee traEmployee) throws DaoException;

  TraEmployee getEmployeeById(long id) throws DaoException;

  List<TraEmployee> getEmployeeByFirstName(String firstName) throws DaoException;

  List<TraEmployee> getAllEmployee(int page, List<String> params) throws DaoException;

  void updateEmployee(TraEmployee traEmployee) throws DaoException;

  void deleteEmployee(long id) throws DaoException;
}
