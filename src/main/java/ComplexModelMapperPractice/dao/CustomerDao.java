/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.dao;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.entities.TraCustomer;

import java.util.List;

public interface CustomerDao {

    public void printEntityManager() throws DaoException;

    public TraCustomer addCustomer(TraCustomer traCustomer) throws DaoException;

    public TraCustomer getCustomerById(long id) throws DaoException;

    public List<TraCustomer> getCustomersByFirstName(String firstName) throws DaoException;

    public List<TraCustomer> getAllCustomer(int page) throws DaoException;

    public void updateCustomer(TraCustomer traCustomer) throws DaoException;

    public void deleteCustomerById(long id) throws DaoException;

}
