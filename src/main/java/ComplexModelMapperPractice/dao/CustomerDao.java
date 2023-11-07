/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.dao;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.entities.TraCustomer;
import java.util.List;

public interface CustomerDao {

  void printEntityManager() throws DaoException;

  TraCustomer addCustomer(TraCustomer traCustomer) throws DaoException;

  TraCustomer getCustomerById(long id) throws DaoException;

  List<TraCustomer> getCustomersByFirstName(String firstName) throws DaoException;

  List<TraCustomer> getAllCustomer(int page) throws DaoException;

  void updateCustomer(TraCustomer traCustomer) throws DaoException;

  void deleteCustomerById(long id) throws DaoException;
}
