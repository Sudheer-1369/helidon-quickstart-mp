/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.dao.impl;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.dao.CustomerDao;
import ComplexModelMapperPractice.entities.TraCustomer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CustomerDaoImpl implements CustomerDao {


    @PersistenceContext(name = "ORCL")
    private EntityManager entityManager;

    public void printEntityManager() throws DaoException {
        System.out.println(entityManager);
    }

    public TraCustomer addCustomer(TraCustomer traCustomer) throws DaoException {

        return null;
    }

    public TraCustomer getCustomerById(long id) throws DaoException {

        return null;
    }

    public List<TraCustomer> getCustomersByFirstName(String firstName) throws DaoException {

        return null;
    }

    public List<TraCustomer> getAllCustomer(int page) throws DaoException {

        return null;
    }

    public void updateCustomer(TraCustomer traCustomer) throws DaoException {

    }

    public void deleteCustomerById(long id) throws DaoException {

    }

}
