/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package complexmodelmapperpractice.dao.impl;

import complexmodelmapperpractice.CommonExceptions.DaoException;
import complexmodelmapperpractice.dao.EmployeeDao;
import complexmodelmapperpractice.entities.TraEmployee;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@ApplicationScoped
public class EmployeeDaoImpl implements EmployeeDao {

  private static EntityManagerFactory entityManagerFactory;
  private EntityManager entityManager;

  {
    entityManagerFactory = Persistence.createEntityManagerFactory("ORCL");
  }

  @Transactional
  public TraEmployee addEmployee(TraEmployee traEmployee) throws DaoException {
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();

      entityManager.persist(traEmployee);

      entityManager.getTransaction().commit();

    } catch (Exception e) {
      throw new DaoException(
          "Exception Occcurred while adding the employee " + e.getMessage(), e.getCause());
    } finally {
      entityManager.close();
    }

    return traEmployee;
  }

  @Transactional
  public TraEmployee getEmployeeById(long id) throws DaoException {
    TraEmployee traEmployee = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();

      traEmployee = entityManager.find(TraEmployee.class, id);

      entityManager.getTransaction().commit();
    } catch (Exception e) {
      throw new DaoException(
          "Exception Occcurred while updating the employee " + e.getMessage(), e.getCause());
    } finally {
      entityManager.close();
    }

    return traEmployee;
  }

  @Transactional
  public List<TraEmployee> getEmployeeByFirstName(String firstName) throws DaoException {
    List<TraEmployee> traEmployeeList = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();

      traEmployeeList =
          entityManager
              .createNativeQuery("SELECT * FROM usersdb.TRA_EMPLOYEE WHERE FIRST_NAME = :firstName")
              .setParameter("firstName", firstName)
              .getResultList();

      entityManager.getTransaction().commit();
    } catch (Exception e) {
      throw new DaoException(
          "Exception Occcurred while fetching the employee list with firstname " + e.getMessage(),
          e.getCause());
    } finally {
      entityManager.close();
    }

    return traEmployeeList;
  }

  @Transactional
  public List<TraEmployee> getAllEmployee(int page, List<String> params) throws DaoException {

    List<TraEmployee> traEmployeeList = null;

    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();

      CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
      CriteriaQuery<TraEmployee> criteriaQuery = criteriaBuilder.createQuery(TraEmployee.class);
      Root<TraEmployee> root = criteriaQuery.from(TraEmployee.class);

      Predicate predicate = criteriaBuilder.conjunction();

      for (int i = 0; i < params.size(); i++) {
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?)");
        Matcher matcher = pattern.matcher(params.get(i));

        while (matcher.find()) {
          if (matcher.group(2).equalsIgnoreCase(">")) {
            predicate =
                criteriaBuilder.and(
                    predicate,
                    criteriaBuilder.greaterThanOrEqualTo(
                        root.get(matcher.group(1)), matcher.group(3)));
          } else if (matcher.group(2).equalsIgnoreCase("<")) {
            predicate =
                criteriaBuilder.and(
                    predicate,
                    criteriaBuilder.lessThanOrEqualTo(
                        root.get(matcher.group(1)), matcher.group(3)));
          } else if (matcher.group(2).equalsIgnoreCase(":")) {
            if (matcher.group(1).getClass() == String.class) {
              predicate =
                  criteriaBuilder.and(
                      predicate,
                      criteriaBuilder.like(
                          root.get(matcher.group(1)), "%" + matcher.group(3) + "%"));
            } else {
              predicate =
                  criteriaBuilder.and(
                      predicate,
                      criteriaBuilder.equal(root.get(matcher.group(1)), matcher.group(3)));
            }
          }
        }
      }

      criteriaQuery.where(predicate);
      criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
      TypedQuery<TraEmployee> typedQuery = entityManager.createQuery(criteriaQuery);
      traEmployeeList = typedQuery.getResultList();

      entityManager.getTransaction().commit();
    } catch (Exception e) {
      throw new DaoException(
          "Exception occurred while fetching the list of employees " + e.getMessage(),
          e.getCause());
    } finally {
      entityManager.close();
    }

    return traEmployeeList;
  }

  @Transactional
  public void updateEmployee(TraEmployee traEmployee) throws DaoException {

    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();

      entityManager.merge(traEmployee);

      entityManager.getTransaction().commit();
    } catch (Exception e) {
      throw new DaoException(
          "Exception occurred while updating the employee " + e.getMessage(), e.getCause());
    } finally {
      entityManager.close();
    }
  }

  @Transactional
  public void deleteEmployee(long id) throws DaoException {
    TraEmployee traEmployee = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();

      traEmployee = entityManager.find(TraEmployee.class, id);

      entityManager.remove(traEmployee);
    } catch (Exception e) {
      throw new DaoException(
          "Exception occurred while deleting the employee " + e.getMessage(), e.getCause());
    } finally {
      entityManager.close();
    }
  }
}
