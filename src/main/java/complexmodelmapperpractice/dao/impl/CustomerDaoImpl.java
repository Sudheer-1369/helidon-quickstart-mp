/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package complexmodelmapperpractice.dao.impl;

import complexmodelmapperpractice.CommonExceptions.DaoException;
import complexmodelmapperpractice.dao.CustomerDao;
import complexmodelmapperpractice.entities.TraCustomer;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

  public void updateCustomer(TraCustomer traCustomer) throws DaoException {}

  public void deleteCustomerById(long id) throws DaoException {}
}
