/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package sample.practice.PreCon;

import com.oracle.hibernate.decs.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaPredicate {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("ORCL");
    }

    public static void main(String[] args) {
        entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        Predicate predicate = criteriaBuilder.equal(root.get("fullName"), "Sudheer1");

        criteriaQuery.where(predicate);

        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        List<User> userList = query.getResultList();

        userList.stream().forEach(a -> System.out.print(a.getFullName() + " "));

    }
}
