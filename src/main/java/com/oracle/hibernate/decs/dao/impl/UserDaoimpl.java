/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package com.oracle.hibernate.decs.dao.impl;

import com.oracle.hibernate.decs.common.exceptions.DaoException;
import com.oracle.hibernate.decs.dao.UserDao;
import com.oracle.hibernate.decs.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class UserDaoimpl implements UserDao {

    private static Logger logger = Logger.getLogger(UserDaoimpl.class.getName());

    //@PersistenceUnit(unitName = "ORCL")
    //EntityManagerFactory entityManagerFactory ;
    // @PersistenceContext(unitName = "ORCL", type = PersistenceContextType.TRANSACTION)
    // private EntityManager entityManager;

    private static EntityManagerFactory entityManagerFactory;
    // @PersistenceContext(unitName = "ORCL")
    private EntityManager entityManager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("ORCL");
    }

    @Transactional
    public void addUser(User user) throws DaoException {
        logger.info("EntityManager is : " + entityManager);


        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            entityManager.persist(user);
            //  user.setFullName("Patnana Sudheer");
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            logger.info("Exception occurred : " + e.getMessage());
        } finally {
            entityManager.close();
            //  entityManagerFactory.close();
        }


    }

    public User getUserById(long userId) throws DaoException {

        User user = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            user = entityManager.find(User.class, userId);

            entityManager.getTransaction().commit();

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            logger.info("Exception Occurred : " + e.getMessage());
            throw new DaoException("Exception Occurred : " + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return user;
    }

    public User getUserByCode(long userCode) throws DaoException {

        User user = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            user = entityManager.find(User.class, userCode);

            entityManager.getTransaction().commit();

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            logger.info("Exception Occurred : " + e.getMessage());
            throw new DaoException("Exception Occurred : " + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return user;
    }

    public List<User> getAllUsers() throws DaoException {

        List<User> userList = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            userList = entityManager.createNamedQuery("findAllUsers").getResultList();
        } catch (NoResultException e) {
            return userList;
        } catch (Exception e) {
            throw new DaoException("Exception Occurred : " + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return userList;
    }

    public void updateUser(User user) throws DaoException {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            entityManager.merge(user);
        } catch (Exception e) {
            throw new DaoException("Exception Occurred : " + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void deleteUserById(long userId) throws DaoException {

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            entityManager.createNamedQuery("deleteUserById").setParameter("ID", userId).executeUpdate();
        } catch (Exception e) {
            throw new DaoException("Exception Occurred : " + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void deleteUserByCode(String userCode) throws DaoException {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            entityManager.createNamedQuery("deleteUserByCode").setParameter("CODE", userCode).executeUpdate();
        } catch (Exception e) {
            throw new DaoException("Exception Occurred : " + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

}
